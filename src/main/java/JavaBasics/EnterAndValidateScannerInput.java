package JavaBasics;

import java.util.Scanner;

public class EnterAndValidateScannerInput {
    public static void main(String[] args) {
        boolean isValid = false;
        Scanner myScanner = new Scanner(System.in);

        do {

            try {
                System.out.println("Please enter a whole number: ");

                String input = myScanner.nextLine();
                int number = Integer.parseInt(input);

                if (number >= 1 && number <= 10) {
                    isValid = true;
                }

            } catch(NumberFormatException ex) {
                System.out.println("That was not a whole number!");
            }

        } while(!isValid);
    }

}
