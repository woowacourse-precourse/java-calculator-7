package calculator;

import java.util.Scanner;

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
}
