package model;

import model.objects.Record;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class TableModelTemplate extends AbstractTableModel implements Observer {
    private ArrayList<Record> downloadList = new ArrayList<Record>();
    private final ArrayList<String> toDownloadList = new ArrayList<String>();

    private static final int COLUMN_CHECK_BOX = 3;

    private static final String[] columnNames = {
            "Id File",
            "File Name",
            "Absolute File Path",
            "Selection"};

    private static final Class[] columnClasses = {
            Integer.class,
            String.class,
            String.class,
            Boolean.class
    };

    public void addRow(Record download) {
        //download.addObserver(this);
        downloadList.add(download);
        // Fire table row insertion notification to table.
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void removeRow(int i){
        downloadList.remove(i);
        //Update
        fireTableRowsDeleted(getRowCount() - 1, getRowCount() - 1);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return downloadList.size();
    }

    @Override
    public Object getValueAt(int row, int col) {

        Record download = downloadList.get(row);
        switch (col) {
            case 0: // URL
                return download.getIndexId();
            case 1: // Size
                return download.getFileName();
            case 2: // Progress
                return download.getFilePath();
            case 3: //Speed
                return download.isSelectedId();
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        System.out.println("Vals: "+aValue+"Row: "+rowIndex+" Col: "+columnIndex);
        Record download = downloadList.get(rowIndex);
        download.selectedId = !download.selectedId;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == COLUMN_CHECK_BOX;
    }

    @Override
    public void update(Observable o, Object arg) {
        int index = downloadList.indexOf(o);
        // Fire table row update notification to table.
        fireTableRowsUpdated(index, index);
    }

    // Get a column's name.
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class<?> getColumnClass(int col){
        switch(col) {
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Boolean.class;
            default: return String.class;
        }
    }

    public void setListItemsFound(List<Record> listItemsFound) {
        this.downloadList = (ArrayList<Record>) listItemsFound;
    }

    /*public void setListItemsFound(ArrayList<String> listItemsFound) {
        this.downloadList = listItemsFound;
    }*/

    public List<Record>  getListItemsFound(){
        return this.downloadList;
    }

    /*
    Function that get list of selected items in list
     */
    public ArrayList<String> getListSelectedItemsFound(){
        return this.toDownloadList;
    }

    /*
    Function that set the list of selected items in list
     */
    public void setListSelectedItemsFound(String item){
        toDownloadList.add(item);
    }

    /*
    Function that clean list
     */
    public void removeAllSelectedItemsFound(){
        if(this.getRowCount()!=0){
            for (int i = this.getRowCount() - 1; i >= 0; i--) {
                downloadList.remove(i);
            }
        }
    }

    public void removeAllRows(){
        if(this.getRowCount()!=0){
            for (int i = this.getRowCount() - 1; i >= 0; i--) {
                downloadList.remove(i);
            }
            fireTableRowsDeleted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    /**
     * Function that retrieve all selected paths to be processed in downloader tab
     */
    public void processSelectedItems(){
        if(this.getRowCount()!=0){
            for (int i = this.getRowCount() - 1; i >= 0; i--) {
                //if(this.getValueAt(i,3).getClass() == Boolean.class ){
                if((Boolean)this.getValueAt(i,3) == true){
                    System.out.println(i+" Selected: "+downloadList.get(i).filePath);
                    setListSelectedItemsFound(downloadList.get(i).filePath);
                }
                //}
            }
        }
    }
}