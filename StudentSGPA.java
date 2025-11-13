import java.util.Scanner;

class Student {
    String usn, name;
    int[] credits, marks;
    int n;

    void acceptDetails() {
        Scanner s = new Scanner(System.in);
        System.out.print("USN: "); usn = s.nextLine();
        System.out.print("Name: "); name = s.nextLine();
        System.out.print("Number of subjects: "); n = s.nextInt();

        credits = new int[n];
        marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Credits for subject " + (i + 1) + ": ");
            credits[i] = s.nextInt();
            System.out.print("Marks for subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
        }
    }

    double calculateSGPA() {
        int totalCredits = 0;
        double totalPoints = 0;
        for (int i = 0; i < n; i++) {
            totalCredits += credits[i];
            totalPoints += credits[i] * getGradePoint(marks[i]);
        }
        return totalPoints / totalCredits;
    }

    double getGradePoint(int m) {
        if (m >= 90) return 10;
        else if (m >= 80) return 9;
        else if (m >= 70) return 8;
        else if (m >= 60) return 7;
        else if (m >= 50) return 6;
        else if (m >= 40) return 5;
        else return 0;
    }

    void displayDetails() {
        System.out.println("----Student details----");
        System.out.println("Name: " + name);
        System.out.printf("SGPA: %.2f\n", calculateSGPA());
    }
}

public class StudentSGPA {
    public static void main(String[] args) {
        Student s = new Student();
        s.acceptDetails();
        s.displayDetails();
    }
}
