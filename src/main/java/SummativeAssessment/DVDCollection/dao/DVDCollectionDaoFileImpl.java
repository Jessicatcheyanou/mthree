package SummativeAssessment.DVDCollection.dao;

import SummativeAssessment.DVDCollection.dto.*;

import java.io.*;
import java.text.*;
import java.util.*;

public class DVDCollectionDaoFileImpl implements DvdCollectionDao{
    private final Map<String,DVD> dvds = new HashMap<>();
    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";
    public static final String STUDIO_DELIMITER = "-";

    //private final Collection<DVD> allDVDs = new LinkedList<>();

    @Override
    public DVD addDVD(DVD dvd) throws ParseException, DVDCollectionDaoException {
        loadDVDCollection();
        DVD dvdToBeAdded = dvds.put(dvd.getTitle(),dvd);
        writeDVDCollection();
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
    public List<DVD> getAllDVDs() throws DVDCollectionDaoException, ParseException {
        loadDVDCollection();
        return dvds.values().stream().toList();
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDCollectionDaoException, ParseException {
        loadDVDCollection();
        DVD removedDVD = dvds.remove(title);
        writeDVDCollection();
        return removedDVD;
    }

    private DVD unmarshallDVD(String dvdAsText) throws ParseException {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String[] studioTokens = dvdAsText.split(STUDIO_DELIMITER);

        DVD dvdFromFile = new DVD();
        Studio studioFromDvDFile = new Studio();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        dvdFromFile.setTitle(dvdTokens[0]);
        dvdFromFile.setReleaseDate(sdf.parse(dvdTokens[1]));
        dvdFromFile.setMpaaRating(MPAARating.valueOf(dvdTokens[2]));
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setUserRating(dvdTokens[4]);

        String firstStudioToken = studioTokens[0];
        List<String> firstStudioTokenToList = new ArrayList<>(Arrays.asList(firstStudioToken.split("::")));
        studioFromDvDFile.setName(firstStudioTokenToList.get(5));
        studioFromDvDFile.setContactNo(studioTokens[1]);
        studioFromDvDFile.setEmail(studioTokens[2]);
        studioFromDvDFile.setCompleteAddress(studioTokens[3]);
        dvdFromFile.setStudio(studioFromDvDFile);

        return dvdFromFile;

    }

    private void loadDVDCollection() throws DVDCollectionDaoException, ParseException {
        Scanner scanner;

        try {
            //Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new DVDCollectionDaoException("Could not load DVD data in memory.",e);

        }

        String currentLine;
        DVD currentDVD;

        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(),currentDVD);
        }

        scanner.close();

    }

    private String marshallDVD(DVD aDVD){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += dateFormat.format(aDVD.getReleaseDate()) + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getUserRating() + DELIMITER;
        dvdAsText += aDVD.getStudio().getName() + STUDIO_DELIMITER;
        dvdAsText += aDVD.getStudio().getContactNo() + STUDIO_DELIMITER;
        dvdAsText += aDVD.getStudio().getEmail() + STUDIO_DELIMITER;
        dvdAsText += aDVD.getStudio().getCompleteAddress();

        return dvdAsText;
    }

    //Write the DVD Information from memory to file
    private void writeDVDCollection() throws DVDCollectionDaoException, ParseException {
          PrintWriter out;

          try {
              out = new PrintWriter(new FileWriter(DVD_FILE));
          }catch (IOException e){
              throw new DVDCollectionDaoException("Could not save DVD Data.",e);
          }

          String dvdAsText;
          List<DVD> dvdList = this.getAllDVDs();
          for (DVD currentDVD:dvdList){
              dvdAsText = marshallDVD(currentDVD);
              out.println(dvdAsText);
              out.flush();
          }

          out.close();
    }
}
