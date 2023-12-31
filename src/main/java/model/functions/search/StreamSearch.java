package model.functions.search;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.RegexUtility;

import java.util.ArrayList;

import static startup.init.start.InitStartup.getRecordsInCSVFile;

public class StreamSearch {
    private static int indexId = 0;

    public StreamSearch() {
    }

    public static  ArrayList<String> execSearchInCSV(String searchString){
        ArrayList<String> searchResultList = new ArrayList<>();
        getRecordsInCSVFile().parallelStream().forEach(
                item->
                {
                    if (RegexUtility.matchTextInString(item, searchString)!=null) {
                        searchResultList.add(item);
                    }
                }
        );
        return searchResultList;
    }

    public static  ArrayList<Record> execSearchInCSVtoRecord(String searchString){
        ArrayList<Record> searchResultList = new ArrayList<>();

        getRecordsInCSVFile().parallelStream().forEach(
                item->
                {
                    if (RegexUtility.matchTextInString(item, searchString)!=null) {
                        searchResultList.add(new Record(getIndex(),item.substring(item.lastIndexOf("\\")+1,item.length()), item, false));
                    }
                }
        );
        return searchResultList;
    }

    public static int getIndex(){
        return indexId++;
    }

}
