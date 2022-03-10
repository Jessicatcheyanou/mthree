package SummativeAssessment.DVDCollection.dao;

import SummativeAssessment.DVDCollection.dto.DVD;

import java.util.List;

public interface DvdCollectionDao {

    DVD addDVD(DVD dvd);
    DVD updateDVD(String title,DVD newDVD);
    List<DVD> getAllDVDs();
    DVD getDVD(String title);
    DVD removeDVD(String title);

}
