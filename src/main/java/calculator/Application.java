package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //문자열 받기
        StringFilter strF = new StringFilter(Console.readLine());       //문자 필터링

        Calculator cal = new Calculator();

        String[] numbers = strF.getFilteredString();
        System.out.println("결과 : " + cal.sumResult(numbers));






    }
}
