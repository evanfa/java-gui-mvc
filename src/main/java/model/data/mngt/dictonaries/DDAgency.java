package model.data.mngt.dictonaries;

public class DDAgency {
    private int idAgency;
    private String agencyName;
    private String agencyDes;

    public DDAgency(int idAgency, String agencyName, String agencyDes) {
        this.idAgency = idAgency;
        this.agencyName = agencyName;
        this.agencyDes = agencyDes;
    }

    public int getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(int idAgency) {
        this.idAgency = idAgency;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyDes() {
        return agencyDes;
    }

    public void setAgencyDes(String agencyDes) {
        this.agencyDes = agencyDes;
    }
}
