package SummativeAssessment.DVDCollection.dto;

public class Studio {
    private String name;
    private String contactNo;
    private String email;
    private String completeAddress;

    public Studio() {
    }

    //GETTER METHODS
    public String getName() {
        return name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    //SETTER METHODS


    public void setName(String name) {
        this.name = name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", completeAddress='" + completeAddress + '\'' +
                '}';
    }
}
