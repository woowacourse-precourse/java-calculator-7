package calculator;

import camp.nextstep.edu.missionutils.Console;

import static utility.Constant.INPUT_MESSAGE;

public class CalculatorProcess {

    static public void run(){
        input();
    }

    // 문자열 입력받기
    static private void input(){
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();
        checkInput(inputString);
    }

    // 입력 받은 문자열 종류 구분하기
    static private void checkInput(String inputString){
        int idx = inputString.indexOf("\\n");

        if('0'<=inputString.charAt(0) && inputString.charAt(0) <='9'){
            // 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열
            validateInput(inputString);
        }
        else if("//".equals(inputString.substring(0,2)) && idx!=-1){
            // 커스텀 구분자를 가지는 문자열
            modifyDelimiter(inputString);
        }
        else{
            // 유효하지 않은 문자열
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자를 콜론(:)으로 바꾸기
    static private void modifyDelimiter(String inputString){
        int idx = inputString.indexOf("\\n");
        String delimiter = inputString.substring(2, idx);
        inputString = inputString.substring(idx+2, inputString.length());
        inputString = inputString.replace(delimiter, ":");
        validateInput(inputString);
    }

    static private void validateInput(String inputString){

    }
}
