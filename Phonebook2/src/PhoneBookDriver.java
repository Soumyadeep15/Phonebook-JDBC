import java.util.Scanner;

public class PhoneBookDriver {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		
		boolean flag = true;
		while(flag) {
			System.out.println("------PHONEBOOK------\n\ntype '1' to create contact\ntype '2' to update\ntype '3' to read the table data\ntype '4' to delete the data\ntype '5' to exit");
			int n = sc.nextInt();
			switch(n) {
			case 1: {
				System.out.println("Enter the name");
				String name = sc.next();
				sc.nextLine();
				System.out.println("Enter the contact Number");
				Long phone = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter the city");
				String city = sc.nextLine();
				boolean result = PhoneBookCRUD.create(name, phone, city);
				if(result) System.out.println("Data inserted successfully");
				else System.out.println("Something is fishy");
			}break;
			case 2: {
				PhoneBookCRUD.update();
			}break;
			case 3: {
				PhoneBookCRUD.readData();
			}break;
			case 4: {
				PhoneBookCRUD.delete();
			}break;
			case 5: {
				flag = false;
				System.out.println("Thank You for using PHONEBOOK");
			}
			
			}
		}
		sc.close();
	}

}
