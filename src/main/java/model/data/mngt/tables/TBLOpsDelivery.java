package model.data.mngt.tables;

public class TBLOpsDelivery {
    private int idDelivery;
    private int trackRequired;
    private String commentDelivery;

    public TBLOpsDelivery(int idDelivery, int trackRequired) {
        this.idDelivery = idDelivery;
        this.trackRequired = trackRequired;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getTrackRequired() {
        return trackRequired;
    }

    public void setTrackRequired(int trackRequired) {
        this.trackRequired = trackRequired;
    }

    public String getCommentDelivery() {
        return commentDelivery;
    }

    public void setCommentDelivery(String commentDelivery) {
        this.commentDelivery = commentDelivery;
    }
}
