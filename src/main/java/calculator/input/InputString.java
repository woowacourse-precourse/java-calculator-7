package calculator.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputString {

    private static String inputString = "";

    public String input(){ //문자열 입력받기
        inputString = readLine();

        if(inputString.isEmpty()) throw new IllegalArgumentException("양수와 구분자가 포함된 문자열을 입력해주세요.");

        inputString = inputString.replace(" ", ""); //문자열 공백 제거

        return inputString;
    }
}
