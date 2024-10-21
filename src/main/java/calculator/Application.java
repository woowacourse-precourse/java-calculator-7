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
    public void processInput(String inputNum, Calculator calculator) {
        // 1. 입력값이 null이거나 빈 문자열인 경우
        if (inputNum == null || inputNum.isEmpty()) {
            empty();
            return;
        }
        // 2. 쉼표(,)와 콜론(:)으로 구분된 숫자인지 확인
        if (inputNum.matches("[0-9,:]+")) {
            commaColon(inputNum, calculator);
            return;
        }

        // 3. 커스텀 구분자 처리 (예: "//[구분자]\\n[숫자목록]" 형식)
        if (inputNum.startsWith("//")) {
            custom(inputNum, calculator);
            return;
        }

        throw new IllegalArgumentException();
    }
    public void empty() {
    }

    public void commaColon(String input, Calculator calculator) {
    }

    public void custom(String input, Calculator calculator){
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
