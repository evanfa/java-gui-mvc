package model.data.mngt.dictonaries;

public class DDCrossType {
    private String constType;
    private String constDes;

    public DDCrossType(String constType, String constDes) {
        this.constType = constType;
        this.constDes = constDes;
    }

    public String getConstType() {
        return constType;
    }

    public void setConstType(String constType) {
        this.constType = constType;
    }

    public String getConstDes() {
        return constDes;
    }

    public void setConstDes(String constDes) {
        this.constDes = constDes;
    }
}
