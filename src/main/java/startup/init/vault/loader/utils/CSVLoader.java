package startup.init.vault.loader.utils;

import startup.init.start.InitStartup;

import javax.swing.*;
import java.io.File;
import java.util.*;

public class CSVLoader {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String COMMA_SEPARATOR = ",";

    public static List<String> getRowStringFromCSVtoList(String csvFilePathPath, int columnInput) throws Exception {
        List<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(new File(csvFilePathPath));
        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine());
            list.add(line.get(columnInput));
            //System.out.println("> "+line);
        }

        scanner.close();
        return list;
    }

    public static HashMap<Integer, String> getHashIfCoincidenceFound(List<String> inputList, String inputSearchParam) {
        HashMap<Integer, String> map = new HashMap<>();
        RegexUtility frU = new RegexUtility();
        for (int i = 0; i < inputList.size(); i++) {
            if (frU.findCurrentIncidenteInString(inputList.get(i), inputSearchParam) != null) {
                File tmp = new File(inputList.get(i));
                map.put(i, tmp.getName());
            }
        }
        return map;
    }

    public static Map<Integer, String> getSearchResultMap(String paramToSearch) {
        /* Map Results*/
        Map<Integer, String> map = RegexUtility.getHashIfCoincidenceFound(InitStartup.getItemsInCsvFile(), paramToSearch);
        System.out.println("Map Result Size: " + map.size());

        if (map.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Non Items Availables in List to Complete Search", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Iterator<Integer> mapIterator = map.keySet().iterator();
            while (mapIterator.hasNext()) {
                int key = mapIterator.next();
                System.out.println(key + " > " + map.get(key));
            }
        }
        return map;
    }

    /**
     * String Parser
     *
     * @param cvsLine
     * @param separators
     * @param customQuote
     * @return
     */
    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }
                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }
        }
        result.add(curVal.toString());
        return result;
    }

    /**
     * Function parse line into list
     *
     * @param {String} cvsLine
     * @return List<String>
     */
    public static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

}