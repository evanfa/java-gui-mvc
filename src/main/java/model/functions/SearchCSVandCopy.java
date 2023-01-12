package model.functions;

import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.CSVProcessor;
import startup.init.vault.loader.utils.FilesCopier;
import startup.init.vault.loader.utils.RegexUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that read CSV file with two columns - FileName && Description
 * Store in HashMap:
 * -(Key) => Filename
 * -(Data) => Description
 *
 * After that verify if the (key) exist in a dataset of communications by file name.
 * Return a (Record) object that contains a file name and path.
 *
 * Rename the file name adding the (CROSS_ID) container in the (Data) to concat the filename + IDCross.
 * And Copy that from server to local storage with in the PATH_FILE_DESTINATION.
 *
 */
public class SearchCSVandCopy {
    static final String CSV_PATH_INPUT = "C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-NorthFiles.csv";
    static final String PATH_FILE_DESTINATION = "C:\\Users\\fabio_rodriguez\\OneDrive - TransCanada Corporation\\Documents\\TGNH\\TVDR_Project\\PermisosTramosPendientes\\Files-Pendientes\\licencias\\NorthZone-Files\\test\\";
    static final String TVDR_INCOMING = "(tvdr)-([a-zA-Z-]*)-(tgnh)-([0-9]*)-([0-9a-zA-Z-]*)";
    static final String CROSS_ID = "[P]-[-0-9A-Z]*";
    static final String FILENET_ID = "1,\\d{3},\\d{3},\\d{3}";

    public static void main(String[] args) throws Exception {
        List<String> listCommunications = new ArrayList<String>();
        List<String> infoCommunications = new ArrayList<String>();

        RegexUtility rgxUtil = new RegexUtility();

        HashMap<String, String> comsMap = new HashMap<>();
        ArrayList<Record> resultSearch;

        try {
            InitStartup.loadTotalRecordsFromCSVFile("C:/Users/fabio_rodriguez/OneDrive - TransCanada Corporation/Documents/IT/Paths-CSV-CopyFiles/TVDR-dump-totalfiles-permits-10Jan2023.csv");

            listCommunications = CSVProcessor.getRowStringFromCSVtoList(CSV_PATH_INPUT, 0);
            infoCommunications = CSVProcessor.getRowStringFromCSVtoList(CSV_PATH_INPUT, 1);

            for (int i = 0; i < listCommunications.size(); i++) {
                comsMap.put(listCommunications.get(i), infoCommunications.get(i));
            }

            for (Map.Entry<String, String> entry : comsMap.entrySet()) {
                //System.out.println(entry.getKey() + " : " + entry.getValue());

                /*
                Searching CROSS ID in Description of Permit
                 */
                String idFound = rgxUtil.findCurrentIncidenteInString(entry.getValue().toString(), CROSS_ID);

                /*
                If exist CROSS ID search file name in library and store result in HashMap
                 */
                if (idFound != null) {
                    //System.out.println("Found: " + idFound);
                    //System.out.println("Search Param: "+entry.getKey());
                    resultSearch = StreamSearch.execSearchInCSVtoRecord(entry.getKey());

                    if (!resultSearch.isEmpty() && resultSearch.size() > 0) {
                       // System.out.println("Records of ["+idFound+"]: " + resultSearch.size());

                        if(resultSearch.size()>0){
                            for (int i = 0; i < resultSearch.size(); i++) {
                                int lastIndexOf = resultSearch.get(i).getFileName().lastIndexOf(".");
                                /*
                                Filtering only for pdf files avoiding xlsx or kmz that contains filename in path
                                 */

                                if (resultSearch.get(i).getFileName().substring(lastIndexOf).equals(".pdf")){
                                    /*
                                    If File name has nomenclature of TVDR INCOMING needs to rename with the CROSSID
                                     */
                                    if(rgxUtil.findCurrentIncidenteInString(resultSearch.get(i).getFileName(), TVDR_INCOMING) != null){
                                        //System.out.println("TVDR_OK: "+resultSearch.get(i).getFileName());
                                        if(rgxUtil.findCurrentIncidenteInString(resultSearch.get(i).getFileName(), CROSS_ID)!=null){
                                            String newFileName = resultSearch.get(i).getFileName().replace(rgxUtil.findCurrentIncidenteInString(resultSearch.get(i).getFileName(), CROSS_ID),"");
                                                    newFileName.replace(".pdf","_").concat(rgxUtil.findCurrentIncidenteInString(entry.getValue().toString(), CROSS_ID).concat(".pdf"));
                                                    newFileName = newFileName.replace(" - ","");
                                                    newFileName = newFileName.replace("- ","");
                                                    newFileName = newFileName.replace(" ","");
                                                    newFileName = newFileName.replace("(","");
                                                    newFileName = newFileName.replace(")","");
                                                    newFileName = newFileName.replace(".pdf","_").concat(idFound).concat(".pdf");
                                            //System.out.println("TVDR_FIXED: "+newFileName);
                                            //+++++++++++++++++++++++++++++++++++++++++++++++++++++
                                            //FilesCopier.fileCopier(new File(resultSearch.get(i).getFilePath()),new File(PATH_FILE_DESTINATION.concat(newFileName)));
                                            //+++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        }
                                    }else

                                    if(rgxUtil.findCurrentIncidenteInString(resultSearch.get(i).getFileName(), FILENET_ID) != null){
                                        //System.out.println("TVD-FILENET: "+resultSearch.get(i).getFileName());

                                        String newFileName = resultSearch.get(i).getFileName().replace(rgxUtil.findCurrentIncidenteInString(resultSearch.get(i).getFileName(), FILENET_ID),entry.getKey());
                                                newFileName = newFileName.replace(".pdf","_").concat(idFound).concat(".pdf");
                                                newFileName = newFileName.replace("filenet# ","");
                                                //System.out.println("FILENET_FIXED: "+newFileName);
                                        //+++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        //FilesCopier.fileCopier(new File(resultSearch.get(i).getFilePath()),new File(PATH_FILE_DESTINATION.concat(newFileName)));
                                        //+++++++++++++++++++++++++++++++++++++++++++++++++++++

                                    }

                                }

                            }
                        }
                        //System.out.println("\t\t Record: "+resultSearch.get(0).getFileName());
                    }
                }
                //System.out.println("");
            }
        } catch (Exception e) {
            //System.out.println("Exception - Error: " + e);
            e.printStackTrace();
        }
    }
}