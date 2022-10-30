package startup.init.start;
import jakarta.xml.bind.JAXBContext;
import startup.init.vault.loader.POJOLoader;
import startup.init.vault.loader.obj.PathLoader;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitStartup {

    private static String DEFAULT_PATH_CSV;
    private static String DEFAULT_PATH_TVDR;
    private static String DEFAULT_PATH_TXTL;
    private static String DEFAULT_PATH_SDTT;
    private static String DEFAULT_PATH_TOPO;

    private static final String DEFAULT_CONFIG_XML = "src/main/java/startup/init/config/xml/paths_config.xml";
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DB = "TGNH_TVDR_Permits";
    public static final String DEFAULT_TABLE = "BD_PERMITS";
    public static final String DEFAULT_JDBC_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    PathLoader xmlLoader = null;

    public static void setDefaultPathCsv(String defaultPathCsv) {
        DEFAULT_PATH_CSV = defaultPathCsv;
    }

    public static void setDefaultPathTvdr(String defaultPathTvdr) {
        DEFAULT_PATH_TVDR = defaultPathTvdr;
    }

    public static void setDefaultPathTxtl(String defaultPathTxtl) {
        DEFAULT_PATH_TXTL = defaultPathTxtl;
    }

    public static void setDefaultPathSdtt(String defaultPathSdtt) {
        DEFAULT_PATH_SDTT = defaultPathSdtt;
    }

    public static void setDefaultPathTopo(String defaultPathTopo) {
        DEFAULT_PATH_TOPO = defaultPathTopo;
    }

    public static String getDefaultPathCsv() {
        return DEFAULT_PATH_CSV;
    }

    public static String getDefaultPathTvdr() {
        return DEFAULT_PATH_TVDR;
    }

    public static String getDefaultPathTxtl() {
        return DEFAULT_PATH_TXTL;
    }

    public static String getDefaultPathSdtt() {
        return DEFAULT_PATH_SDTT;
    }

    public static String getDefaultPathTopo() {
        return DEFAULT_PATH_TOPO;
    }

    public InitStartup() {

        xmlLoader = new PathLoader();
        xmlLoader = POJOLoader.defaultLoaderXMLPaths(DEFAULT_CONFIG_XML);

        System.out.println(xmlLoader);

        /*
        1. Load Paths from XML File
        2. Validate Paths Exists
        3. Validate DB Connection
        4. Validate Destination Path Exists
         */

        if(getDefaultPathTvdr()!=null){
            setDefaultPathCsv(xmlLoader.getTvdrPath());
        }else{
            setDefaultPathTvdr (xmlLoader.getTvdrPath());
            setDefaultPathTxtl(xmlLoader.getTxtlPath());
            setDefaultPathSdtt(xmlLoader.getSdttPath());
            setDefaultPathTopo(xmlLoader.getTopoPath());
        }
    }

    public static void main(String[] args) {
        InitStartup ptL = new InitStartup();
    }



}
