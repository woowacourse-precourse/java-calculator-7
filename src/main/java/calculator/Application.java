package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 콘솔로 입력을 받음
        String input = Console.readLine().trim();
        // 쉼표 또는 콜론을 구분자로 가져서 각 숫자 추출 및 합산, 커스텀 구분자도 존재함
        Calculator calculater = new Calculator();
        int calculator = calculater.calculator(input);
        System.out.println("calculator = " + calculator);
    }
}
