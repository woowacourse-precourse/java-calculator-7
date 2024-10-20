package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();  // 입력 받기

        ArrayList<String> delimiters = getDelimiter(inputStr);
//        if (strs == " ") {
//            return 0;
//        }
        if (delimiters.size() > 2) {
            String regex = checkSpecialDelimiter(inputStr);
            inputStr = changeInputStr(regex,inputStr);
        }

        // error case 확인
        try {
            checkForErrors(inputStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

//        // debug
//        for (String delimiter : delimiters) {
//            System.out.println(delimiter.getClass().getName());
//        }
        int sumNum = splitDelimiterAddNum(inputStr, delimiters);
        System.out.println("결과 : " + sumNum);
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
            throw new IllegalArgumentException();
        }
    }
    public static int splitDelimiterAddNum(String inputString, ArrayList delimiters){
        StringBuilder newString = new StringBuilder();
        int sumNum = 0;

        for (int i =0;i<inputString.length();i++){
            char ch = inputString.charAt(i);

            if (delimiters.contains(String.valueOf(ch))) {
                sumNum += Integer.parseInt(newString.toString());
                newString.delete(0,newString.length());
            } else if (Character.isDigit(ch)) {
                newString.append(ch);
            } else {
                System.out.println("Error 발생 : " +ch);
//                throw new IllegalArgumentException("특수문자가 발생");
            }
        }
        sumNum += Integer.parseInt(newString.toString());
        return sumNum;
    }
}
