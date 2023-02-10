package model.functions;

import data.pass.db.ConnectBd;
import model.objects.CommRecord;
import org.apache.poi.ss.usermodel.*;
import startup.init.start.InitStartup;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import startup.init.start.InitStartup;
import startup.init.vault.loader.utils.POIApacheDataProcessor;
import startup.init.vault.loader.utils.RegexUtility;

public class BulkLogBook {

    private boolean isValidRecord() {
        return this.validRecord;
    }
    private void setValidRecord(boolean validRec) {
        this.validRecord = validRec;
    }

    boolean validRecord = false;

    public BulkLogBook() throws ClassNotFoundException, SQLException {
        int currentTab = 0;
        int noOfColumns = 0;
        String verifyQry = "SELECT COUNT(*) FROM [" + InitStartup.DEFAULT_BD_NAME + "].[dbo]." + InitStartup.DEFAULT_TABLE_COMS;
        String insertQry = "INSERT INTO [dbo].[" + InitStartup.DEFAULT_TABLE_COMS + "](idfile,date_com,date_recipt,type_com,subject_com,author,received_ori,desc_com,references_com) VALUES (";
        CommRecord commItem = new CommRecord();

        File directoryPath = new File(InitStartup.DEFAULT_PATH_COMS);
        String[] contents = directoryPath.list();

        if (contents.length > 0) {
            if (ConnectBd.executeTableVerification(InitStartup.DEFAULT_BD_NAME, InitStartup.DEFAULT_TABLE_REPORT)) {

                Connection currentConnection = ConnectBd.startConnection_WAuth(InitStartup.DEFAULT_BD_NAME);
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Statement stmt = currentConnection.createStatement();
                ResultSet rs = stmt.executeQuery(verifyQry);

                try {
                    for (String item : contents) {
                        int lastIndexOf = item.lastIndexOf(".");

                        if (item.substring(lastIndexOf).equals(".xls") || item.substring(lastIndexOf).equals(".xlsx")) {
                            File tempFile = new File(InitStartup.DEFAULT_PATH_COMS + item);
                            System.out.println("Current File: " + tempFile);

                            Workbook workbook = WorkbookFactory.create(tempFile);
                            Sheet firstSheet = workbook.getSheetAt(currentTab);
                            Iterator<Row> iterator = firstSheet.iterator();

                            noOfColumns = firstSheet.getRow(6).getPhysicalNumberOfCells();

                            System.out.println("Columns Found: " + noOfColumns);

                            if (noOfColumns != 0) {
                                while (iterator.hasNext()) {
                                    Row nextRow = iterator.next();
                                    Iterator<Cell> cellIterator = nextRow.cellIterator();

                                    while (cellIterator.hasNext()) {
                                        Cell cell = cellIterator.next();

                                        if (cell.getRowIndex() >= 7) {
                                            if (cell.getColumnIndex() == 0) {
                                                setValidRecord(RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_META_COM, cell.toString()));
                                            }

                                            if (isValidRecord() && cell.getColumnIndex() <= noOfColumns) {
                                                switch (cell.getColumnIndex()) {
                                                    case 0:
                                                        commItem.setFolioComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 1:
                                                        commItem.setDateComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 2:
                                                        commItem.setDateReceipt(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 3:
                                                        commItem.setTypeComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 4:
                                                        commItem.setSubjectComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 5:
                                                        commItem.setAuthorComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 6:
                                                        commItem.setOriginalReceived(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 7:
                                                        commItem.setCommentsComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                    case 8:
                                                        commItem.setReferenceComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                        break;
                                                }
                                            }
                                        }
                                    }

                                    if (isValidRecord()) {
                                        String query = insertQry + "'" +
                                                commItem.getFolioComm() + "','" +
                                                commItem.getDateComm() + "','" +
                                                commItem.getDateReceipt() + "','" +
                                                commItem.getTypeComm() + "','" +
                                                commItem.getSubjectComm() + "','" +
                                                commItem.getAuthorComm() + "','" +
                                                commItem.getOriginalReceived() + "','" +
                                                commItem.getCommentsComm() + "','" +
                                                commItem.getReferenceComm() + "')";

                                        System.out.println("Query: " + query);
                                        ConnectBd.execQueryInsert(currentConnection, query);
                                    }
                                    rs.close();
                                    stmt.closeOnCompletion();
                                }
                            }//IF of validation to firt column
                        } else {
                            //System.out.println(">> "+ConnectBd.TestTableExist_JDBC("AGENTS"));
                            JOptionPane.showMessageDialog(null, "Table " + InitStartup.DEFAULT_TABLE_REPORT + " is not present in current database. Verify.", "Table not found", JOptionPane.ERROR_MESSAGE);
                        }
                    }//for

                    currentConnection.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    currentConnection.close();
                }
            }
        } else {
            //System.out.println(">> "+ConnectBd.TestTableExist_JDBC("AGENTS"));
            JOptionPane.showMessageDialog(null, "No files in folder: " + InitStartup.DEFAULT_PATH_COMS + ". Verify.", "Files not found", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
