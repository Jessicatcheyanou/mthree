package JavaBasics;

import java.util.Scanner;

public class WindowMaster {

    public static void main(String[] args) {
        //Input
        float height = 0.0f;
        float width = 0.0f;
        float costOfWindow = 0.0f;
        float trim = 0.0f;
        int numberOfWindows = 0;

        String stringHeight;
        String stringWidth;
        String stringCostOfWindow;
        String stringCostOfTrim;
        String stringNumberOfWindows;

        boolean isValidHeight = false;
        boolean isValidWidht = false;
        boolean isValidCostOfWindow = false;
        boolean isValidTrim = false;
        boolean isValidNumberOfWindows = false;

        //Output
        float areaOfWindow;
        float perimeterOfWindow;
        float totalCostOfWindow;
        float totalCostOfRenovation;

        Scanner myScanner = new Scanner(System.in);

        //Validate Height
        do {
            try {
                System.out.println("Enter Height:");
                stringHeight = myScanner.nextLine();
                height = Float.parseFloat(stringHeight);
                isValidHeight = true;
            }catch (Exception ex){
                System.out.println("Invalid Height:");
            }
        }while (!isValidHeight);

        //Validate Width
        do {
            try {
                System.out.println("Enter Width:");
                stringWidth = myScanner.nextLine();
                width = Float.parseFloat(stringWidth);
                isValidWidht = true;
            } catch (Exception e){
                System.out.println("Invalid Width:");
            }
        }while (!isValidWidht);

        //Validate Cost of Window
        do {
            try {
                System.out.println("Cost of Window:(format 0.0):");
                stringCostOfWindow = myScanner.nextLine();
                costOfWindow = Float.parseFloat(stringCostOfWindow);
                isValidCostOfWindow = true;
            }catch (Exception e){
                System.out.println("Error:Incorrect Digit.");
            }
        }while (!isValidCostOfWindow);

        //Validate Trim
        do {
            try {
                System.out.println("Enter cost of trim(format 0.0):");
                stringCostOfTrim = myScanner.nextLine();
                trim = Float.parseFloat(stringCostOfTrim);
                isValidTrim = true;

            }catch (Exception e){
                System.out.println("Error..");
            }
        }while (!isValidTrim);

        do {
            try {
                System.out.println("Enter Total Number of Windows:");
                stringNumberOfWindows = myScanner.nextLine();
                numberOfWindows = Integer.parseInt(stringNumberOfWindows);
                isValidNumberOfWindows = true;
            }catch (Exception e){
                System.out.println("Error...Invalid Number.");
            }
        }while (!isValidNumberOfWindows);


        areaOfWindow = width*height;
        perimeterOfWindow = 2*(width+height);
        totalCostOfWindow = ((costOfWindow * areaOfWindow) + (trim * perimeterOfWindow));
        totalCostOfRenovation = totalCostOfWindow * numberOfWindows;

        System.out.println("\nCost of Window:" + costOfWindow);
        System.out.println("Cost of Trim:" + trim);
        System.out.println("Window Height:" + height);
        System.out.println("Window Widht:" + width);
        System.out.println("Area of Window is:" + areaOfWindow);
        System.out.println("Perimeter of Window is:" + perimeterOfWindow);
        System.out.println("Total Cost of Window :" + totalCostOfWindow + "$");
        System.out.println("Total Cost of Renovation:" + totalCostOfRenovation + "$" );

    }
}
