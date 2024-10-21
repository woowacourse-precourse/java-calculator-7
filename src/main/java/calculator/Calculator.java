package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    /**
     * 문자열을 입력받아 반환하는 함수.
     *
     * @return 입력받은 문자열
     */
    public String input(){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    /**
     * 기본 구분자(쉼표, 콜론)를 '@'로 변환하여 새로운 문자열을 반환하는 함수.
     *
     * @param inputStr 변환할 문자열
     * @return 변환된 문자열
     */
    public String basicSeparate(String inputStr){
        String resultStr = inputStr.replace(":", "@");
        resultStr = resultStr.replace(",", "@");

        return resultStr;
    }

    /**
     * 커스텀 구분자를 '@'로 변환하여 새로운 문자열을 반환하는 함수.
     *
     * @param inputStr 변환할 문자열
     * @return 변환된 문자열
     */
    public String customSeparate(String inputStr){
        ArrayList<String> customSeparators = getCustomSeparators(inputStr);
        inputStr = inputStr.replaceAll("\\/\\/(.)\\\\n", "");

        for(String separator : customSeparators){
            inputStr = inputStr.replaceAll(separator, "@");
        }

        return inputStr;
    }

    public ArrayList<String> getCustomSeparators(String inputStr){
        Pattern pattern = Pattern.compile("\\/\\/(.)\\\\n");
        Matcher matcher = pattern.matcher(inputStr);

        ArrayList<String> custom = new ArrayList<>();

        while (matcher.find()){
            custom.add(matcher.group(1));
        }

        return custom;
    }
}
