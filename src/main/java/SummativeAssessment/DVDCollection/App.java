package SummativeAssessment.DVDCollection;

import SummativeAssessment.DVDCollection.controller.DVDCollectionController;
import SummativeAssessment.DVDCollection.dao.DVDCollectionDaoFileImpl;
import SummativeAssessment.DVDCollection.dao.DvdCollectionDao;
import SummativeAssessment.DVDCollection.ui.*;

public class App {

    public static void main(String[] args) {
        UserIO userIO = new UserIOConsoleImpl();
        DVDCollectionView view = new DVDCollectionView(userIO);
        DvdCollectionDao dao = new DVDCollectionDaoFileImpl();
        DVDCollectionController controller = new DVDCollectionController(dao,view);
        controller.run();
    }
}
