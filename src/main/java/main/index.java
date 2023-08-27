package main;

import java.util.Scanner;

public class index {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String userChoice = "y";
        while (userChoice.equals("y")) {
            System.out.println("What grade did the student receive?");
            int studentGrade = scanner.nextInt();

            if (studentGrade >= 90 && studentGrade <= 100) {
                System.out.println("The student should receive an A");
            } else if (studentGrade >= 80 && studentGrade < 90) {
                System.out.println("The student should receive an B");
            } else if (studentGrade >= 70 && studentGrade < 80) {
                System.out.println("The student should receive an C");
            } else if (studentGrade >= 60 && studentGrade < 70) {
                System.out.println("The student should receive an D");
            } else if (studentGrade > 60) {
                System.out.println("The student should receive an F");
            }

            scanner.nextLine();
            System.out.println("Would you like to enter another grade? [y/n]");
            userChoice = scanner.nextLine();
        }

        System.out.println("Okay Goodbye...");


    }
}

