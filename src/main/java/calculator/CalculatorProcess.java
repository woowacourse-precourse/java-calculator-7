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
        validateInput(inputString);
    }

    static private void validateInput(String inputString){

    }

}
