package model.data.mngt.tables;

public class TBLAgency {
    private String agencyDetails;
    private String agencyAdress;
    private int idCity;
    private int idState;
    private String officeDays;
    private String officeHours;
    private String agencyNotes;
    private String idPermit;

    public TBLAgency(String agencyDetails, int idCity, int idState, String idPermit) {
        this.agencyDetails = agencyDetails;
        this.idCity = idCity;
        this.idState = idState;
        this.idPermit = idPermit;
    }

    public String getAgencyDetails() {
        return agencyDetails;
    }

    public void setAgencyDetails(String agencyDetails) {
        this.agencyDetails = agencyDetails;
    }

    public String getAgencyAdress() {
        return agencyAdress;
    }

    public void setAgencyAdress(String agencyAdress) {
        this.agencyAdress = agencyAdress;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getOfficeDays() {
        return officeDays;
    }

    public void setOfficeDays(String officeDays) {
        this.officeDays = officeDays;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getAgencyNotes() {
        return agencyNotes;
    }

    public void setAgencyNotes(String agencyNotes) {
        this.agencyNotes = agencyNotes;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }
}
