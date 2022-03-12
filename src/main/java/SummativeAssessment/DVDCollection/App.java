package SummativeAssessment.DVDCollection;

import SummativeAssessment.DVDCollection.controller.DVDCollectionController;
import SummativeAssessment.DVDCollection.dao.*;
import SummativeAssessment.DVDCollection.ui.*;

import java.text.ParseException;

public class App {

    public static void main(String[] args) throws ParseException, DVDCollectionDaoException {
        UserIO userIO = new UserIOConsoleImpl();
        DVDCollectionView view = new DVDCollectionView(userIO);
        DvdCollectionDao dao = new DVDCollectionDaoFileImpl();
        DVDCollectionController controller = new DVDCollectionController(dao,view);
        controller.run();
    }
}
