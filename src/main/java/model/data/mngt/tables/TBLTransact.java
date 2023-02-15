package model.data.mngt.tables;

public class TBLTransact {
    private int idTransactType;
    private String dateTransactStart;
    private String dateTransactEnd;
    private int idPermit;
    private String statusTransact;

    public TBLTransact(int idTransactType, int idPermit, String statusTransact) {
        this.idTransactType = idTransactType;
        this.idPermit = idPermit;
        this.statusTransact = statusTransact;
    }

    public int getIdTransactType() {
        return idTransactType;
    }

    public void setIdTransactType(int idTransactType) {
        this.idTransactType = idTransactType;
    }

    public String getDateTransactStart() {
        return dateTransactStart;
    }

    public void setDateTransactStart(String dateTransactStart) {
        this.dateTransactStart = dateTransactStart;
    }

    public String getDateTransactEnd() {
        return dateTransactEnd;
    }

    public void setDateTransactEnd(String dateTransactEnd) {
        this.dateTransactEnd = dateTransactEnd;
    }

    public int getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(int idPermit) {
        this.idPermit = idPermit;
    }

    public String getStatusTransact() {
        return statusTransact;
    }

    public void setStatusTransact(String statusTransact) {
        this.statusTransact = statusTransact;
    }
}
