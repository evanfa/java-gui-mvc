package model.data.mngt.tables;

public class TBLDeliveryLog {
    private int idCompanyDelivery;
    private int idCompanyReception;
    private String deliveryMinute;
    private String deliveryDate;
    private String deliveryDetails;
    private String deliveryComments;

    public TBLDeliveryLog(int idCompanyDelivery, int idCompanyReception, String deliveryMinute, String deliveryDate) {
        this.idCompanyDelivery = idCompanyDelivery;
        this.idCompanyReception = idCompanyReception;
        this.deliveryMinute = deliveryMinute;
        this.deliveryDate = deliveryDate;
    }

    public int getIdCompanyDelivery() {
        return idCompanyDelivery;
    }

    public void setIdCompanyDelivery(int idCompanyDelivery) {
        this.idCompanyDelivery = idCompanyDelivery;
    }

    public int getIdCompanyReception() {
        return idCompanyReception;
    }

    public void setIdCompanyReception(int idCompanyReception) {
        this.idCompanyReception = idCompanyReception;
    }

    public String getDeliveryMinute() {
        return deliveryMinute;
    }

    public void setDeliveryMinute(String deliveryMinute) {
        this.deliveryMinute = deliveryMinute;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public String getDeliveryComments() {
        return deliveryComments;
    }

    public void setDeliveryComments(String deliveryComments) {
        this.deliveryComments = deliveryComments;
    }
}
