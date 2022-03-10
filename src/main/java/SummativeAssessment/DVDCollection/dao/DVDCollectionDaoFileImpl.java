package SummativeAssessment.DVDCollection.dao;

import SummativeAssessment.DVDCollection.dto.DVD;

import java.util.*;

public class DVDCollectionDaoFileImpl implements DvdCollectionDao{
    private Map<String,DVD> dvds = new HashMap<>();

    private Collection<DVD> allDVDs = new LinkedList<>();

    @Override
    public DVD addDVD(DVD dvd) {
        DVD dvdToBeAdded = dvds.put(dvd.getTitle(),dvd);
        return dvdToBeAdded;
    }

    @Override
    public DVD updateDVD(String title,DVD newDVD) {
        DVD dvdToUpdate = getDVD(title);
        dvdToUpdate.setTitle(newDVD.getTitle());
        dvdToUpdate.setDirectorName(newDVD.getDirectorName());
        dvdToUpdate.setMpaaRating(newDVD.getMpaaRating());
        dvdToUpdate.setReleaseDate(newDVD.getReleaseDate());
        dvdToUpdate.setStudio(newDVD.getStudio());
        dvdToUpdate.setUserRating(newDVD.getUserRating());
        return dvdToUpdate;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return dvds.values().stream().toList();
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        return dvds.remove(title);
    }
}
