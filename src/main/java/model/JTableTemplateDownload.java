package model;

import model.objects.Download;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class JTableTemplateDownload extends AbstractTableModel implements Observer {
    private final ArrayList<Download> downloadList = new ArrayList<Download>();
    private static final String[] columnNames = {
            "File Name", "Size in MB", "Progress",
            "Speed in KB/s","Elapsed Time", "Status"
    };
    private static final Class[] columnClasses = {
            String.class, String.class, JProgressBar.class,
            String.class, String.class, String.class
    };

    public void addDownload(Download download) {
        download.addObserver(this);
        downloadList.add(download);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
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
        Download download = downloadList.get(row);
        switch (col) {
            case 0:
                return download.getFileOrigin();
            case 1:
                return download.getSize();
            case 2:
                return download.getProgress();
            //case 3:
            //   return download.getSpeed();
            case 3:
                return download.getElapsedTime();
            case 4:
                return download.getStatus();
        }
        return "";
    }

    @Override
    public void update(Observable arg0, Object arg1) {
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        return columnClasses[col];
    }

}
