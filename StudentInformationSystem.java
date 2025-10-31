import java.util.Scanner;
public class StudentInformationSystem {

    public static void displayStudentInfo(String name, int age, char grade) {
        System.out.println("\n--- Student Information ---");
        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Grade : " + grade);
        System.out.println("-------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Student Information System ====");

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student age: ");
        int age = sc.nextInt();

        System.out.print("Enter student grade (A-F): ");
        char grade = sc.next().charAt(0);

        displayStudentInfo(name, age, grade);

        sc.close();
    }
}
