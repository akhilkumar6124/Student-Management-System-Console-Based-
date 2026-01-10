
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
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort by ID");
            System.out.println("7. Sort by Name");
            System.out.println("8. Sort by Age");
            System.out.println("9. Filter by Age Range");
            System.out.println("10. Filter by Name");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1 -> 
                        service.addStudent();
                case 2 -> 
                        service.viewStudents();
                case 3 -> 
                        service.searchStudent();
                case 4 -> 
                        service.updateStudent();
                case 5 -> 
                        service.deleteStudent();
                case 6 -> 
                        service.sortById();
                case 7 -> 
                        service.sortByName();
                case 8 -> 
                        service.sortByAge();
                case 9 -> 
                        service.filterByAgeRange();
                case 10 -> 
                        service.filterByName();
                case 11 -> 
                        System.out.println(" Goodbye!");
                default -> 
                        System.out.println(" Invalid choice!");
            }
        } while (choice!=11);
        scan.close();
    }
}