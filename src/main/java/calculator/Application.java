package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    // 구분자로 나누어 배열로 저장
    private String[] splitNumbers(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }

        String delimiter = ",|:";
        String numbers = input;



        return numbers.split(delimiter);
    }

    // 나누어진 배열의 합 구하기
    private int sumNumbers(String[] numbers){
        int sum = 0;
        for (String number: numbers){
            int num = Integer.parseInt(number);
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        // 사용자 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        Application application = new Application();

        // 1. 사용자 입력 구분자 기준 배열로 나누기
        String[] splitNumbers = application.splitNumbers(input);

        // 2. 나누어진 배열 값 더하기
        int result = application.sumNumbers(splitNumbers);


        System.out.println("결과 : " + result);
    }
}
