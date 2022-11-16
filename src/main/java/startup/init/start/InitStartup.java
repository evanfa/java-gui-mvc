package startup.init.start;

import data.pass.db.ConnectBd;
import startup.init.vault.loader.POJOLoader;
import startup.init.vault.loader.VaultLoader;
import startup.init.vault.loader.obj.PathLoader;
import startup.init.vault.loader.utils.CSVLoader;
import startup.init.vault.loader.utils.SysSettingsLoader;
import startup.init.vault.loader.utils.URLFileDownloader;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InitStartup {

    private static final String DEFAULT_CONFIG_XML = "src/main/java/startup/init/config/xml/paths_config.xml";
    private static final String DEFAULT_CSV_FILE = "C:\\Users\\Public\\default.xml";

    private static String DEFAULT_FOLDER = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\DocumentControl\\";
    private static String NON_FOUND_FOLDER = "C:\\Users\\Public\\";
    private static String DEFAULT_PATH_CSV;
    private static String DEFAULT_PATH_TVDR;
    private static String DEFAULT_PATH_TXTL;
    private static String DEFAULT_PATH_SDTT;
    private static String DEFAULT_PATH_TOPO;
    private static int CSV_TOTAL_ROWS;

    //private static LinkedList<String> itemsInCsvFile;
    private static List<String> pathsList;
    private static LinkedList<String> recordsInCSVFile;
    private static int screenSizeWidth;
    private static int screenSizeHeight;
    private static int totalPathsFound;
    private PathLoader xmlLoader = null;

    public InitStartup() throws IOException {
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

            pathsList = new LinkedList<>();
            pathsList.add(getDefaultPathCsv());
            pathsList.add(getDefaultPathTvdr());
            pathsList.add(getDefaultPathTxtl());
            pathsList.add(getDefaultPathSdtt());
            pathsList.add(getDefaultPathTopo());

           for (String item : pathsList) {
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

        } else {
            JOptionPane.showMessageDialog(null, "Non found xml config file. " + DEFAULT_CSV_FILE + " Verify.", "XML Not Found", JOptionPane.ERROR_MESSAGE);
            setDefaultPathCsv(DEFAULT_CSV_FILE);
        }

        if (ConnectBd.executeTableVerification(VaultLoader.getDefaultDb(), VaultLoader.getDefaultTable())) {
            System.out.println("Database found...Done");
        } else {
            JOptionPane.showMessageDialog(null, "The connection to Database is not available. Verify.", "DB Verification Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        /*
        Verify Destination Path Exist
         */
        if(!SysSettingsLoader.folderExistInPath(DEFAULT_FOLDER)){
            System.out.println("Creation Destination Path.... Done");
            setDefaultFolderSite(NON_FOUND_FOLDER.concat("\\tempfiles"));
            SysSettingsLoader.createDirectory(getDefaultFolderSite());

        }

        System.out.println("Destination Folder: "+getDefaultFolderSite());

        //URLFileDownloader flD = new URLFileDownloader("https://transcanada.sharepoint.com/sites/bdu_mexico/Shared Documents/2.-PERMISOS/6. Tmz-Ext/DOCUMENTOS/Mayores/2. ASEA/2.2 ETJS/2.2.3 ETJ 2A (Xilitla)/4.-Otorgamiento del Permiso/4.1 133-02-03-236-2013-130914 Autorizacion CUSTF ETJ 2A.pdf","custom");
        //URLFileDownloader flD = new URLFileDownloader("https://transcanada.sharepoint.com/:b:/r/sites/bdu_mexico/Shared%20Documents/2.-PERMISOS/6.%20Tmz-Ext/DOCUMENTOS/Mayores/2.%20ASEA/2.2%20ETJS/2.2.3%20ETJ%202A%20(Xilitla)/4.-Otorgamiento%20del%20Permiso/4.1%20133-02-03-236-2013-130914%20Autorizacion%20CUSTF%20ETJ%202A.pdf?csf=1&web=1&e=x5gGj8","custom");
    }

    //TODO Change to ArrayList
    public static LinkedList<String> loadTotalRecordsFromCSVFile(String pathInput){
        LinkedList<String> itemsInCsvFile = null;//new LinkedList<>();
        try {
            //TODO Consider change to ArrayList for better cache management
            itemsInCsvFile = CSVLoader.getRowsFromCSVList(pathInput, 0);

            if (itemsInCsvFile.size() > 0) {
                setCsvTotalRows(itemsInCsvFile.size());
                setRecordsInCSVFile(itemsInCsvFile);
                System.out.println("Loaded " + getCsvTotalRows() + " records from CSV...Done");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load path " + DEFAULT_PATH_CSV, "CSV cannot be loaded", JOptionPane.ERROR_MESSAGE);
        }
        return itemsInCsvFile;
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

    public static int getCsvTotalRows() {
        return CSV_TOTAL_ROWS;
    }

    public static void setCsvTotalRows(int csvTotalRows) {
        CSV_TOTAL_ROWS = csvTotalRows;
    }

    public static String getDefaultFolderSite() {
        return DEFAULT_FOLDER;
    }

    public static void setDefaultFolderSite(String defaultFolderSite) {
        DEFAULT_FOLDER = defaultFolderSite;
    }

    public static List<String> getPathsList(){
        return pathsList;
    }

    public static LinkedList<String> getRecordsInCSVFile() {
        return recordsInCSVFile;
    }

    public static void setRecordsInCSVFile(LinkedList<String> recordsInCSVFile) {
        InitStartup.recordsInCSVFile = recordsInCSVFile;
    }

    public static void main(String[] args) throws IOException {
        InitStartup ptL = new InitStartup();
        //System.out.println(getDefaultPathTvdr() + getDefaultPathTxtl() + getDefaultPathSdtt());
        //System.out.println(getDefaultPathTopo());
    }

}
