import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
    private String firstName;
    private String lastName;
    private int studentId;
    private int age;
    private String college;
    private String department;
    private int years;
    private double gpa;

    public Student(String firstName, String lastName, int studentId, int age, String college, String department, int years, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.age = age;
        this.college = college;
        this.department = department;
        this.years = years;
        this.gpa = gpa;
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName +
                ", lastName=" + lastName +
                ", studentId=" + studentId +
                ", age=" + age +
                ", college=" + college +
                ", department=" + department +
                ", years=" + years +
                ", gpa=" + gpa + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("HARAMAYA UNIVERSITY STUDENT REGISTRAR SYSTEM");

        // Inputting multiple students
        try {
            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); // clear the input buffer

            for (int i = 0; i < numStudents; i++) {
                System.out.println("ENTER STUDENTS " + (i + 1) + ":");
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // clear the input buffer

                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // clear the input buffer

                System.out.print("College: ");
                String college = scanner.nextLine();

                System.out.print("Department: ");
                String department = scanner.nextLine();

                System.out.print("Years: ");
                int years = scanner.nextInt();
                scanner.nextLine(); // clear the input buffer

                System.out.print("GPA: ");
                double gpa = scanner.nextDouble();
                scanner.nextLine(); // clear the input buffer

                Student student = new Student(firstName, lastName, studentId, age, college, department, years, gpa);
                students.add(student);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        // Register students based on GPA
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
            try {
                if (student.getGpa() >= 1.6 && student.getGpa() <= 4) {
                    System.out.println(student);
                } else if (student.getGpa() > 4) {
                    System.out.println("invalid GPA ");
                } else
                    System.out.println(" faild! The gpa is smaller than 1.6");

            } catch (Exception e) {
                System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " cannot be registered. Reason: " + e.getMessage());
            }
        }

       scanner.close();
    }
}