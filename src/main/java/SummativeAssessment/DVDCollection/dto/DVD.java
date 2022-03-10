package SummativeAssessment.DVDCollection.dto;

import java.util.Date;

public class DVD {
    private String title;
    private Date releaseDate;
    private MPAARating mpaaRating;
    private String directorName;
    private String userRating;
    private Studio studio;

    public DVD() {
    }

    //GETTER METHODS

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public MPAARating getMpaaRating() {
        return mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getUserRating() {
        return userRating;
    }

    public Studio getStudio() {
        return studio;
    }

    //SETTER METHODS

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMpaaRating(MPAARating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", mpaaRating=" + mpaaRating +
                ", directorName='" + directorName + '\'' +
                ", userRating='" + userRating + '\'' +
                ", studio=" + studio +
                '}';
    }
}
