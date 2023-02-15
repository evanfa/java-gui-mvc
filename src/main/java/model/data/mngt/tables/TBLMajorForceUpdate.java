package model.data.mngt.tables;

public class TBLMajorForceUpdate {
    private int idMj;
    private String commentMj;
    private String dateUpdate;
    private int idContact;

    public TBLMajorForceUpdate(int idMj, String commentMj, String dateUpdate) {
        this.idMj = idMj;
        this.commentMj = commentMj;
        this.dateUpdate = dateUpdate;
    }

    public int getIdMj() {
        return idMj;
    }

    public void setIdMj(int idMj) {
        this.idMj = idMj;
    }

    public String getCommentMj() {
        return commentMj;
    }

    public void setCommentMj(String commentMj) {
        this.commentMj = commentMj;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }
}
