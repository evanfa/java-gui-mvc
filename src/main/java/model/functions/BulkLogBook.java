    package model.functions;

    import data.pass.db.ConnectBd;
    import model.objects.CommRecord;
    import org.apache.poi.ss.usermodel.*;
    import startup.init.start.InitStartup;
    import startup.init.vault.loader.utils.POIApacheDataProcessor;
    import startup.init.vault.loader.utils.RegexUtility;

    import javax.swing.*;
    import java.io.File;
    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.Iterator;

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

            String verifyQry = "SELECT COUNT(*) FROM [" + InitStartup.DEFAULT_BD_NAME + "].[dbo]." + InitStartup.DEFAULT_TABLE_COMS;
            //String insertQry = "INSERT INTO [dbo].[" + InitStartup.DEFAULT_TABLE_COMS + "](idfile,date_com,date_recipt,type_com,subject_com,author,received_ori,desc_com,references_com) VALUES (";
            String insertQry = "INSERT INTO [dbo].[" + InitStartup.DEFAULT_TABLE_COMS + "](idfile,date_com,date_recipt,type_com,subject_com,author,received_ori,desc_com,references_com,id_permit) VALUES (";
            CommRecord commItem = new CommRecord();

            File directoryPath = new File(InitStartup.DEFAULT_PATH_COMS);
            String[] contents = directoryPath.list();

            assert contents != null;
            if (contents.length > 0) {
                if (ConnectBd.executeTableVerification(InitStartup.DEFAULT_BD_NAME, InitStartup.DEFAULT_TABLE_REPORT)) {

                    Connection currentConnection = ConnectBd.startConnection_WAuth(InitStartup.DEFAULT_BD_NAME);
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    assert currentConnection != null;
                    Statement stmt = currentConnection.createStatement();
                    ResultSet rs = stmt.executeQuery(verifyQry);

                    try {
                        //int noOfColumns = 0;
                        for (String item : contents) {
                            int lastIndexOf = item.lastIndexOf(".");

                            if (item.substring(lastIndexOf).equals(".xls") || item.substring(lastIndexOf).equals(".xlsx")) {
                                File tempFile = new File(InitStartup.DEFAULT_PATH_COMS + item);
                                System.out.println("Current File: " + tempFile);

                                Workbook workbook = WorkbookFactory.create(tempFile);
                                Sheet firstSheet = workbook.getSheetAt(currentTab);
                                Iterator<Row> iterator = firstSheet.iterator();

                                int noOfColumns = firstSheet.getRow(6).getPhysicalNumberOfCells();

                                if(noOfColumns==11){
                                    System.out.println("Columns Found: " + noOfColumns);

                                    while (iterator.hasNext()) {
                                        Row nextRow = iterator.next();
                                        Iterator<Cell> cellIterator = nextRow.cellIterator();

                                        while (cellIterator.hasNext()) {
                                            Cell cell = cellIterator.next();
                                            //Starting using the 6th row as a initial row
                                            if(cell.getRowIndex()>4){
                                                if(cell.getColumnIndex()==1){
                                                    //System.out.println("Row: "+cell.getRowIndex()+"Col: "+cell.getColumnIndex()+" & +Cell Val: "+cell.toString());
                                                    //System.out.println("Valid Record: "+RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_META_COM, cell.toString()));
                                                    setValidRecord(RegexUtility.isRegexContainedIntoSingleString(InitStartup.REGEX_META_COM, cell.toString()));
                                                }
                                                //Validation for data between Row: 6 to Column: 11
                                                if(isValidRecord() && cell.getColumnIndex()<12){
                                                    switch (cell.getColumnIndex()) {
                                                        case 0:
                                                            if(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell)!=null){
                                                                commItem.setIdMatrix(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell).replaceAll("\\r\\n|\\r|\\n", " "));
                                                            }else{
                                                                commItem.setIdMatrix(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            }
                                                            break;
                                                        case 1:
                                                            commItem.setFolioComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 2:
                                                            commItem.setDateComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 3:
                                                            commItem.setDateReceipt(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 4:
                                                            commItem.setTypeComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 5:
                                                            if(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell)!=null){
                                                                commItem.setSubjectComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell).replaceAll("\\r\\n|\\r|\\n", " "));
                                                            }else{
                                                                commItem.setSubjectComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            }
                                                            break;
                                                        case 6:
                                                            if(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell)!=null){
                                                                commItem.setAuthorComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell).replaceAll("\\r\\n|\\r|\\n", " "));
                                                            }else{
                                                                commItem.setAuthorComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            }
                                                            break;
                                                        case 7:
                                                            commItem.setOriginalReceived(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 8:
                                                            if(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell)!=null){
                                                                commItem.setCommentsComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell).replaceAll("\\r\\n|\\r|\\n", " "));
                                                            }else{
                                                                commItem.setCommentsComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            }
                                                            break;
                                                        case 9:
                                                            commItem.setStatusFilenet(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            break;
                                                        case 10:
                                                            if(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell)!=null){
                                                                commItem.setReferenceComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell).replaceAll("\\r\\n|\\r|\\n", " "));
                                                            }else{
                                                                commItem.setReferenceComm(POIApacheDataProcessor.setUpPOIDataType_Identifier(cell));
                                                            }
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
                                                    //commItem.getStatusFilenet() + "','" +
                                                    commItem.getReferenceComm() + "','" +
                                                    commItem.getIdMatrix() + "')";

                                            System.out.println("Query: " + query);
                                            ConnectBd.execQueryInsert(currentConnection, query);
                                        }

                                    }//While
                                    rs.close();
                                    stmt.closeOnCompletion();

                                }//Total Rows (11)

                                } else {
                                    System.out.println(">> No xls file");
                                    //JOptionPane.showMessageDialog(null, "Table " + InitStartup.DEFAULT_TABLE_REPORT + " is not present in current database. Verify.", "Table not found", JOptionPane.ERROR_MESSAGE);
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
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            BulkLogBook bLogProcessing = new BulkLogBook();
        }
    }
