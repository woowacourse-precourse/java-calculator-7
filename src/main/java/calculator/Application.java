package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        SumCalculator calculator = new SumCalculator();

        // 사용자의 입력은 Console API의 readLine()을 활용한다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int check = calculator.check(input);

        // 합산 결과를 출력한다.
        if(check == 0){
            System.out.printf("결과: %d", 0);
        }
        else{
            // To-do
        }

        // 1. 기본 구분자는 쉼표와 콜론으로, 받은 문자열은 이것을 기준으로 숫자의 합을 수행한다.
        /*String[] number = input.split("[,|:]");
        for(int i = 0; i<number.length; i++){
            answer += Integer.parseInt(number[i]);
        }*/
    }
}
