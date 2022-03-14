package SummativeAssessment.DVDCollection.ui;

import SummativeAssessment.DVDCollection.dto.*;

import java.util.Date;
import java.util.List;

public class DVDCollectionView {

    private final UserIO io;

    public DVDCollectionView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List DVD titles");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Update a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices",1,6);
    }

    public DVD getNewDVDInfo(){
        String title = io.readString("Please enter DVD title");
        Date releaseDate = io.readDate("Please enter releaseDate(in the format..dd/MM/yyyy)");
        MPAARating mpaaRating = io.readMpaaRating("Please enter MPAA Rating");
        String directorName = io.readString("Please Enter Director Name");
        String userRating = io.readString("Please rate as a User");
        io.print("ENTER INFO OF THE STUDIO WHERE THE DVD WAS PRODUCED");
        String studioName = io.readString("Please enter Studio name");
        Integer studioContactNo = io.readInt("Please enter studio phone number");
        String studioEmail = io.readEmail("Please enter the studio`s email");
        String studioAddress = io.readString("Please enter the Studio`s Address");
        Studio currentStudio = new Studio();
        currentStudio.setName(studioName);
        currentStudio.setContactNo(String.valueOf(studioContactNo));
        currentStudio.setEmail(studioEmail);
        currentStudio.setCompleteAddress(studioAddress);
        DVD currentDVD = new DVD();
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setUserRating(userRating);
        currentDVD.setStudio(currentStudio);

        return currentDVD;

    }

    public DVD getUpdateDVDInfo(){
        //String title = io.readString("Please enter DVD title");
        io.print("ENTER ELEMENTS YOU WANT TO UPDATE OR \n SIMPLY RE-ENTER THE VALUES FOR THOSE YOU DON`T WANT TO UPDATE");
        Date releaseDate = io.readDate("Please enter releaseDate(in the format..dd/MM/yyyy)");
        MPAARating mpaaRating = io.readMpaaRating("Please enter MPAA Rating");
        String directorName = io.readString("Please Enter Director Name");
        String userRating = io.readString("Please rate as a User");
        io.print("ENTER INFO OF THE STUDIO WHERE THE DVD WAS PRODUCED");
        String studioName = io.readString("Please enter Studio name");
        Integer studioContactNo = io.readInt("Please enter studio phone number");
        String studioEmail = io.readEmail("Please enter the studio`s email");
        String studioAddress = io.readString("Please enter the Studio`s Address");

        Studio updateStudio = new Studio();
        updateStudio.setName(studioName);
        updateStudio.setContactNo(String.valueOf(studioContactNo));
        updateStudio.setEmail(studioEmail);
        updateStudio.setCompleteAddress(studioAddress);
        DVD currentDVD = new DVD();
        //currentDVD.getTitle();
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setUserRating(userRating);
        currentDVD.setStudio(updateStudio);

        return currentDVD;

    }

    public void displayCreateDVDBanner(){
        io.print("===Create DVD===");
    }

    public void displayCreateSuccessBanner(){
        io.readString("DVD successfully created.Please hit enter to continue");
    }

    public void displayAllDVDsBanner(){
        io.print("===Display All DVD`ss===");
    }

    public void displayDVDList(List<DVD> dvdList){
        dvdList.forEach(System.out::println);
        io.readString("Please hit enter to continue");
    }

    public void displayDVDBanner(){
        io.print("===DISPLAY DVD===");
    }

    public String getDVDTitleChoice(){
        return io.readString("Please Enter the DVD title");
    }

    public void displayDVD(DVD dvd){
        if (dvd != null){
            io.print("Title:" + dvd.getTitle());
            io.print("MPAA Rating:"+ dvd.getMpaaRating() + "\n"+"Release Date:" + dvd.getReleaseDate() + "\n" + "Director`s Name:" + dvd.getDirectorName() + "\n");
            io.print(dvd.getTitle() + " "+ "STUDIO`s INFO:");
            io.print("Studio`s Name:"+ dvd.getStudio().getName() + "\n" + "Complete Address:" + dvd.getStudio().getCompleteAddress()
            +"\n" +"Email:"+ dvd.getStudio().getEmail() + "\n" + "Contact Number:" + dvd.getStudio().getContactNo());
        } else {
            io.print("No such DVD Exist");
        }
        io.readString("Please Hit Enter to continue");
    }

    public void displayRemoveDVDBanner(){
        io.print("===REMOVE DVD===");
    }

    public void displayRemoveResult(DVD dvdRecord){
        if (dvdRecord != null){
            io.print("DVD successfully removed");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to Continue");
    }

    public void displayUpdateDVDBanner(){
        io.print("===UPDATE DVD===");
    }

    public void displayUpdateSuccessBanner(){
        io.readString("DVD successfully Updated.Please hit enter to continue");
    }

    public void displayExitBanner(){
        io.print("Good Bye!");
    }

    public void displayUnknownCommandBanner(){
        io.print("Unknown Command");
    }

    public void displayErrorMessage(String errorMsg){
        io.print("===ERROR===");
        io.print(errorMsg);
    }

}
