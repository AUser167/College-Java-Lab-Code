import java.sql.*;

class DataBase_Connectivity {
	public static void main(String args[]) {
		String Url = "jdbc:mysql://localhost:3306/college";
		String username = "root";
		String password = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(Url, username, password);
			System.out.println("Connected");
			String query = "INSERT INTO Student VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, 101);
			ps.setString(2, "Rahul");
			ps.setInt(3, 85);
			ps.executeUpdate();
			System.out.println("Inserted");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Student");
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("Marks"));
			}
			rs.close();
			st.close();
			ps.close();
			conn.close();
		}
		catch (Exception e) {}
	}
}



