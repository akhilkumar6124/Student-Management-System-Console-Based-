
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
       int id = readInt("Enter ID: ");
       if(isDuplicate(id)){
        System.out.println("Student with this ID already exists.");
        return;
       }
       String name = readNonEmptyString("Enter Name :");
       int age = readInt("Enter Age : ");
       students.add(new Student(id, name, age));
       saveToFile();
       System.out.println("Student Added Succesfully...");
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
        int id = readInt("Enter Student ID for Search: ");
        for(Student student : students){
            if(student.getId()==id){
                student.display();
                return;
            }
        }
        System.out.println("Student Not Found...");
    }
    public void updateStudent(){
        int id = readInt("Enter Student ID to Update: ");
        for(Student student : students){
            if(student.getId()==id){
                String name = readNonEmptyString("Enter New Name: ");
                int age = readInt("Enter New Age: ");
                student.setName(name);
                student.setAge(age);
                saveToFile();
                System.out.println("Student Updated Succesfully...");
                return;
            }
        }
        System.out.println("Student Not Found...");
    }
    public void deleteStudent(){
        int id = readInt("Enter student ID to Delete...");
        for(Student student : students){
            if(student.getId()==id){
                students.remove(student);
                saveToFile();
                System.out.println("Student Deleted Succesfully...");
                return;
            }
        }
        System.out.println("Student Not Found...");
    }
    public StudentService() {
        System.out.println("📂 Working Directory: " + System.getProperty("user.dir"));
        loadFromFile();
    }
    private int readInt(String message){
        while (true) { 
            try {
                System.out.println(message);
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid number...");
            }
        }
    }
    private String readNonEmptyString(String message){
        while (true) { 
            System.out.println("message");
            String input = scan.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("This feild cannot be empty...");
        }
    }
    private boolean isDuplicate(int id){
        for(Student student : students){
            if(student.getId()==id){
                return true;
            }
        }
        return false;
    }
    public void sortById(){
        students.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
        System.out.println("Students sorted By ID...");
        viewStudents();
    }
    public void sortByName(){
        students.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("Students Sorted By Name...");
        viewStudents();
    }
    public void sortByAge(){
        students.sort((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("Students Sorted By Age...");
        viewStudents();
    }
    public void filterByAgeRange(){
        int minAge = readInt("Enter minimum age: ");
        int maxAge = readInt("Enter maximum age: ");
        boolean found = false;
        for(Student student : students){
            if(student.getAge() >= minAge && student.getAge() <= minAge){
                student.display();
                found = true;
            }
        }
        if(!found){
            System.out.println("No Student Found In The Range...");
        }
    }
    public void filterByName(){
        String keyword = readNonEmptyString("Enter name Keyword: ").toLowerCase();
        boolean found = false;
        for(Student student : students){
            if(student.getName().toLowerCase().contains(keyword)){
                student.display();
                found = true;
            }
        }
        if(!found){
            System.out.println("No Student Found in this Age Range...");
        }
    }
}