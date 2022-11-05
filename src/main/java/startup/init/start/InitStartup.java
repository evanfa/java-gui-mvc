package startup.init.start;

import data.pass.db.ConnectBd;
import startup.init.vault.loader.POJOLoader;
import startup.init.vault.loader.VaultLoader;
import startup.init.vault.loader.obj.PathLoader;
import startup.init.vault.loader.utils.CSVLoader;
import startup.init.vault.loader.utils.SysSettingsLoader;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InitStartup {

    private static final String DEFAULT_CONFIG_XML = "src/main/java/startup/init/config/xml/paths_config.xml";
    private static final String DEFAULT_FOLDER = "C:\\Users\\Public\\default.xml";

    private static String DEFAULT_PATH_CSV;
    private static String DEFAULT_PATH_TVDR;
    private static String DEFAULT_PATH_TXTL;
    private static String DEFAULT_PATH_SDTT;
    private static String DEFAULT_PATH_TOPO;

    private static int CSV_TOTAL_ROWS;
    private static List<String> itemsInCsvFile;
    private static int screenSizeWidth;
    private static int screenSizeHeight;
    private static int totalPathsFound;
    private PathLoader xmlLoader = null;

    public InitStartup() {
        /*
        1. Load Paths from XML File
        2. Validate Paths Exists
        3. Validate DB Connection
        4. Validate Destination Path Exists
         */

        System.out.println("Starting App Launch...Done");

        xmlLoader = new PathLoader();
        xmlLoader = POJOLoader.defaultLoaderXMLPaths(DEFAULT_CONFIG_XML);

        if (xmlLoader != null) {
            setDefaultPathCsv(xmlLoader.getTvdrPath());
            setDefaultPathTvdr(xmlLoader.getTvdrPath());
            setDefaultPathTxtl(xmlLoader.getTxtlPath());
            setDefaultPathSdtt(xmlLoader.getSdttPath());
            setDefaultPathTopo(xmlLoader.getTopoPath());

            List<String> pathsList = new LinkedList<>();
            pathsList.add(getDefaultPathCsv());
            pathsList.add(getDefaultPathTvdr());
            pathsList.add(getDefaultPathTxtl());
            pathsList.add(getDefaultPathSdtt());
            pathsList.add(getDefaultPathTopo());


           for (String item : pathsList) {
                //System.out.println("Current Path: "+item);
                if (SysSettingsLoader.fileExistInPath(item)) {
                    totalPathsFound++;
                }
            }

            if(totalPathsFound==0){
                System.out.println("Paths not found!");
                JOptionPane.showMessageDialog(null, "Non paths were found. Edit xml default file.", "No csv paths found", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

            System.out.println("Loading " + totalPathsFound + " XML Paths...Done");

            try {
                itemsInCsvFile = new ArrayList<String>();
                itemsInCsvFile = CSVLoader.getRowStringFromCSVtoList(getDefaultPathCsv(), 0);

                if (itemsInCsvFile.size() > 0) {
                    setCsvTotalRows(itemsInCsvFile.size());
                }

                System.out.println("Loaded " + getCsvTotalRows() + " records from CSV...");

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to load path " + DEFAULT_PATH_CSV, "CSV cannot be loaded", JOptionPane.ERROR_MESSAGE);
            }


        } else {
            JOptionPane.showMessageDialog(null, "Non found xml config file. " + DEFAULT_FOLDER + " Verify.", "XML Not Found", JOptionPane.ERROR_MESSAGE);
            setDefaultPathCsv(DEFAULT_FOLDER);
        }

        if (ConnectBd.executeTableVerification(VaultLoader.getDefaultDb(), VaultLoader.getDefaultTable())) {
            //TODO Update "Found Default DB Connection - Testing Connection - Table Exist - Connection Verified
            //TODO Load All Tables and Databases in Engine
            System.out.println("Database found...Done");
        } else {
            JOptionPane.showMessageDialog(null, "The connection to Database is not available. Verify.", "DB Verification Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

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

    public static List<String> getItemsInCsvFile() {
        return itemsInCsvFile;
    }

    public static void setItemsInCsvFile(LinkedList<String> itemsInCsvFile) {
        InitStartup.itemsInCsvFile = itemsInCsvFile;
    }

    public static int getCsvTotalRows() {
        return CSV_TOTAL_ROWS;
    }

    public static void setCsvTotalRows(int csvTotalRows) {
        CSV_TOTAL_ROWS = csvTotalRows;
    }

    public static void main(String[] args) {
        InitStartup ptL = new InitStartup();
        //System.out.println(getDefaultPathTvdr() + getDefaultPathTxtl() + getDefaultPathSdtt());
        //System.out.println(getDefaultPathTopo());
    }

}
