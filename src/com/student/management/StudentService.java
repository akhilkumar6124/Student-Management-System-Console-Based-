
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService{
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    public void addStudent(){
        System.out.println("Enter ID : ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Name :");
        String name = scan.nextLine();
        System.out.println("Enter Age :");
        int age = scan.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("Student added succesfully...");
    }
    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("Student Data Is Empty...");
            return;
        }
        for(Student student : students){
            student.display();
        }
    }
    public void searchStudent(){
        System.out.println("Enter Student ID to search:");
        int id = scan.nextInt();
        for(Student student : students){
            if(student.getId() == id){
                System.out.println("Student Found...");
                student.display();
                return;
            }
        }
        System.out.println("Student Not Found...");
    }
    public void updateStudent(){
        System.out.println("Enter Student ID to update: ");
        int id = scan.nextInt();
        scan.nextLine();
        for(Student student : students){
            if(student.getId() == id){
                System.out.println("Enter New Name: ");
                String name = scan.nextLine();
                System.out.println("Enter new age: ");
                int age = scan.nextInt();
                student.setName(name);
                student.setAge(age);
                System.out.println("Student Updated Succesfully...");
                return;
            }
        }
        System.out.println("Student not found...");
    }
    public void deleteStudent(){
        System.out.println("Enter Student ID to delete:");
        int id = scan.nextInt();
        for(Student student : students){
            if(student.getId() == id){
                students.remove(student);
                System.out.println("Student Deleted Succesfully...");
                return;
            }
        }
        System.out.println("Student not found...");
    }
}