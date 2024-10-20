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
            // 유효하지 않은 문자열 (문자열이 숫자로 시작하지 않고, "//"로 시작하지 않는 경우)
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

    // 구분자를 제외한 문자열이 숫자가 아닌 입력을 포함하고 있는지 확인하기
    static private void validateInput(String inputString){
        inputString = inputString.replace(",",":");

        for(int i=0;i<inputString.length();i++){
            if(inputString.charAt(i)==':' || ('0' <= inputString.charAt(i) && inputString.charAt(i) <= '9')){
                continue;
            }
            else{
                // 유효하지 않은 문자열 (구분자를 제외한 문자열이 숫자가 아닌 입력을 포함하고 있는 경우)
                throw new IllegalArgumentException();
            }
        }
        divideByDelimiter(inputString);
    }

    // 구분자(콜론)를 기준으로 숫자 나누기
    static private void divideByDelimiter(String inputString){
        String[] divideString = inputString.split(":");
        int[] divideInteger = new int[divideString.length];
        for(int i=0;i<divideString.length;i++){
            divideInteger[i] = Integer.parseInt(divideString[i]);
            if(divideInteger[i]==0){
                // 유효하지 않은 문자열 (구분자를 제외한 문자열이 숫자 0을 포함하고 있을 경우)
                throw new IllegalArgumentException();
            }
        }
        sum(divideInteger);
    }

    // 나눈 숫자를 모두 더하기
    static private void sum(int[] divideInteger){
        int total = 0;
        for(int score : divideInteger){
            total+=score;
        }
        printAnswer(total);
    }

    static private void printAnswer(int answer){
    }
}
