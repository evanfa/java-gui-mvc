package model.objects;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.RegexUtility;

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
        //this.dateComm = dateComm;
        if (dateComm != null) {
            /*  If Date is in Correct Format    */
            if (RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_DATE_OK, dateComm)) {
                this.dateComm = dateComm;
                /*  If Date is NOT in Correct Format, Fix the String    */
            } else {
                //TODO Verify when is possible fix date format and if not replacer
                if (RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_DATE_OK, RegexUtility.fixEnglishDateFormatToSQLDateFormat(dateComm))) {
                    this.dateComm = RegexUtility.fixEnglishDateFormatToSQLDateFormat(dateComm);
                } else {
                    this.dateComm = "";
                }
            }
        } else {
            this.dateComm = "";
        }
    }

    public String getDateReceipt() {
        return dateReceipt;
    }

    public void setDateReceipt(String dateReceipt) {
        //this.dateReceipt = dateReceipt;
        if (dateReceipt != null) {
            /*  If Date is in Correct Format    */
            if (RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_DATE_OK, dateReceipt)) {
                this.dateReceipt = dateReceipt;
                /*  If Date is NOT in Correct Format, Fix the String    */
            } else {
                //TODO Verify when is possible fix date format and if not replacer
                if (RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_DATE_OK, RegexUtility.fixEnglishDateFormatToSQLDateFormat(dateReceipt))) {
                    this.dateReceipt = RegexUtility.fixEnglishDateFormatToSQLDateFormat(dateReceipt);
                } else {
                    this.dateReceipt = "";
                }
            }
        } else {
            this.dateReceipt = "";
        }
    }

    public String getTypeComm() {
        return typeComm;
    }

    public void setTypeComm(String typeComm) {
        //this.typeComm = typeComm;
        if (typeComm != null) {
            this.typeComm = typeComm;
        } else {
            this.typeComm = "";
        }
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
        //this.originalReceived = originalReceived;
        if (originalReceived != null) {
            this.originalReceived = originalReceived;
        } else {
            this.originalReceived = "";
        }
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
        //this.referenceComm = referenceComm;
        if (referenceComm != null) {
            this.referenceComm = referenceComm;
        } else {
            this.referenceComm = "";
        }
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
