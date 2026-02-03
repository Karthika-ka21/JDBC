package studentdata;

import java.util.Scanner;

public class StudentDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO OUR SCHOOL");
		boolean flag = true;
		while (flag) {
			System.out.println("Operations that can be performed...");
			System.out.println("1.Insert Student Data");
			System.out.println("2.Update Student Data");
			System.out.println("3.View Student Data");
			System.out.println("4.Delete Student Data");
			System.out.println("5. Exit");
			System.out.println("Select an Option...");
			int c = sc.nextInt();
			Student st = new Student();
			StudentService service=new StudentService();
			switch (c) {
			
			case 1:	
				System.out.println("Enter Student id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Student name");
				String name = sc.nextLine();
				System.out.println("Enter student age");
				int age = sc.nextInt();
				
				st.setId(id);
				st.setName(name);
				st.setAge(age);
				int res = service.save(st);
				if (res != 0)
					System.out.println("Data inserted successfully");
				break;
			case 2:
				Student s2=new Student();
				System.out.println("Enter the id of student you want to update");
				int i=sc.nextInt();
				s2.setId(i);
				
				
				sc.nextLine();
				System.out.println("Enter field to be updated");
				String field=sc.nextLine();
				
				System.out.println("enter the new value");
				String value=sc.nextLine();
				if(field.equals("name"))
					s2.setName(value);
				else
					s2.setAge(Integer.parseInt(value));
				int res2=service.update(s2,field);
				if (res2 != 0)
					System.out.println("Data updated successfully");
				break;
			case 3:
				service.fetch();
			case 4:
				System.out.println("enter the id of student 2you want to delete");
				int id1=sc.nextInt();
				int res3=service.delete(id1);
				if(res3!=0)
					System.out.println("deletion successfull");
				break;
			case 5:
				if(service.exit())
					flag = false;
				break;
			default:
				System.out.println("enter valid option");
			}
			

		}

	}

}
