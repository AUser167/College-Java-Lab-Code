import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
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

class ApplyQuiz {
	public static boolean SingleOption(Scanner sc, QuestionItem question) {
		System.out.println(question.question);
		for (int i = 0; i < 4; i++) {
			System.out.println("Option " + (i + 1) + ": " + question.options[i]);
		}
		System.out.print("Choose one correct option: ");
		int option = sc.nextInt();
		sc.nextLine();
		
		if (question.CorrectOptions[option - 1]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean MultiOption(Scanner sc, QuestionItem question) {		
		boolean correct = true;
		
		System.out.println(question.question);
		for (int i = 0; i < 4; i++) {
			System.out.println("Option " + (i + 1) + ": " + question.options[i]);
		}
		System.out.println("Choose multi correct option: ");
		for (int i = 0; i < 4; i++) {
			System.out.print("1 if correct for Option " + (i + 1) + ": ");
			int option = sc.nextInt();
			sc.nextLine();
			if (option == 1 && !question.CorrectOptions[i]) {
				correct = false;
			}
			else if (option != 1 && question.CorrectOptions[i]) {
				correct = false;
			}
		}
		
		return correct;
	}
	
	public static boolean ShortAnswer(Scanner sc, QuestionItem question) {		
		boolean correct = true;
		String answer;
		
		System.out.println(question.question);
		System.out.print("Enter short answer: ");
		answer = sc.nextLine();
		
		return answer.toLowerCase().equals(question.answer.toLowerCase());
	}
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/QuizApp";
		String username = "root";
		String password = "password";
		try {
			Scanner sc = new Scanner(System.in);
			QuestionItem question1;
			List<QuestionItem> quiz = new ArrayList<>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			url, username, password);
			int idx = 1;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM quiz");
			while (rs.next()) {
				int id = rs.getInt("id");
				String quiz_type = rs.getString("quiz_type");
				String question = rs.getString("question");
				String options[] = {rs.getString("optionA"), rs.getString("optionB"), rs.getString("optionC"), rs.getString("optionD")};
				String optionAnswers = rs.getString("option_answers");
				boolean[] option_answers = new boolean[] {optionAnswers.charAt(0)=='1', optionAnswers.charAt(1)=='1', optionAnswers.charAt(2)=='1', optionAnswers.charAt(3)=='1'};
				String answer = rs.getString("answer");
				if (quiz_type.equals("SingleOption") || quiz_type.equals("MultiOption")) {
					question1 = new QuestionItem(quiz_type, question, options, option_answers);
					quiz.add(question1);
				}
				else if (quiz_type.equals("ShortAnswer")) {
					question1 = new QuestionItem(quiz_type, question, answer);
					quiz.add(question1);
				}
				else {
					System.out.println("Invalid question type!");
				}
			}
			rs.close();
			st.close();			
			con.close();
			
			for (QuestionItem question: quiz) {
				if (question.QuestionType.equals("SingleOption")) {
					if (SingleOption(sc, question)) {
						System.out.println("\nCorrect\n");
					}
					else {
						System.out.println("\nWrong");
						for (int i=0;i<4;i++) {
							if (question.CorrectOptions[i]) {
								System.out.println("Option " + (i + 1) + " is correct");
							}
						}
						System.out.println();
					}
				}
				else if (question.QuestionType.equals("MultiOption")) {
					if (MultiOption(sc, question)) {
						System.out.println("\nCorrect\n");
					}
					else {
						System.out.println("\nWrong");
						for (int i=0;i<4;i++) {
							if (question.CorrectOptions[i]) {
								System.out.println("Option " + (i + 1) + " is correct");
							}
						}
						System.out.println();
					}
				}
				else if (question.QuestionType.equals("ShortAnswer")) {
					if (ShortAnswer(sc, question)) {
						System.out.println("\nCorrect\n");
					}
					else {
						System.out.println("\nWrong\n Correct answer is: " + question.answer);
					}
				}
				else {
					System.out.println("Invalid type occurred: " + question.QuestionType);
					return;
				}
				System.out.println("---------------------------------------------------------------------------------\n");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}