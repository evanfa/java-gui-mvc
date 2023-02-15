package model.functions;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.CSVProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BulkFileDownloader {
    
    public static void main(String[] args) {
        List<String> lstComms = new ArrayList<String>();
        int maxLenght = 0;
        int xlsCounter = 0;
        
        try{
            lstComms = CSVProcessor.getRowStringFromCSVtoList(InitStartup.PATH_FILE_BITACORAS,0);

            for (String lstComm : lstComms) {
                System.out.println(lstComm);
            }
            
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
        
    }
    
}
