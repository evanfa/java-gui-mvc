package model.objects;

public class CommRecord {
    public String idMatrix;
    public String folioComm;
    public String dateComm;
    public String dateReceipt;
    public String typeComm;
    public String subjectComm;
    public String authorComm;
    public String originalReceived;
    public String commentsComm;
    public String referenceComm;

    public String getIdMatrix() {
        return idMatrix;
    }

    public void setIdMatrix(String idMatrix) {
        this.idMatrix = idMatrix;
    }

    public String getFolioComm() {
        return folioComm;
    }

    public void setFolioComm(String folioComm) {
        this.folioComm = folioComm;
    }

    public String getDateComm() {
        return dateComm;
    }

    public void setDateComm(String dateComm) {
        this.dateComm = dateComm;
    }

    public String getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(String dateReceipt) {
        this.dateReceipt = dateReceipt;
    }

    public String getTypeComm() {
        return typeComm;
    }

    public void setTypeComm(String typeComm) {
        this.typeComm = typeComm;
    }

    public String getSubjectComm() {
        return subjectComm;
    }

    public void setSubjectComm(String subjectComm) {
        this.subjectComm = subjectComm;
    }

    public String getAuthorComm() {
        return authorComm;
    }

    public void setAuthorComm(String authorComm) {
        if (authorComm != null) {
            this.authorComm = authorComm;
        } else {
            this.authorComm = "";
        }
    }

    public String getOriginalReceived() {
        return originalReceived;
    }

    public void setOriginalReceived(String originalReceived) {
        this.originalReceived = originalReceived;
    }

    public String getCommentsComm() {
        return commentsComm;
    }

    public void setCommentsComm(String commentsComm) {
        this.commentsComm = commentsComm;
    }

    public String getReferenceComm() {
        return referenceComm;
    }

    public void setReferenceComm(String referenceComm) {
        this.referenceComm = referenceComm;
    }

    public CommRecord(){

    }

    public CommRecord(String idMatrix, String folioComm, String dateComm, String dateReceipt, String typeComm, String subjectComm, String authorComm, String originalReceived, String commentsComm, String referenceComm) {
        this.idMatrix = idMatrix;
        this.folioComm = folioComm;
        this.dateComm = dateComm;
        this.dateReceipt = dateReceipt;
        this.typeComm = typeComm;
        this.subjectComm = subjectComm;
        this.authorComm = authorComm;
        this.originalReceived = originalReceived;
        this.commentsComm = commentsComm;
        this.referenceComm = referenceComm;
    }

    public CommRecord(String folioComm, String dateComm, String dateReceipt, String typeComm, String subjectComm, String authorComm, String originalReceived, String commentsComm, String referenceComm) {
        this.folioComm = folioComm;
        this.dateComm = dateComm;
        this.dateReceipt = dateReceipt;
        this.typeComm = typeComm;
        this.subjectComm = subjectComm;
        this.authorComm = authorComm;
        this.originalReceived = originalReceived;
        this.commentsComm = commentsComm;
        this.referenceComm = referenceComm;
    }
}
