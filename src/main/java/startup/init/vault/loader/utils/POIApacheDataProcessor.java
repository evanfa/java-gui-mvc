package startup.init.vault.loader.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class POIApacheDataProcessor {
    static final List<String> listPermits;
    static int incidencesFound = 0;
    static int currentRow = 0;
    static boolean validRecordFound = false;
    static String currentFileName;

    static {
        listPermits = new ArrayList<String>();
    }

    public static String getCurrentFileName() {
        return currentFileName;
    }

    public static void setCurrentFileName(String getCurrentFileName) {
        POIApacheDataProcessor.currentFileName = getCurrentFileName;
    }

    public static Boolean getValidRecordFound() {
        return validRecordFound;
    }

    public static void setValidRecordFound(Boolean flagValid) {
        validRecordFound = flagValid;
    }

    public static void clearList() {
        listPermits.clear();
    }

    public static List<String> getListPermits() {
        return listPermits;
    }

    public static void setItemListPermits(String str) {
        POIApacheDataProcessor.listPermits.add(str);
    }

    public static int getCurrentRow() {
        return currentRow;
    }

    public static void setCurrentRow(int currentRow) {
        POIApacheDataProcessor.currentRow = currentRow;
    }

    public static String setUpPOIDataType_Identifier(Cell currentCell) {
        /*
         * Validation
         * 1. Verify if blank cell: setItemListPermits(null) return null if blank
         * 2. Verify if formula: setItemListPermits(resultFormula)
         */
        String tempStr = null;

        switch (currentCell.getCellType()) {
            case BOOLEAN:
                tempStr = "" + currentCell.getBooleanCellValue();
                break;

            case BLANK:
                //tempStr = null;
                break;

            case FORMULA:
                if (currentCell.getCachedFormulaResultType() == CellType.NUMERIC) {
                    if (DateUtil.isCellDateFormatted(currentCell)) {
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateValue = currentCell.getDateCellValue();
                        tempStr = df.format(dateValue);
                    } else {
                        tempStr = "" + currentCell.getNumericCellValue();
                    }
                } else {
                    tempStr = currentCell.getRichStringCellValue().toString();
                    tempStr = tempStr.replace("'", "");
                }
                break;

            case NUMERIC:
                if (DateUtil.isCellDateFormatted(currentCell)) {
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateValue = currentCell.getDateCellValue();
                    tempStr = df.format(dateValue);
                } else {
                    tempStr = "" + currentCell.getNumericCellValue();
                }
                break;

            case STRING:
                /*TODO Pre-validation if data format is no YYYY-MM-DD aplies string conversion*/
                if (currentCell.getColumnIndex() == 1 || currentCell.getColumnIndex() == 2) {
                    if (currentCell.getRichStringCellValue().toString().equals("NA") ||
                            currentCell.getRichStringCellValue().toString().equals("N/A")) {
                        tempStr = null;
                    } else {
                        if (!currentCell.getRichStringCellValue().equals(null)) {
                            tempStr = RegexUtility.fixEnglishDateFormatToSQLDateFormat(currentCell.getRichStringCellValue().toString());
                        } else {
                            tempStr = null;
                        }

                    }
                } else {
                    tempStr = currentCell.getRichStringCellValue().toString();
                    tempStr = tempStr.replace("\\", "/");
                    tempStr = tempStr.replace("'", "");
                }
                break;

            default:
                break;
        }
        return tempStr;
    }


}
