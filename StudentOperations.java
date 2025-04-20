import java.util.ArrayList;
import java.util.List;

public class StudentOperations {
    private List<Student> students = new ArrayList<>();

    // Add a student
    public void addStudent(java.util.Scanner scanner) {
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(prn, name, dob, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Search by PRN
    public void searchByPrn(String prn) throws StudentNotFoundException {
        boolean found = false;
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                System.out.println(student);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        }
    }

    // Search by Name
    public void searchByName(String name) throws StudentNotFoundException {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            throw new StudentNotFoundException("No student with the name " + name + " found.");
        }
    }

    // Search by Position (index)
    public void searchByPosition(int position) throws InvalidPositionException {
        if (position < 0 || position >= students.size()) {
            throw new InvalidPositionException("Invalid position!");
        }
        System.out.println(students.get(position));
    }

    // Update student marks
    public void updateStudent(String prn, java.util.Scanner scanner) throws StudentNotFoundException {
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();
                student.setMarks(newMarks);
                System.out.println("Marks updated successfully!");
                return;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    // Delete student
    public void deleteStudent(String prn) throws StudentNotFoundException {
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getPrn().equals(prn)) {
                studentToDelete = student;
                break;
            }
        }
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully!");
        } else {
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        }
    }
}
