package model.functions;

import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.CSVProcessor;
import startup.init.vault.loader.utils.FilesCopier;
import startup.init.vault.loader.utils.RegexUtility;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class that read CSV file with two columns - FileName && Description
 * Store in HashMap:
 * -(Key) => Filename
 * -(Data) => Description
 * <p>
 * After that verify if the (key) exist in a dataset of communications by file name.
 * Return a (Record) object that contains a file name and path.
 * <p>
 * Rename the file name adding the (CROSS_ID) container in the (Data) to concat the filename + IDCross.
 * And Copy that from server to local storage with in the PATH_FILE_DESTINATION.
 */
public class SearchCSVandCopy {
    static final String CSV_PATH_INPUT = "C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-NorthFiles_CFE.csv";
    //static final String CSV_PATH_INPUT = "C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-NorthFiles_SJR.csv";
    //static final String CSV_PATH_INPUT = "C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-NorthFiles_MLV1003-LaLira.csv";
    //static final String CSV_PATH_INPUT = "C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-NorthFiles_ElMarques.csv";

    static final String PATH_FILE_DESTINATION = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\PermisosTramosPendientes\\Files-Pendientes\\licencias\\NorthZone-Files\\";
    //static final String PATH_FILE_DESTINATION = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\PermisosTramosPendientes\\Files-Pendientes\\licencias\\NorthZone-Files\\SanJuanDelRio\\";
    //static final String PATH_FILE_DESTINATION = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\PermisosTramosPendientes\\Files-Pendientes\\licencias\\NorthZone-Files\\ElMarques\\";
    //static final String PATH_FILE_DESTINATION = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\PermisosTramosPendientes\\Files-Pendientes\\licencias\\NorthZone-Files\\Cruces\\MLV1003-LaLira\\";

    static final String TVDR_INCOMING = "(tvdr)-([a-zA-Z-]*)-(tgnh)-([0-9]*)-([0-9a-zA-Z-]*)";
    //static final String CROSS_ID = "[PR]-(?:[^TGNH][^CFEP]).[-0-9A-Z]*"; //"[P]-[-0-9A-Z]*";
    static final String CROSS_ID = "[QW]-(?:[^TGNH][^CFEP]).[-0-9A-Z]*"; //"[P]-[-0-9A-Z]*";
    static final String FILENET_ID = "1,\\d{3},\\d{3},\\d{3}";

    public static void main(String[] args) throws Exception {
        List<String> listCommunications = new ArrayList<String>();
        List<String> infoCommunications = new ArrayList<String>();

        RegexUtility rgxUtil = new RegexUtility();

        HashMap<String, String> comsMap = new HashMap<>();
        ArrayList<Record> resultSearch;

        int totalFilesCopied = 0;

        try {
            InitStartup.loadTotalRecordsFromCSVFile("C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-dump-totalfiles-permits-10Jan2023.csv");

            listCommunications = CSVProcessor.getRowStringFromCSVtoList(CSV_PATH_INPUT, 0);
            infoCommunications = CSVProcessor.getRowStringFromCSVtoList(CSV_PATH_INPUT, 1);

            for (int i = 0; i < listCommunications.size(); i++) {
                String idFound = rgxUtil.findCurrentIncidenteInString(infoCommunications.get(i), CROSS_ID);

                /*Finding Valid CrossID in the description of the list*/
                //if (idFound != null) {
                    if (idFound == null) {
                    /* Creating a Record Object and adding it to ArrayList*/
                    resultSearch = StreamSearch.execSearchInCSVtoRecord(listCommunications.get(i));

                    /* More than 0 matches */
                    if (resultSearch.size() > 0) {
                        for (int rx = 0; rx < resultSearch.size(); rx++) {
                            int lastIndexOf = resultSearch.get(rx).getFileName().lastIndexOf(".");
                            /* Filtering only for pdf files avoiding xlsx or kmz that contains filename in path */
                            if (resultSearch.get(rx).getFileName().substring(lastIndexOf).equals(".pdf")) {
                                if (rgxUtil.findCurrentIncidenteInString(resultSearch.get(rx).getFileName(), listCommunications.get(i)) != null) {
                                    //System.out.println("Match: "+resultSearch.get(rx).getFileName());
                                    String newFileName = resultSearch.get(rx).getFileName();

                                    //IS NOT CROSS
                                    //newFileName = newFileName.replace(".pdf", "_").concat(idFound).concat(".pdf");
                                    newFileName = newFileName.replace(".pdf", "_").concat(infoCommunications.get(i)).concat(".pdf");
                                    newFileName = newFileName.replace(" - ", "");
                                    newFileName = newFileName.replace("- ", "");
                                    newFileName = newFileName.replace(" ", "");
                                    newFileName = newFileName.replace("(", "");
                                    newFileName = newFileName.replace(")", "");

                                    if (!FilesCopier.fileExistInPath(PATH_FILE_DESTINATION.concat(newFileName))) {
                                        FilesCopier.fileCopier(new File(resultSearch.get(rx).getFilePath()), new File(PATH_FILE_DESTINATION.concat(newFileName)));
                                        totalFilesCopied++;
                                    }
                                    System.out.println("Done: " + PATH_FILE_DESTINATION.concat(newFileName));
                                    System.out.println("Total Files Copied: "+totalFilesCopied);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            //System.out.println("Exception - Error: " + e);
            e.printStackTrace();
        }
    }
}