// StudentDataEntry.java
// Name: Rithikaa Redde
// PRN: 23070126101
// Batch: B1

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDataEntry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();
        
        while (true) {
            System.out.println("\n----- STUDENT DATA ENTRY -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // consume newline
                
                if (choice == 8) {
                    System.out.println("Exiting...");
                    break;
                }
                
                String prn, name;
                switch (choice) {
                    case 1:
                        operations.addStudent(scanner);
                        break;
                    case 2:
                        operations.displayAllStudents();
                        break;
                    case 3:
                        System.out.print("Enter PRN: ");
                        prn = scanner.nextLine();
                        operations.searchByPrn(prn);
                        break;
                    case 4:
                        System.out.print("Enter Name: ");
                        name = scanner.nextLine();
                        operations.searchByName(name);
                        break;
                    case 5:
                        System.out.print("Enter Position (index): ");
                        int position = scanner.nextInt();
                        operations.searchByPosition(position);
                        break;
                    case 6:
                        System.out.print("Enter PRN of student to update: ");
                        prn = scanner.nextLine();
                        operations.updateStudent(prn, scanner);
                        break;
                    case 7:
                        System.out.print("Enter PRN of student to delete: ");
                        prn = scanner.nextLine();
                        operations.deleteStudent(prn);
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
                scanner.nextLine(); // clear the buffer
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
