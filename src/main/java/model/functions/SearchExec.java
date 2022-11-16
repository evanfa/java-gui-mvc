package model.functions;

import model.JTableTemplate_Download;
import model.TableModelTemplate;
import model.objects.Record;
import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.RegexUtility;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.io.File;
import java.util.ArrayList;

public class SearchExec {

    private ArrayList<Record> resultQuery;
    private TableModelTemplate tableModel;
    private JTableTemplate_Download tableDownloadModel;
    private JTable srchResult_JTable;
    private TableColumnModel columnModel;
    
    public void actionAdd(String inputValueSearch) {
        String infoValue;
        System.out.println("Action Run");
        if (!inputValueSearch.equals("")) {
            resultQuery = getArrayListResultsIfCoincidenceFound((ArrayList<String>) InitStartup.getPathsList(), inputValueSearch);
            System.out.println("Query Size: " + resultQuery.size());
            infoValue = "Query Result Size: "+resultQuery.size();

            if(resultQuery.size()>0){
                //updateAddButton(true);
                //updateClearButton(true);
                //updateProccessButton(true);
                /*New table model for display result data set*/
                /*------------------------------------------------*/
                tableModel = new TableModelTemplate();
                /*------------------------------------------------*/
                /*New table model Created when exist a result in current execution*/
                /*------------------------------------------------*/
                tableDownloadModel = new JTableTemplate_Download();
                /*------------------------------------------------*/

                tableModel.setListItemsFound(resultQuery);

                for(Record record: tableModel.getListItemsFound()){
                    System.out.println("Id: " + record.indexId);
                    System.out.println("File: " + record.fileName);
                    System.out.println("Path: " + record.filePath);
                    System.out.println("Flag: " + record.selectedId);
                }

                srchResult_JTable.setModel(tableModel);
                columnModel = srchResult_JTable.getColumnModel();
                /*columnModel.getColumn(0).setPreferredWidth(8);
                columnModel.getColumn(1).setPreferredWidth(165);
                columnModel.getColumn(2).setPreferredWidth(1200);
                columnModel.getColumn(3).setPreferredWidth(12);*/

                columnModel.getColumn(0).setPreferredWidth((int)Math.round(srchResult_JTable.getWidth()*.05));
                columnModel.getColumn(1).setPreferredWidth((int)Math.round(srchResult_JTable.getWidth()*.15));
                columnModel.getColumn(2).setPreferredWidth((int)Math.round(srchResult_JTable.getWidth()*.75));
                columnModel.getColumn(3).setPreferredWidth((int)Math.round(srchResult_JTable.getWidth()*.05));


            }else {
                //tableModel.removeAllRows();

                //updateAddButton(false);
                //updateClearButton(false);
                //updateProccessButton(false);

                JOptionPane.showMessageDialog(null,
                        "Non Items Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
                infoValue = "Non matches were found";
            }
        } else {
            //updateAddButton(false);
            //updateClearButton(false);
            //updateProccessButton(false);

            JOptionPane.showMessageDialog(null,
                    "Empty Input Field", "Error",
                    JOptionPane.ERROR_MESSAGE);

            infoValue = "Empty search field";
        }
    }

    /**
     * Function that returns a Array List of Records that contains index, filename, path of the inputList that contains
     * the parameter searched.
     *
     * @param inputList
     * @param inputSearchParam
     * @return
     */
    public static ArrayList<Record> getArrayListResultsIfCoincidenceFound(ArrayList<String> inputList, String inputSearchParam) {
        ArrayList<Record> rcdS = new ArrayList<Record>();
        RegexUtility frU = new RegexUtility();
        for (int i = 0; i < inputList.size(); i++) {
            if (frU.findCurrentIncidenteInString(inputList.get(i), inputSearchParam) != null) {
                File tmp = new File(inputList.get(i));
                Record rd = new Record(i, tmp.getName(), tmp.getAbsolutePath(),false);
                rcdS.add(rd);
            }
        }
        return rcdS;
    }
}
