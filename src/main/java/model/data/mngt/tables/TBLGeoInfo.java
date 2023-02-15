package model.data.mngt.tables;

public class TBLGeoInfo {

    private String idPermit;
    private String coordX;
    private String coordY;
    private String spread;

    public TBLGeoInfo(String idPermit, String coordX, String coordY) {
        this.idPermit = idPermit;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getIdPermit() {
        return idPermit;
    }

    public void setIdPermit(String idPermit) {
        this.idPermit = idPermit;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }
}
