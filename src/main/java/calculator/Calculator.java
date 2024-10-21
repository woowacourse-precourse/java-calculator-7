package calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열을 처리하고 계산을 수행하는 계산기 클래스
 */
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
    public String replaceBasicSeparators(String inputStr){
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
    public String replaceCustomSeparate(String inputStr){
        ArrayList<String> customSeparators = getCustomSeparators(inputStr);
        inputStr = inputStr.replaceAll("\\/\\/(.)\\\\n", "");

        for(String separator : customSeparators){
            inputStr = inputStr.replaceAll(separator, "@");
        }

        return inputStr;
    }
    /**
     * 커스텀 구분자들을 반환하는 함수.
     *
     * @param inputStr 변환할 문자열
     * @return 구분자 모음 ArrayList
     */
    public ArrayList<String> getCustomSeparators(String inputStr){
        Pattern pattern = Pattern.compile("\\/\\/(.)\\\\n");
        Matcher matcher = pattern.matcher(inputStr);

        ArrayList<String> custom = new ArrayList<>();

        while (matcher.find()){
            custom.add(matcher.group(1));
        }

        return custom;
    }
    /**
     * 최종 구분자 처리한 문자열에서 숫자를 추출해 더하여 걀과를 출력하는 함수
     *
     * @param resultStr 변환할 문자열
     */
    public void calculationResult(String resultStr){
        String[] splitNum = resultStr.split("@");

        int result = 0;
        for (String s : splitNum) {
            if(s.isEmpty()) continue;
            result += Integer.parseInt(s);
        }

        System.out.println("결과 : " + result);
    }

    /**
     * 주어진 문자열에서 숫자 또는 '@'가 아닌 문자가 있을 경우
     * IllegalArgumentException을 발생시키는 함수.
     *
     * @param resultStr 검사할 문자열
     * @throws IllegalArgumentException 숫자나 '@'가 아닌 문자가 포함된 경우
     */
    public void validationCheck(String resultStr){
        for (int i = 0; i < resultStr.length(); i++) {
            char currentChar = resultStr.charAt(i);
            if (!Character.isDigit(currentChar) && currentChar != '@') {
                throw new IllegalArgumentException("잘못된 문자 '" + currentChar + "'가 포함되어 있습니다.");
            }
        }
    }
}
