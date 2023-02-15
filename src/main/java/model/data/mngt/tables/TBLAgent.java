package model.data.mngt.tables;

public class TBLAgent {
    private String agentName;
    private String agentLName;
    private String agentMName;
    private String agentEmail;
    private int idDepto;

    public TBLAgent(String agentName, String agentLName, String agentMName, String agentEmail, int idDepto) {
        this.agentName = agentName;
        this.agentLName = agentLName;
        this.agentMName = agentMName;
        this.agentEmail = agentEmail;
        this.idDepto = idDepto;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentLName() {
        return agentLName;
    }

    public void setAgentLName(String agentLName) {
        this.agentLName = agentLName;
    }

    public String getAgentMName() {
        return agentMName;
    }

    public void setAgentMName(String agentMName) {
        this.agentMName = agentMName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public int getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(int idDepto) {
        this.idDepto = idDepto;
    }
}
