package model.functions;

import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.RegexUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class StreamSearch {
    private ArrayList<String> resultDatase;

    public StreamSearch(String searchString) {
        //inputList.stream().mat

        int matchesFound = 0;
        //InitStartup.getPathsList().parallelStream().forEach(System.out::println);

    }

    public static  ArrayList<String> execSearchInCSV(String searchString){
        ArrayList<String> searchResultList = null;
        InitStartup.getRecordsInCSVFile().parallelStream().forEach(
                (item)->
                {
                    System.out.println("Item: "+item);
                    //if (RegexUtility.matchInString(item, searchString) != null) {
                     //   searchResultList.add(item);
                        //matchesFound++;
                    //}
                }
        );
        return searchResultList;
    }

}
