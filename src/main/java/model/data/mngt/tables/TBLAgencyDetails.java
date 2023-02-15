package model.data.mngt.tables;

public class TBLAgencyDetails {
    private int idAgency;
    private String agencyDetails;
    private String agencyAddress;
    private int idState;
    private int idCity;
    private String agencyPhone;
    private String officeDays;
    private String officeHoursM;

    private String idMatrix;

    public TBLAgencyDetails(int idAgency, String agencyDetails, String agencyAddress, int idState, int idCity, String agencyPhone, String officeDays, String officeHoursM, String idMatrix) {
        this.idAgency = idAgency;
        this.agencyDetails = agencyDetails;
        this.agencyAddress = agencyAddress;
        this.idState = idState;
        this.idCity = idCity;
        this.agencyPhone = agencyPhone;
        this.officeDays = officeDays;
        this.officeHoursM = officeHoursM;
        this.idMatrix = idMatrix;
    }

    public int getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(int idAgency) {
        this.idAgency = idAgency;
    }

    public String getAgencyDetails() {
        return agencyDetails;
    }

    public void setAgencyDetails(String agencyDetails) {
        this.agencyDetails = agencyDetails;
    }

    public String getAgencyAddress() {
        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    public String getOfficeDays() {
        return officeDays;
    }

    public void setOfficeDays(String officeDays) {
        this.officeDays = officeDays;
    }

    public String getOfficeHoursM() {
        return officeHoursM;
    }

    public void setOfficeHoursM(String officeHoursM) {
        this.officeHoursM = officeHoursM;
    }

    public String getIdMatrix() {
        return idMatrix;
    }

    public void setIdMatrix(String idMatrix) {
        this.idMatrix = idMatrix;
    }
}
