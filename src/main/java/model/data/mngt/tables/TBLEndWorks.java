package model.data.mngt.tables;

public class TBLEndWorks {
    private String idPermit;
    private int idCom;
    private String deliveryCom;

    public TBLEndWorks(String idPermit, int idCom, String deliveryCom) {
        this.idPermit = idPermit;
        this.idCom = idCom;
        this.deliveryCom = deliveryCom;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }

    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public String getDeliveryCom() {
        return deliveryCom;
    }

    public void setDeliveryCom(String deliveryCom) {
        this.deliveryCom = deliveryCom;
    }
}
