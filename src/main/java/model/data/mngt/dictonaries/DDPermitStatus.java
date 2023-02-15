package model.data.mngt.dictonaries;

public class DDPermitStatus {
    private String permitStatus;
    private String permitDes;

    public DDPermitStatus(String permitStatus, String permitDes) {
        this.permitStatus = permitStatus;
        this.permitDes = permitDes;
    }

    public String getPermitStatus() {
        return permitStatus;
    }

    public void setPermitStatus(String permitStatus) {
        this.permitStatus = permitStatus;
    }

    public String getPermitDes() {
        return permitDes;
    }

    public void setPermitDes(String permitDes) {
        this.permitDes = permitDes;
    }
}
