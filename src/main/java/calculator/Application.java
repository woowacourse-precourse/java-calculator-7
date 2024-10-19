package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //testg
        String strs = "//: \n1;2;3,4,5:6";
        String strs1 = "1,2,3,4:5";
        ArrayList<String> delimiters = getDelimiter(strs);
        for (String item : delimiters) {
            System.out.printun("구분자 =" + item);
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
}
