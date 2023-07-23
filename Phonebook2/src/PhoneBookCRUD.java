import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class PhoneBookCRUD  {
	
	public static boolean create(String name , Long phone , String city ) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("INSERT INTO phonebook(Name,ContactNo,City)VALUES(? , ? , ?)");
		ps.setString(1, name);
		ps.setLong(2, phone);
		ps.setString(3, city);
		ps.execute();
		con.close();
		return true;
		}	
	
	
	private static String updateName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the slNo");
		int slno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name--");
		String name = sc.nextLine();
		String update = "UPDATE phoneBook SET Name='"+name+"' WHERE SlNo="+slno;
		return update;
	}
	
	private static String updateContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the slNo");
		int slno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the contact no");
		Long contact = sc.nextLong();
		sc.nextLine();
		String contactNo = "UPDATE phoneBook SET ContactNo='"+contact+"' WHERE SlNo="+slno;
		return contactNo;
	}
	
	private static String updateCity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the slNo");
		int slno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the city name");
		String city = sc.nextLine();
		String updateCity = "UPDATE phoneBook SET City='"+city+"' WHERE SlNo="+slno;
		return updateCity;
	}
	
	public static void update() throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?user=root&password=root");
		Statement st = con.createStatement();
		System.out.println("to update name type 1\nto update contact no type 2\nto update city type 3");
		int n = sc.nextInt();
			switch(n) {
			case 1: {
				st.execute(PhoneBookCRUD.updateName());
				System.out.println("Name updated successfully");
			}break;
			case 2: {
				st.execute(PhoneBookCRUD.updateContact());
				System.out.println("Contact number updated successfully");
			}break;
			case 3: {
				st.execute(PhoneBookCRUD.updateCity());
				System.out.println("City name updated successfully");
			}break;
			
			}
			con.close();
			sc.close();
		}
		
	public static void readData() throws Exception{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?user=root&password=root");
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM phonebook");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getLong(3));
			System.out.println(rs.getString(4));
			System.out.println("-----------");
		}
		con.close();
		System.out.println("All data fetch successfully");
	}
	
	public static void delete() throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook?user=root&password=root");
		
		Statement st = con.createStatement();
		
		System.out.println("If you want to delete the column select the Sl No.");
		String deleteValue = sc.nextLine();
		
		String delete = "DELETE FROM phonebook WHERE SlNo="+deleteValue;
		st.execute(delete);
		con.close();
		sc.close();
		System.out.println("deleted Successfully");
	}
}
