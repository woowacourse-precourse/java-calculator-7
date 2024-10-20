package calculator;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Character.isDigit;

public class Application {

    private static String delimiters = "[,:]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); // 사용자 입력을 받는 메소드

        int RESULT = calculate(input);
        System.out.println("결과 : " + RESULT);

    }

    public static int calculate (String input){
        if(input.equals("")){ // 빈 값 처리해주기
            return 0;
        }
        if (input.startsWith("//")) {
            return handleCustomDelimiter(input);
        }
        return sum(input);
    }

    private static int handleCustomDelimiter (String input){
        String[] parts;
        if(input.charAt(3) == '\\' && input.charAt(4) == 'n'){
            delimiters = delimiters.substring(0, 3) +  input.substring(2, 3) + "]";
            parts = input.split("n");
        }
        else{ // \n가 없거나 커스텀 구분자가 여러개라면 예외처리
            throw new IllegalArgumentException("커스텀 구분자 정의형식이 잘못되었습니다.");
        }
        String numbers = parts[1];
        return sum(numbers);
    }

    private static int sum (String numbers) {
        int SUM = 0;
        verifyWrongInput(numbers);
        String[] splitedNumbers = numbers.split(delimiters);
        for (String number : splitedNumbers) {
                int NUM = Integer.parseInt(number);
            if (NUM < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + NUM);
            }
            SUM += NUM;
        }
        return SUM;
    }

    private static void verifyWrongInput (String numbers) {
        // 1. 다른 구분자가 포함되어 있는지 확인하기
        if(!numbers.matches("^[0-9" + delimiters + "]*$")) {
            throw new IllegalArgumentException("양수와 구분자외에 다른문자가 포함되어 있습니다.");
        }

        // 2. 구분자가 여러개 나오거나 잘못된 위치에 있는지 확인하기
        String[] splitedNumbers = numbers.split(delimiters);
        for (String number : splitedNumbers) {
            if(number.isEmpty()) {
                throw new IllegalArgumentException("구분자가 겹쳐있거나 문자열 맨앞에 위치해 있습니다.");
            }
        }
        if(!isDigit(numbers.charAt(numbers.length() - 1))){
            throw new IllegalArgumentException("구분자가 문자열 맨뒤에 위치해 있습니다.");
        }
    }
}
