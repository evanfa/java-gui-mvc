package data.pass.utils;

public class HashCoder {
    private final String privateKey;
    private final String resultKey;

    public HashCoder(String privateKey, String resultKey) {
        this.privateKey = privateKey;
        this.resultKey = resultKey;
    }

    private String coderHash() {
        return resultKey;
    }
}
