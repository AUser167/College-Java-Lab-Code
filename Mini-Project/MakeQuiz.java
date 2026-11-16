import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.sql.*;

class QuestionItem {
	String QuestionType;
	String question;
	String[] options;
	String answer;
	boolean[] CorrectOptions;
	
	QuestionItem(String QuestionType, String question, String answer) {
		this.QuestionType = QuestionType;
		this.question = question;
		this.answer = answer;
		this.options = new String[] {"", "", "", ""};
		this.CorrectOptions = new boolean[] {false, false, false, false};
	}
	
	QuestionItem(String QuestionType, String question, String[] options, boolean[] CorrectOptions) {
		this.QuestionType = QuestionType;
		this.question = question;
		this.answer = "";
		this.options = options;
		this.CorrectOptions = CorrectOptions;
	}
}

class MakeQuiz {
	public static QuestionItem SingleOption(Scanner sc) {
		String QuestionType = "SingleOption";
		String[] options = new String[] {"", "", "", ""};
		String question;
		boolean[] CorrectOptions = new boolean[] {false, false, false, false};
		
		System.out.print("Enter question: ");
		question = sc.nextLine();
		
		for (int i = 0 ; i < 4; i++) {
			System.out.print("Enter option " + (i+1) + ": ");
			options[i] = sc.nextLine();
		}
		
		System.out.print("Enter correct option number: ");
		int correct = sc.nextInt();
		sc.nextLine();
		
		CorrectOptions[correct-1] = true;
		
		return new QuestionItem(QuestionType, question, options, CorrectOptions);
	}
	
	public static QuestionItem MultiOption(Scanner sc) {
		String QuestionType = "MultiOption";
		String[] options = new String[] {"", "", "", ""};
		String question;
		boolean[] CorrectOptions = new boolean[] {false, false, false, false};
		
		System.out.print("Enter question: ");
		question = sc.nextLine();
		
		for (int i = 0 ; i < 4; i++) {
			System.out.print("Enter option " + i + 1 + ": ");
			options[i] = sc.nextLine();
			
			System.out.print("Type 1 if correct: ");
			int correct = sc.nextInt();
			sc.nextLine();
			
			CorrectOptions[i] = (correct==1);
		}
		
		return new QuestionItem(QuestionType, question, options, CorrectOptions);
	}
	
	public static QuestionItem ShortAnswer(Scanner sc) {
		String QuestionType = "ShortAnswer";
		String question;
		String answer;
		
		System.out.print("Enter question: ");
		question = sc.nextLine();
		
		System.out.print("Enter answer: ");
		answer = sc.nextLine();
		
		return new QuestionItem(QuestionType, question, answer);
	}
	
	public static char bool_to_string(boolean input) {
		if (input) return '1';
		return '0';
	}
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/QuizApp";
		String username = "root";
		String password = "password";
		try {
			int choice = 0;
			Scanner sc = new Scanner(System.in);
			List<QuestionItem> quiz = new ArrayList<>();
			
			do {
				System.out.print("Type:\n1 for question with single-correct option\n2 for question with multi-correct option\n3 for short answer\n0 to exit\nEnter choice: ");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
					case 0:
						break;
					case 1:
						quiz.add(SingleOption(sc));
						break;
					case 2:
						quiz.add(MultiOption(sc));
						break;
					case 3:
						quiz.add(ShortAnswer(sc));
						break;
					default:
						System.out.println("Invalid Choice");
				}
			} while(choice!=0);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			url, username, password);
			int idx = 1;
			Statement st = con.createStatement();
			st.executeUpdate("TRUNCATE quiz");
			for (QuestionItem question: quiz) {
				String query = "INSERT INTO quiz VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, idx);
				ps.setString(2, question.QuestionType);
				ps.setString(3, question.question);
				ps.setString(4, question.options[0]);
				ps.setString(5, question.options[1]);
				ps.setString(6, question.options[2]);
				ps.setString(7, question.options[3]);
				
				String option = "";
				option += bool_to_string(question.CorrectOptions[0]);
				option += bool_to_string(question.CorrectOptions[1]);
				option += bool_to_string(question.CorrectOptions[2]);
				option += bool_to_string(question.CorrectOptions[3]);
				
				ps.setString(8, option);
				ps.setString(9, question.answer);
				
				ps.executeUpdate();
				idx++;
				ps.close();
			}
			st.close();			
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}