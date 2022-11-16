package startup.init.vault.loader.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtility {

    /**
     * Function that returns a nested key and filename into Hash Map if the string contains the input parameter
     *
     * @param "inputList"
     * @param "inputSearchParam"
     * @return
     */
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

    /**
     * Match regex into string
     *
     * @param textToReview
     * @param regexCondition
     * @return
     */
    public String findCurrentIncidenteInString(String textToReview, String regexCondition) {
        String rtnStr = null;
        Pattern pattern = Pattern.compile(regexCondition, Pattern.CASE_INSENSITIVE); //,Pattern.CASE_INSENSITIVE
        Matcher matcher = pattern.matcher(textToReview);
        if (matcher.find()) {
            rtnStr = matcher.group(0);
            //this.setListOutLetters(matcher.group(2));
            //this.setListInLetters(matcher.group(3));
        }
        return rtnStr;
    }

    public static String matchInString(String textToReview, String regexCondition) {
        String rtnStr = null;
        Pattern pattern = Pattern.compile(regexCondition, Pattern.CASE_INSENSITIVE); //,Pattern.CASE_INSENSITIVE
        Matcher matcher = pattern.matcher(textToReview);
        if (matcher.find()) {
            rtnStr = matcher.group(0);
            //this.setListOutLetters(matcher.group(2));
            //this.setListInLetters(matcher.group(3));
        }
        return rtnStr;
    }

}
