package model.data.mngt.tables;

import controller.utils.Regex_Utility;
import vault.global.vars.GlobalVarsValues;

public class TBLComm {
    private String idCom;
    private String dateCom;
    private String dateRecepit;
    private String typeCom;
    private String subjectCom;
    private String author;
    private String received;
    private String descriptionCom;
    private String referencesCom;

    public TBLComm(String idCom, String dateCom, String dateRecepit, String typeCom, String subjectCom, String author, String received, String descriptionCom, String referencesCom) {
        this.idCom = idCom;
        this.dateCom = dateCom;
        this.dateRecepit = dateRecepit;
        this.typeCom = typeCom;
        this.subjectCom = subjectCom;
        this.author = author;
        this.received = received;
        this.descriptionCom = descriptionCom;
        this.referencesCom = referencesCom;
    }

    public TBLComm() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null) {
            this.author = author;
        } else {
            this.author = "";
        }
    }

    public String getIdCom() {
        return idCom;
    }

    public void setIdCom(String idCom) {
        this.idCom = idCom;
    }

    public String getDateCom() {
        return dateCom;
    }

    public void setDateCom(String dateCom) {
        /* Input String is not empty */
        if (dateCom != null) {
            /*  If Date is in Correct Format    */
            if (Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_DATE_OK, dateCom)) {
                this.dateCom = dateCom;
                /*  If Date is NOT in Correct Format, Fix the String    */
            } else {
                //TODO Verify when is possible fix date format and if not replacer

                if (Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_DATE_OK, Regex_Utility.fixEnglishDateFormatToSQLDateFormat(dateCom))) {
                    this.dateCom = Regex_Utility.fixEnglishDateFormatToSQLDateFormat(dateCom);
                } else {
                    this.dateCom = "";
                }
            }
        } else {
            this.dateCom = "";
        }
    }

    public String getDateRecepit() {
        return dateRecepit;
    }

    public void setDateRecepit(String dateRecepit) {
        if (dateRecepit != null) {
            /*  If Date is in Correct Format    */
            if (Regex_Utility.isRegexContainedIntoSingleString(GlobalVarsValues.REGEX_DATE_OK, dateRecepit)) {
                this.dateRecepit = dateRecepit;
                /*  If Date is NOT in Correct Format, Fix the String    */
            } else {
                this.dateRecepit = Regex_Utility.fixEnglishDateFormatToSQLDateFormat(dateRecepit);
            }
        } else {
            this.dateRecepit = "";
        }
    }

    public String getTypeCom() {
        return typeCom;
    }

    public void setTypeCom(String typeCom) {

        if (typeCom != null) {
            this.typeCom = typeCom;
        } else {
            this.typeCom = "";
        }
    }

    public String getSubjectCom() {
        return subjectCom;
    }

    public void setSubjectCom(String subjectCom) {
        this.subjectCom = subjectCom;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        if (received != null) {
            this.received = received;
        } else {
            this.received = "";
        }

    }

    public String getDescriptionCom() {
        return descriptionCom;
    }

    public void setDescriptionCom(String descriptionCom) {
        this.descriptionCom = descriptionCom;
    }

    public String getReferencesCom() {
        return referencesCom;
    }

    public void setReferencesCom(String referencesCom) {
        if (referencesCom != null) {
            this.referencesCom = referencesCom;
        } else {
            this.referencesCom = "";
        }

    }
}
