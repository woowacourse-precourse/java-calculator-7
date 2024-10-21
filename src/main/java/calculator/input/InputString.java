package calculator.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputString {

    private static String inputString = "";

    public String input(){ //문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputString = readLine();

        isValidInput();

        if(inputString.isEmpty()) throw new IllegalArgumentException("양수와 구분자가 포함된 문자열을 입력해주세요.");

        inputString = inputString.replace(" ", ""); //문자열 공백 제거

        return inputString;
    }

    public void isValidInput(){

        if(!inputString.matches(".*\\d.*")) throw new IllegalArgumentException("잘못된 입력 형식 입니다.");

        if((inputString.length() - inputString.replace(String.valueOf("//"), "").length()) != inputString.length() - inputString.replace(String.valueOf("\\n"), "").length())
            throw new IllegalArgumentException("잘못된 입력 형식 입니다.");

        if(!inputString.startsWith("//")){
            if(inputString.contains("\\n")) throw new IllegalArgumentException("잘못된 입력 형식 입니다.");
            else if(inputString.matches("^[^a-zA-Z0-9].*")) throw new IllegalArgumentException("잘못된 입력 형식 입니다.");
        }
        if(!inputString.matches(".*\\d$")) throw new IllegalArgumentException("잘못된 입력 형식 입니다.");
    }
}
