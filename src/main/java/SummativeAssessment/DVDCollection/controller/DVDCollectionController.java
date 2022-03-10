package SummativeAssessment.DVDCollection.controller;

import SummativeAssessment.DVDCollection.dao.DvdCollectionDao;
import SummativeAssessment.DVDCollection.dto.DVD;
import SummativeAssessment.DVDCollection.ui.*;

import java.util.List;

public class DVDCollectionController {

    private final DvdCollectionDao dao;
    private final DVDCollectionView view;

    public DVDCollectionController(DvdCollectionDao dao, DVDCollectionView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1 -> listDVDs();
                case 2 -> createDVD();
                case 3 -> viewDVD();
                case 4 -> removeDVD();
                //case 5 -> io.print("EDIT DVD");
                case 6 -> keepGoing = false;
                default -> unknownCommand();
            }

        }
        exitMessage();

    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    private void createDVD(){
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD);
        view.displayCreateSuccessBanner();

    }

    private void listDVDs(){
        view.displayAllDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD(){
        view.displayDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd);
    }

    private void removeDVD(){
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveResult(removedDVD);
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }
}
