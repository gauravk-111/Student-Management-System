import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StudentsManagement {

    private HashMap<String, Integer> studentsData = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    // Add Student
    public void studentsAdd() {
        try {
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine(); // Buffer clear

            studentsData.put(name, roll);
            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.nextLine(); // Clear buffer if wrong input
        }
    }

    // View All Students
    public void seeAllStudents() {
        if (studentsData.isEmpty()) {
            System.out.println("No Students Available");
            return;
        }

        System.out.println("\nStudents Data:");
        for (Map.Entry<String, Integer> entry : studentsData.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " | Roll No: " + entry.getValue());
        }
    }

    // Delete Student
    public void deleteStudent() {
        try {
            System.out.print("Enter Student Name to Delete: ");
            String name = sc.nextLine();

            if (studentsData.containsKey(name)) {
                studentsData.remove(name);
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("No Student Found");
            }

        } catch (Exception e) {
            System.out.println("Error Occurred");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        StudentsManagement sm = new StudentsManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Buffer clear

            switch (choice) {
                case 1:
                    sm.studentsAdd();
                    break;

                case 2:
                    sm.seeAllStudents();
                    break;

                case 3:
                    sm.deleteStudent();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}