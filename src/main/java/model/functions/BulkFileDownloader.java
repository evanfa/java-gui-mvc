package model.functions;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.CSVProcessor;
import startup.init.vault.loader.utils.FilesCopier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BulkFileDownloader {
    
    public static void main(String[] args) {
        List<String> lstComms = new ArrayList<String>();
        int maxLenght = 0;
        int xlsCounter = 0;

        int counter = 0;
        
        try{
            lstComms = CSVProcessor.getRowStringFromCSVtoList(InitStartup.PATH_FILE_BITACORAS,0);

            for (String lstComm : lstComms) {
                File temp = new File(lstComm);
                String fileName = temp.getName();
                int lastIndexOf = fileName.lastIndexOf(".");

                if(lastIndexOf!=-1){
                    System.out.println("Processing:> "+lstComm);
                    System.out.println("File: "+fileName+" - Ext: "+fileName.substring(lastIndexOf));

                    if(fileName.substring(lastIndexOf).equals(InitStartup.DEFAULT_FILE_EXTESION)){
                        if (!FilesCopier.fileExistInPath(InitStartup.DEFAULT_PATH_COMS.concat(fileName))) {
                            FilesCopier.generateCopyFileInPath(lstComm,InitStartup.DEFAULT_PATH_COMS.concat(counter+"_").concat(fileName));
                            counter++;
                        }
                    }
                }
            }

            System.out.println("Totals CSV Files Downloaded: "+counter);

        }catch (Exception e){
            System.out.println("Exception: "+e);
        }

    }

}
