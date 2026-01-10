
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        StudentService service = new StudentService();
        Scanner scan = new Scanner(System.in);
        int choice;
        do { 
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch(choice){
                case 1:
                    service.addStudent();
                    break;
                case 2:
                    service.viewStudents();
                    break;
                case 3:
                    service.searchStudent();
                    break;
                case 4:
                    service.updateStudent();
                    break;
                case 5:
                    service.deleteStudent();
                    break;
                case 6:
                    System.out.println("System Signing Off...");
                    break;
                default:
                    System.out.println("Invalid Choice...");
            }
        } while (choice!=6);
        scan.close();
    }
}