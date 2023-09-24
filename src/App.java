import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        adminInterface adminCLI = new adminInterface();
        adminCLI.start();
    }
}

class adminInterface {
    StudentMgmt studentMgmt = new StudentMgmt();
    Scanner scanner = new Scanner(System.in);

    public void start() {

        boolean isRunning = true;
        while (isRunning)  {
            System.out.println(
                    "\nWelcome to the Administration Interface. \nEnter 1 to add a new student.\nEnter 2 to update Student information.\nEnter 3 to retrieve Student details.\nEnter 4 to EXIT.");
            int choice = scanner.nextInt();
            String name;
            int ID;
            int age;
            double grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter the Students name: ");
                    name = scanner.next();
                    System.out.print("Enter the Students ID: ");
                    ID = scanner.nextInt();
                    System.out.print("Enter the Students age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter the Students grade: ");
                    grade = scanner.nextDouble();
                    studentMgmt.addStudent(name, ID, age, grade);
                    break;
                case 2:
                    System.out.print("Enter the Students ID you wish to update: ");
                    ID = scanner.nextInt();
                    System.out.print("Enter the Students name: ");
                    name = scanner.next();
                    System.out.print("Enter the Students age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter the Students grade: ");
                    grade = scanner.nextDouble();
                    studentMgmt.updateStudent(ID, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter the Students ID: ");
                    ID = scanner.nextInt();
                    System.out.println(studentMgmt.getStudentDetails(ID));
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class StudentMgmt {
    private static Student[] students = new Student[40];
    private int totalStudents = 0;

    public void addStudent(String name, int ID, int age, double grade) {
        Student newStudent = new Student(name, ID, age, grade);
        students[totalStudents] = newStudent;
        totalStudents++;
    }

    public void updateStudent(int ID, String name, int age, double grade) {
        for (Student student : students) {

            if (student != null && student.getID() == ID) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
            }
        }
    }

    public String getStudentDetails(int ID) {
        for (Student student : students) {
            if (student != null && student.getID() == ID) {
                return "Name: " + student.getName() + "\n" +
                        "ID: " + student.getID() + "\n" +
                        "Age: " + student.getAge() + "\n" +
                        "Grade: " + student.getGrade() + "\n";

            }
        }
        return "Invalid ID, no student found.";
    }
}

class Student {
    // State
    private String name;
    private int ID;
    private int age;
    private double grade;

    // Behavior

    public Student(String name, int ID, int age, double grade) { // constructor method
        setName(name);
        setID(ID);
        setAge(age);
        setGrade(grade);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getID() {
        return ID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

}