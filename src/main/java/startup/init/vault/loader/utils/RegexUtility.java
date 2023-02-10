package startup.init.vault.loader.utils;

import startup.init.start.InitStartup;

import java.io.File;
import java.util.Arrays;
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
            if (frU.matchTextInString(inputList.get(i), inputSearchParam) != null) {
                File tmp = new File(inputList.get(i));
                map.put(i, tmp.getName());
            }
        }
        return map;
    }

    /**
     * Function thats return match in string. Considering the group(0) after regex/patter/matcher search.
     *      * Patter set as CASE_INSENSITIVE
     *
     * @param textToReview
     * @param regexCondition
     * @return
     */
    public static String matchTextInString(String textToReview, String regexCondition) {
        String rtnStr = null;
        Pattern pattern = Pattern.compile(regexCondition, Pattern.CASE_INSENSITIVE); //,Pattern.CASE_INSENSITIVE
        Matcher matcher = pattern.matcher(textToReview);
        if (matcher.find()) {
            rtnStr = matcher.group(0);
        }
        return rtnStr;
    }

    /**
     * Function that return boolean if given string is in text
     * @param strToSearch
     * @param toFind
     * @return Boolean
     */
    public static Boolean isRegexContainedIntoSingleString(String strToSearch, String toFind) {
        Pattern pattern = Pattern.compile(strToSearch);
        Matcher m = pattern.matcher(toFind);
        boolean flagExist = false;
        while (m.find()) {
            //System.out.println("Pattern found from " + m.start() + " to " + (m.end()-1));
            flagExist = true;
        }
        return flagExist;
    }

    /**
     * Function that reformat english date format 'month_name dd, yyyy' or 'yyyy-dd-month_name' to sql date format 'yyyy-mm-dd'
     *
     * @param textToReview
     * @return
     */
    /* TODO Fix to SOLID Methodology */
    public static String fixEnglishDateFormatToSQLDateFormat(String textToReview) {
        String rstString = "";
        String montString = "";
        List<String> lstMonths = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre",
                "Jan", "Ene", "Feb", "Mar", "Apr", "Abr", "May", "Jun", "Jul", "Aug", "Ago", "Sep", "Oct", "Nov", "Dec", "Dic");

        final Pattern pattern = Pattern.compile(InitStartup.REGEX_DATE_ENG, Pattern.CASE_INSENSITIVE);
        final Pattern patternInv = Pattern.compile(InitStartup.REGEX_DATE_RENG, Pattern.CASE_INSENSITIVE);
        final Pattern patternddmmyy = Pattern.compile(InitStartup.REGEX_DATE_DDMMYY, Pattern.CASE_INSENSITIVE);
        final Pattern patternddmmmmyy = Pattern.compile(InitStartup.REGEX_DATE_DDMMMMYY, Pattern.CASE_INSENSITIVE);

        final Matcher matcher = pattern.matcher(textToReview);
        final Matcher matcherInv = patternInv.matcher(textToReview);
        final Matcher matcherDMY = patternddmmyy.matcher(textToReview);
        final Matcher matcherDMMMMY = patternddmmmmyy.matcher(textToReview);

        //System.out.println("Date: "+textToReview);
        if (matcher.find()) {

            for (String lst : lstMonths) {
                if (matcher.group(2).equals(lst)) {
                    if (lst.equals("January") || lst.equals("Enero") || lst.equals("Ene") || lst.equals("Jan")) {
                        montString = "01";
                    }
                    if (lst.equals("February") || lst.equals("Febrero") || lst.equals("Feb")) {
                        montString = "02";
                    }
                    if (lst.equals("March") || lst.equals("Marzo") || lst.equals("Mar")) {
                        montString = "03";
                    }
                    if (lst.equals("April") || lst.equals("Abril") || lst.equals("Apr") || lst.equals("Abr")) {
                        montString = "04";
                    }
                    if (lst.equals("May") || lst.equals("Mayo")) {
                        montString = "05";
                    }
                    if (lst.equals("June") || lst.equals("Junio") || lst.equals("Jun")) {
                        montString = "06";
                    }
                    if (lst.equals("July") || lst.equals("Julio") || lst.equals("Jul")) {
                        montString = "07";
                    }
                    if (lst.equals("August") || lst.equals("Agosto") || lst.equals("Aug") || lst.equals("Ago")) {
                        montString = "08";
                    }
                    if (lst.equals("September") || lst.equals("Septiembre") || lst.equals("Sep")) {
                        montString = "09";
                    }
                    if (lst.equals("October") || lst.equals("Octubre") || lst.equals("Oct")) {
                        montString = "10";
                    }
                    if (lst.equals("November") || lst.equals("Noviembre") || lst.equals("Nov")) {
                        montString = "11";
                    }
                    if (lst.equals("December") || lst.equals("Diciembre") || lst.equals("Decembere") || lst.equals("Dic") || lst.equals("Dec")) {
                        montString = "12";
                    }
                }
            }

            if (matcher.group(2).length() == 4) {
                rstString = rstString.concat("20" + matcher.group(4)).concat("-").concat(montString).concat("-").concat(matcher.group(3));
                //System.out.println("Date Converted 4: "+rstString);
            }/*else if(matcher.group(2).length() == 2){
				rstString = rstString.concat("20"+matcher.group(4)).concat("-").concat(montString).concat("-").concat(matcher.group(3));
				System.out.println("Date Converted 2: "+rstString);
			}*/

        } else if (matcherInv.find()) {
            for (String lst : lstMonths) {
                if (matcherInv.group(4).equals(lst)) {
                    if (lst.equals("January") || lst.equals("Enero") || lst.equals("Ene") || lst.equals("Jan")) {
                        montString = "01";
                    }
                    if (lst.equals("February") || lst.equals("Febrero") || lst.equals("Feb")) {
                        montString = "02";
                    }
                    if (lst.equals("March") || lst.equals("Marzo") || lst.equals("Mar")) {
                        montString = "03";
                    }
                    if (lst.equals("April") || lst.equals("Abril") || lst.equals("Abr") || lst.equals("Apr")) {
                        montString = "04";
                    }
                    if (lst.equals("May") || lst.equals("Mayo")) {
                        montString = "05";
                    }
                    if (lst.equals("June") || lst.equals("Junio") || lst.equals("Jun")) {
                        montString = "06";
                    }
                    if (lst.equals("July") || lst.equals("Julio") || lst.equals("Jul")) {
                        montString = "07";
                    }
                    if (lst.equals("August") || lst.equals("Agosto") || lst.equals("Ago") || lst.equals("Aug")) {
                        montString = "08";
                    }
                    if (lst.equals("September") || lst.equals("Septiembre") || lst.equals("Sep")) {
                        montString = "09";
                    }
                    if (lst.equals("October") || lst.equals("Octubre") || lst.equals("Oct")) {
                        montString = "10";
                    }
                    if (lst.equals("November") || lst.equals("Noviembre") || lst.equals("Nov")) {
                        montString = "11";
                    }
                    if (lst.equals("December") || lst.equals("Diciembre") || lst.equals("Decembere") || lst.equals("Dec") || lst.equals("Dic")) {
                        montString = "12";
                    }
                }
            }
            //System.out.println("Length: "+matcher.group(2).length());
            if (matcher.group(2).length() == 4) {
                //System.out.println(">>>>>LENG>>>> "+matcher.group(2).length());
                rstString = rstString.concat(matcherInv.group(2)).concat("-").concat(montString).concat("-").concat(matcherInv.group(3));
                System.out.println("Date Converted: " + rstString);
            } else if (matcher.group(2).length() == 2) {
                rstString = rstString.concat("20" + matcherInv.group(2)).concat("-").concat(montString).concat("-").concat(matcherInv.group(3));
                System.out.println("Date Converted: " + rstString);
                //System.out.println(">>>>>LENG>>>> "+matcher.group(2).length());
            }
        } else if (matcherDMY.find()) {
            rstString = rstString.concat("20" + matcherDMY.group(2)).concat("-").concat(matcherDMY.group(3)).concat("-").concat(matcherDMY.group(4));
        } else if (matcherDMMMMY.find()) {
            for (String lst : lstMonths) {
                if (matcherDMMMMY.group(3).equals(lst)) {
                    if (lst.equals("January") || lst.equals("Enero") || lst.equals("Ene") || lst.equals("Jan")) {
                        montString = "01";
                    }
                    if (lst.equals("February") || lst.equals("Febrero") || lst.equals("Feb")) {
                        montString = "02";
                    }
                    if (lst.equals("March") || lst.equals("Marzo") || lst.equals("Mar")) {
                        montString = "03";
                    }
                    if (lst.equals("April") || lst.equals("Abril") || lst.equals("Apr") || lst.equals("Abr")) {
                        montString = "04";
                    }
                    if (lst.equals("May") || lst.equals("Mayo")) {
                        montString = "05";
                    }
                    if (lst.equals("June") || lst.equals("Junio") || lst.equals("Jun")) {
                        montString = "06";
                    }
                    if (lst.equals("July") || lst.equals("Julio") || lst.equals("Jul")) {
                        montString = "07";
                    }
                    if (lst.equals("August") || lst.equals("Agosto") || lst.equals("Aug") || lst.equals("Ago")) {
                        montString = "08";
                    }
                    if (lst.equals("September") || lst.equals("Septiembre") || lst.equals("Sep")) {
                        montString = "09";
                    }
                    if (lst.equals("October") || lst.equals("Octubre") || lst.equals("Oct")) {
                        montString = "10";
                    }
                    if (lst.equals("November") || lst.equals("Noviembre") || lst.equals("Nov")) {
                        montString = "11";
                    }
                    if (lst.equals("December") || lst.equals("Diciembre") || lst.equals("Decembere") || lst.equals("Dec") || lst.equals("Dic")) {
                        montString = "12";
                    }
                }
            }

            rstString = rstString.concat("20" + matcherDMMMMY.group(4)).concat("-").concat(montString).concat("-").concat(matcherDMMMMY.group(2));

        } else {
            rstString = textToReview;
        }
        return rstString;
    }

}
