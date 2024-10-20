package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //testg
        String strs = "//;\n1;2;3,4,5:6a";
        String strs1 = "1,2,3,4:5";
        ArrayList<String> delimiters = getDelimiter(strs);
//        if (strs == " ") {
//            return 0;
//        }
        if (delimiters.size() > 2) {
            String regex = checkSpecialDelimiter(strs);
            strs = changeInputStr(regex,strs);
            // DEBUG
        }
        // error case 확인
        try {
            checkForErrors(strs);
        } catch (IllegalArgumentException e) {
            System.out.println("에러발생 " + e.getMessage());
        }

        // debug
        for (String delimiter : delimiters) {
            System.out.println(delimiter);
        }
    }
    public static ArrayList<String> getDelimiter(String inputString){
        ArrayList<String> delimiters = new ArrayList<>();
        // default delimiters
        delimiters.add(",");
        delimiters.add(":");

        String regex = checkSpecialDelimiter(inputString);
        if (regex != null) {
            String specialDelimiter = getSpecialDelimiter(regex);
            delimiters.add(specialDelimiter);
        }
        return delimiters;
    }
    public static String getSpecialDelimiter(String matchStr) {
        // 특수 구분자가 하나의 문자가 아닐 수 있다.
        String delimiter = matchStr.substring(2,3);
        return delimiter;
    }

    public static String checkSpecialDelimiter (String inputString) {
        // 정규표현식
        // 특수 구분자가 하나의 char이 아닐수 있음
        // //n으로 주는지 /n으로 주어지는지 모르겠다.
        String regex = "^//.*\\n";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher (inputString);
        if (matcher1.find()) {
            String delimiter = matcher1.group();
            return delimiter;
        } else {
            return null;
        }
    }
    public static String changeInputStr(String matchStr, String InputString){
        String[] modStr = InputString.split(matchStr);
        String changeStr = modStr[modStr.length - 1];
        return changeStr;
    }


    public static void checkForErrors (String inputString){
        String ErrorCase1 = ".*[a-zA-Z].*";//"[^a-zA-Z]";
        Pattern pattern1 = Pattern.compile(ErrorCase1);
        Matcher matcher1 = pattern1.matcher(inputString);

        if (matcher1.find()) {
            throw new IllegalArgumentException("알파벳이 존재");
        }
    }
}
