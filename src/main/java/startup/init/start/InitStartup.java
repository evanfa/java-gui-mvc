package startup.init.start;

import data.pass.db.ConnectBd;
import startup.init.vault.loader.POJOLoader;
import startup.init.vault.loader.VaultLoader;
import startup.init.vault.loader.obj.PathLoader;
import startup.init.vault.loader.utils.SysSettingsLoader;

import javax.swing.*;
import java.util.ArrayList;

public class InitStartup {

    private static final String DEFAULT_CONFIG_XML = "src/main/java/startup/init/config/xml/paths_config.xml";
    private static final String DEFAULT_FOLDER = "C:\\Users\\Public\\";

    private static String DEFAULT_PATH_CSV;
    private static String DEFAULT_PATH_TVDR;
    private static String DEFAULT_PATH_TXTL;
    private static String DEFAULT_PATH_SDTT;
    private static String DEFAULT_PATH_TOPO;

    private PathLoader xmlLoader = null;
    private ArrayList<String> lstPaths;
    private static int screenSizeWidth;
    private static int screenSizeHeight;

    public InitStartup() {
        /*
        1. Load Paths from XML File
        2. Validate Paths Exists
        3. Validate DB Connection
        4. Validate Destination Path Exists
         */

        System.out.println("Loading App...");

        xmlLoader = new PathLoader();
        xmlLoader = POJOLoader.defaultLoaderXMLPaths(DEFAULT_CONFIG_XML);

        if(xmlLoader!=null){
            setDefaultPathCsv(xmlLoader.getTvdrPath());
            setDefaultPathTvdr(xmlLoader.getTvdrPath());
            setDefaultPathTxtl(xmlLoader.getTxtlPath()) ;
            setDefaultPathSdtt(xmlLoader.getSdttPath());
            setDefaultPathTopo(xmlLoader.getTopoPath());
            System.out.println("Loading XML Paths...");
        }else{
            setDefaultPathCsv(DEFAULT_FOLDER);
        }

        if(ConnectBd.executeTableVerification(VaultLoader.getDefaultDb(), VaultLoader.getDefaultTable())){
            //TODO Update "Found Default DB Connection - Testing Connection - Table Exist - Connection Verified
            //TODO Load All Tables and Databases in Engine
            System.out.println("Loading DB...");
        }else{
            JOptionPane.showMessageDialog(null, "The connection to Database is not available. Verify.", "DB Verification Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        System.out.println("Loading CSV Default...");
        //if(SysSettingsLoader.fileExistInPath(getDefaultPathCsv())){


        if(SysSettingsLoader.fileExistInPath("C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\IT\\Paths-CSV-CopyFiles\\TVDR-dump-totalfiles-permits-13Sep2022.csv")){
            System.out.println("CSV Source");
        }

        /*
        if(SysSettingsLoader.fileExistInPath(getDefaultPathCsv())){
            System.out.println("Exist CSV Source");
        }
        */


        /*else{
            System.out.println("CSV Source Path... "+getDefaultPathCsv());
            System.out.println("CSV Source... "+SysSettingsLoader.fileExistInPath(getDefaultPathCsv().replace("/","\\")));
        }*/



    }

    public static String getDefaultPathCsv() {
        return DEFAULT_PATH_CSV;
    }

    public static void setDefaultPathCsv(String defaultPathCsv) {
        DEFAULT_PATH_CSV = defaultPathCsv;
    }

    public static String getDefaultPathTvdr() {
        return DEFAULT_PATH_TVDR;
    }

    public static void setDefaultPathTvdr(String defaultPathTvdr) {
        DEFAULT_PATH_TVDR = defaultPathTvdr;
    }

    public static String getDefaultPathTxtl() {
        return DEFAULT_PATH_TXTL;
    }

    public static void setDefaultPathTxtl(String defaultPathTxtl) {
        DEFAULT_PATH_TXTL = defaultPathTxtl;
    }

    public static String getDefaultPathSdtt() {
        return DEFAULT_PATH_SDTT;
    }

    public static void setDefaultPathSdtt(String defaultPathSdtt) {
        DEFAULT_PATH_SDTT = defaultPathSdtt;
    }

    public static String getDefaultPathTopo() {
        return DEFAULT_PATH_TOPO;
    }

    public static void setDefaultPathTopo(String defaultPathTopo) {
        DEFAULT_PATH_TOPO = defaultPathTopo;
    }

    public static void main(String[] args) {
        InitStartup ptL = new InitStartup();
        System.out.println(getDefaultPathTvdr() + getDefaultPathTxtl() + getDefaultPathSdtt());
        System.out.println(getDefaultPathTopo());
    }

}
