package model.data.mngt.dictonaries;

public class DDTransactStatus {
    private int idTransact;
    private String transactStatus;
    private String transactDes;

    public DDTransactStatus(int idTransact, String transactStatus, String transactDes) {
        this.idTransact = idTransact;
        this.transactStatus = transactStatus;
        this.transactDes = transactDes;
    }

    public int getIdTransact() {
        return idTransact;
    }

    public void setIdTransact(int idTransact) {
        this.idTransact = idTransact;
    }

    public String getTransactStatus() {
        return transactStatus;
    }

    public void setTransactStatus(String transactStatus) {
        this.transactStatus = transactStatus;
    }

    public String getTransactDes() {
        return transactDes;
    }

    public void setTransactDes(String transactDes) {
        this.transactDes = transactDes;
    }
}
