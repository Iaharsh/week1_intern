import java.util.*; 

public class GradeManagementSystem {
    static String calculateGrade(double avg) {
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 80) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        try {
            System.out.println("=================");
            System.out.println("  GRADE MANAGEMENT SYSTEM  ");
            System.out.println("=================\n");

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();

            // Arrays to store student data
            String[] names = new String[n];
            int[][] marks = new int[n][5];   
            double[] avg = new double[n];
            String[] grades = new String[n];

            // 🔹 Taking input for each student
            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Student " + (i + 1) + ":");
                System.out.print("Enter Name: ");
                names[i] = sc.next();

                int total = 0;

                // Taking marks for 5 subjects
                for (int j = 0; j < 5; j++) {
                    System.out.print("Enter marks for Subject " + (j + 1) + ": ");
                    marks[i][j] = sc.nextInt();
                    total += marks[i][j];
                }

                // Calculate average and grade
                avg[i] = total / 5.0;
                grades[i] = calculateGrade(avg[i]);
            }

            // 🔹 Display student report
            System.out.println("\n=========");
            System.out.println("    REPORT CARD    ");
            System.out.println("===========");
            System.out.printf("%-10s %-10s %-10s %-10s\n", "Name", "Total", "Average", "Grade");
            System.out.println("-----------");

            for (int i = 0; i < n; i++) {
                int total = 0;
                for (int j = 0; j < 5; j++) {
                    total += marks[i][j];
                }
                System.out.printf("%-10s %-10d %-10.2f %-10s\n", names[i], total, avg[i], grades[i]);
            }

            // 🔹 Calculate overall class average
            double classTotal = 0;
            for (double a : avg) {
                classTotal += a;
            }

            double classAverage = classTotal / n;

            System.out.println("-------------");
            System.out.println("Class Average: " + String.format("%.2f", classAverage));
            System.out.println("============");
            System.out.println("Report Generated Successfully!");

        } catch (InputMismatchException e) {
            System.out.println(" Invalid input! Please enter numbers for marks.");
        } finally {
            sc.close();
        }
    }
}
