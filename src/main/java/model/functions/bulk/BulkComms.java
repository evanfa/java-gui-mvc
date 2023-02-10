package model.functions.bulk;

import model.objects.CommRecord;

import java.util.HashMap;

public class BulkComms {
    HashMap<String,CommRecord> commMap=new HashMap<String,CommRecord>();

    public void addCommRecord(String indexComm, CommRecord commInfo){
        commMap.put(indexComm,commInfo);
    }

    public HashMap<String,CommRecord> getCommMap(){
        return commMap;
    }

    public void traversingWholeMap(){
        commMap.forEach((k, v) -> System.out.println(k + " : "+ v ));
    }

    public CommRecord findCommRecord(String valueToFind){
        System.out.println("Value Found: "+commMap.get(valueToFind));
        return commMap.get(valueToFind);
    }

}
