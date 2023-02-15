package model.data.mngt.dictonaries;

public class DDState {
    private int idState;
    private String stateDes;
    private String acronimState;

    public DDState(int idState, String stateDes, String acronimState) {
        this.idState = idState;
        this.stateDes = stateDes;
        this.acronimState = acronimState;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getStateDes() {
        return stateDes;
    }

    public void setStateDes(String stateDes) {
        this.stateDes = stateDes;
    }

    public String getAcronimState() {
        return acronimState;
    }

    public void setAcronimState(String acronimState) {
        this.acronimState = acronimState;
    }
}
