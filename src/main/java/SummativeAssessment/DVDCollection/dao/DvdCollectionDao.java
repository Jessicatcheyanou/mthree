package SummativeAssessment.DVDCollection.dao;

import SummativeAssessment.DVDCollection.dto.DVD;

import java.text.ParseException;
import java.util.List;

public interface DvdCollectionDao {

    DVD addDVD(DVD dvd) throws ParseException, DVDCollectionDaoException;
    DVD updateDVD(DVD updateDVD,String title) throws ParseException, DVDCollectionDaoException ;
    List<DVD> getAllDVDs() throws ParseException, DVDCollectionDaoException;
    DVD getDVD(String title) ;
    DVD removeDVD(String title) throws ParseException, DVDCollectionDaoException;

}
