package model.data.mngt.tables;

public class TBLPermits {
    private String idMatrix;
    private String idPermit;
    private String permitName;
    private String permitDes;
    private int agencyPermit;
    private int classPermit;
    private String deptoPermit;

    public TBLPermits(String idMatrix, String idPermit, String permitName, String permitDes, int agencyPermit, int classPermit, String deptoPermit) {
        this.idMatrix = idMatrix;
        this.idPermit = idPermit;
        this.permitName = permitName;
        this.permitDes = permitDes;
        this.agencyPermit = agencyPermit;
        this.classPermit = classPermit;
        this.deptoPermit = deptoPermit;
    }

    public String getIdMatrix() {
        return idMatrix;
    }

    public void setIdMatrix(String idMatrix) {
        this.idMatrix = idMatrix;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public String getPermitDes() {
        return permitDes;
    }

    public void setPermitDes(String permitDes) {
        this.permitDes = permitDes;
    }

    public int getAgencyPermit() {
        return agencyPermit;
    }

    public void setAgencyPermit(int agencyPermit) {
        this.agencyPermit = agencyPermit;
    }

    public int getClassPermit() {
        return classPermit;
    }

    public void setClassPermit(int classPermit) {
        this.classPermit = classPermit;
    }

    public String getDeptoPermit() {
        return deptoPermit;
    }

    public void setDeptoPermit(String deptoPermit) {
        this.deptoPermit = deptoPermit;
    }
}
