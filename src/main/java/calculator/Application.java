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
//        System.out.println("입력한 문자 : " + inputStr);
        ArrayList<String> delimiters = getDelimiter(inputStr);

        // 빈 문장일 경우 0을 반환
        if (inputStr == null || inputStr.isEmpty()) {
            System.out.println("결과 : " + 0);
        }
        String changeInputStr;
//        System.out.println("특별 구분자 확인 "+delimiters);
        if (delimiters.size() > 2) {
            String regex = checkSpecialDelimiter(inputStr);
            changeInputStr = changeInputStr(regex,inputStr);
        }else {
            changeInputStr = inputStr;
        }
//        System.out.println("변경 된 문자열 "+ changeInputStr);


        // error case 확인
//        System.out.println("error check 전 ");
        checkForErrors(changeInputStr,delimiters);
//        System.out.println("error check 후");
        int sumNum = 0;
        sumNum = splitDelimiterAddNum(changeInputStr, delimiters);
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
        String regex = "^//.*\\\\n";
        Pattern pattern =Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher (inputString);

        if (matcher1.find()) {
            String delimiter = matcher1.group();
            return delimiter;
        } else {
            return null;
        }
    }
    public static String changeInputStr(String matchStr, String inputString){
        String changeStr = inputString.replace(matchStr,"");
//        System.out.println(changeStr);
        return changeStr;
    }

    public static void checkForErrors (String inputString, ArrayList delimiters){
        // 특수구분자 외 알파벳과 특수기호
        StringBuilder errorCase = new StringBuilder();
        errorCase.append("[^-");
        for (Object delimiter : delimiters) {
            errorCase.append(delimiter);
        }
        errorCase.append("0-9]");
//        String ErrorCase1 = "[^0-9]";//"[^a-zA-Z]";
        String errorString = errorCase.toString();
        Pattern pattern1 = Pattern.compile(errorString);
        Matcher matcher1 = pattern1.matcher(inputString);

        // 숫자로 시작하지 않으면 오류(구분자로 시작하는 경우 에러 발생)
        String startError = "^[0-9].*";
        Pattern pattern2 = Pattern.compile(startError);
        Matcher matcher2 = pattern2.matcher(inputString);

        // 숫자로 끝나지 않으면 오류
        String endError = "[0-9]$";
        Pattern pattern3 = Pattern.compile(endError);
        Matcher matcher3 = pattern3.matcher(inputString);

        if (matcher1.find()) { // 특수구분자와 '-'기호를 제외한 알파벳과 특수 기호 시 에러
            throw new IllegalArgumentException();
        }
        if (matcher2.find() == false || matcher3.find() == false) { // 숫자로 시작하지 않으면 에러 or 숫자로 끝나지 않으면 에러
            throw new IllegalArgumentException();
        }
    }

    public static int splitDelimiterAddNum(String inputString, ArrayList delimiters){
        StringBuilder newString = new StringBuilder();
        int sumNum = 0;
        // 음수 해결
        for (int i =0;i<inputString.length();i++){
            char ch = inputString.charAt(i);

            if (delimiters.contains(String.valueOf(ch))) {
                sumNum += Integer.parseInt(newString.toString());
                newString.delete(0,newString.length());
            } else if (Character.isDigit(ch)) {
                newString.append(ch);
            } else if (ch == '-') {
                newString.append(ch);
            } else {
                throw new IllegalArgumentException("Error in splitDelimiterAddNum : last output = " + ch);
            }
        }
        sumNum += Integer.parseInt(newString.toString());
        return sumNum;
    }
}
