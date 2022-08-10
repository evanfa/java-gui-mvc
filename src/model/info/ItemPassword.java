package model.info;

import java.util.ArrayList;

/**
 * New Password Object
 */
public class ItemPassword {

    private String userName;
    private String passWord;
    private String date;
    private ArrayList<String> sites = new ArrayList<String>();

    public ItemPassword(String userName, String passWord, String date) {
        this.userName = userName;
        this.passWord = passWord;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addSite(String url){
        this.sites.add(url);
    }

    public ArrayList<String> getSites(){
        return this.sites;
    }
}
