package model.data.mngt.tables;

public class TBLAgentContact {
    private String contactName;
    private String contactRol;
    private int idAgency;
    private String contactEmail;
    private String contactPhone;
    private String contactOther;
    private String contactComments;

    public TBLAgentContact(String contactName, String contactRol, int idAgency, String contactEmail, String contactPhone) {
        this.contactName = contactName;
        this.contactRol = contactRol;
        this.idAgency = idAgency;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactRol() {
        return contactRol;
    }

    public void setContactRol(String contactRol) {
        this.contactRol = contactRol;
    }

    public int getIdAgency() {
        return idAgency;
    }

    public void setIdAgency(int idAgency) {
        this.idAgency = idAgency;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactOther() {
        return contactOther;
    }

    public void setContactOther(String contactOther) {
        this.contactOther = contactOther;
    }

    public String getContactComments() {
        return contactComments;
    }

    public void setContactComments(String contactComments) {
        this.contactComments = contactComments;
    }
}
