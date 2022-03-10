package SummativeAssessment.DVDCollection.ui;

import SummativeAssessment.DVDCollection.dto.MPAARating;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserIOConsoleImpl implements UserIO{
    final private Scanner console = new Scanner(System.in);
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    @Override
    public Date readDate(String prompt) {
        boolean invalidInput = true;
        Date validDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (invalidInput){
            try {
                //print the message prompt(e.x asking for the Date)
               String stringValue = this.readString(prompt);
               validDate = sdf.parse(stringValue);
               invalidInput = false;
            }catch (ParseException e){
                this.print("Error.Please try again");
            }
        }
        return validDate;
    }

    @Override
    public MPAARating readMpaaRating(String prompt) {
        MPAARating validMpaaRating;

            try {
                String stringValue = this.readString(prompt);
                validMpaaRating = MPAARating.valueOf(stringValue);
                return validMpaaRating;
            } catch (IllegalArgumentException e){
                System.out.println("Invalid MPAA Rating!\n Please enter either PG,PG_13,R or X");
                return readMpaaRating(prompt);
            }

    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput){
            try {
                String stringValue = this.readString(prompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error.Please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        }while (result < min || result > max);
        return result;
    }

    @Override
    public String readEmail(String prompt) {
        boolean invalidEmail = true;
        String emailRegex =  "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        while (invalidEmail){
            try {
                String email = this.readString(prompt);
                if (pattern.matcher(email).matches()){
                    return email;
                }
            }catch (Exception e){
                this.print("Invalid Email");
            }
            invalidEmail = false;
        }

        return null;
    }
}
