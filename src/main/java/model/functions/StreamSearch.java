package model.functions;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.RegexUtility;

import java.util.ArrayList;

public class StreamSearch {

    public StreamSearch() {
    }

    public static  ArrayList<String> execSearchInCSV(String searchString){
        ArrayList<String> searchResultList = new ArrayList<>();
        InitStartup.getRecordsInCSVFile().parallelStream().forEach(
                item->
                {
                    if (RegexUtility.matchInString(item, searchString)!=null) {
                        searchResultList.add(item);
                    }
                }
        );
        return searchResultList;
    }

}
