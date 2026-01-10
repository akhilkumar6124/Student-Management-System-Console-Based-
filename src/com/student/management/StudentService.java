
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService{
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private final String FILE_NAME = "StudentDetails.txt";

    private void loadFromFile(){
        File file = new File(FILE_NAME);
        if(!file.exists()) return;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine())!=null){
                students.add(Student.fromFileString(line));
            }
        }catch(IOException e){
            System.out.println("Error loading file...");
        }
    }
    private void saveToFile() {
    File file = new File(FILE_NAME);

    try {
        if (!file.exists()) {
            file.createNewFile();
            System.out.println(" File created: " + file.getAbsolutePath());
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Student student : students) {
            writer.write(student.toFileString());
            writer.newLine();
        }
        writer.close();

        System.out.println(" Data written to file successfully.");

    } catch (IOException e) {
        System.out.println(" Error saving file: " + e.getMessage());
    }
}

    public void addStudent(){
        System.out.println("Enter ID : ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Name :");
        String name = scan.nextLine();
        System.out.println("Enter Age :");
        int age = scan.nextInt();
        students.add(new Student(id, name, age));
        saveToFile();
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
                saveToFile();
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
                saveToFile();
                return;
            }
        }
        System.out.println("Student not found...");
    }
    public StudentService() {
        System.out.println("📂 Working Directory: " + System.getProperty("user.dir"));
        loadFromFile();
    }
}