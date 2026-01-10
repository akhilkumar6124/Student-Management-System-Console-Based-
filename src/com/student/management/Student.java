public class Student{
    private int id;
    private String name;
    private int age;
    public Student(int id,String name,int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String toFileString(){
        return id+","+name+","+age;
    }
    public static Student fromFileString(String line){
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        String name = parts[1];
        int age = Integer.parseInt(parts[2].trim());
        return new Student(id,name,age);
    }
    public void display(){
        System.out.println("Id: "+id+" Name: "+name+" age: "+age);
    }
}