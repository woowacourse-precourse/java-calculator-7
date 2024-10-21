package calculator;

import camp.nextstep.edu.missionutils.Console;

class Printer{}
class Extraction{}
class Calculator {
    // 덧셈을 수행하는 메서드
    public int add(int[] numbers) {
        int sum = 0;  // 초기화
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}



public class Application {
    public static void main(String[] args) {
        // Printer 객체 생성
        Printer printer = new Printer();

        // 객체 생성
        Extraction extraction = new Extraction();
        Calculator calculator = new Calculator();

        String inputStr = Console.readLine();

    }

}
