package SummativeAssessment.DVDCollection.ui;

import SummativeAssessment.DVDCollection.dto.MPAARating;

import java.util.Date;

public interface UserIO {
    void print(String msg);
    String readString(String prompt);
    Date readDate(String prompt);
    MPAARating readMpaaRating(String prompt);
    int readInt(String prompt);
    int readInt(String prompt,int min,int max);
    String readEmail(String email);
}
