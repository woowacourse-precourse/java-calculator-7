package calculator;

import camp.nextstep.edu.missionutils.Console;

class Printer{}

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

class Extraction {
    // 입력을 처리하는 메서드
    public void processInput(String inputNum) {
        // 1. 입력값이 null이거나 빈 문자열인 경우
        if (inputNum == null || inputNum.isEmpty()) {
            empty();
            return;
        }
        throw new IllegalArgumentException();
    }

    public void empty() {

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
}
