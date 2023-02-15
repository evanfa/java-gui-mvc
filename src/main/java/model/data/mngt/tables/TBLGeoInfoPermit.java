package model.data.mngt.tables;

public class TBLGeoInfoPermit {
    private int municipalityPermit;
    private int statePermit;
    private float coordLatitude;
    private float coordLongitude;
    private String spreadPermit;
    private int idPermit;

    public TBLGeoInfoPermit(int municipalityPermit, int statePermit, float coordLatitude, float coordLongitude, String spreadPermit) {
        this.municipalityPermit = municipalityPermit;
        this.statePermit = statePermit;
        this.coordLatitude = coordLatitude;
        this.coordLongitude = coordLongitude;
        this.spreadPermit = spreadPermit;
    }

    public int getMunicipalityPermit() {
        return municipalityPermit;
    }

    public void setMunicipalityPermit(int municipalityPermit) {
        this.municipalityPermit = municipalityPermit;
    }

    public int getStatePermit() {
        return statePermit;
    }

    public void setStatePermit(int statePermit) {
        this.statePermit = statePermit;
    }

    public float getCoordLatitude() {
        return coordLatitude;
    }

    public void setCoordLatitude(float coordLatitude) {
        this.coordLatitude = coordLatitude;
    }

    public float getCoordLongitude() {
        return coordLongitude;
    }

    public void setCoordLongitude(float coordLongitude) {
        this.coordLongitude = coordLongitude;
    }

    public String getSpreadPermit() {
        return spreadPermit;
    }

    public void setSpreadPermit(String spreadPermit) {
        this.spreadPermit = spreadPermit;
    }
}
