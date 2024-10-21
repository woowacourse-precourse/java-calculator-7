package calculator;
import camp.nextstep.edu.missionutils.Console;

// 출력 작업을 담당하는 클래스
class Printer {
    // 결과 출력
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    // 에러 메시지 출력
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    // 입력 안내 메시지 출력
    public void printInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}

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
    private Printer printer;

    // Printer 객체를 생성자에서 주입받아 사용
    public Extraction(Printer printer) {
        this.printer = printer;
    }

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

    // 입력값이 빈 문자열일 때 처리하는 메서드
    public void empty() {
        printer.printResult(0);
    }

    // 쉼표(,)와 콜론(:)으로 구분된 숫자들을 처리하는 메서드
    public void commaColon(String input, Calculator calculator) {
        String[] tokens = input.split("[,:]");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i].trim());
        }

        // 추출된 숫자들을 Calculator의 add 메서드로 넘겨 덧셈 처리
        int result = calculator.add(numbers);
        printer.printResult(result);
    }

    // 커스텀 구분자 처리하는 메서드
    public void custom(String input, Calculator calculator) {
        String[] parts = input.split("\\\\n", 2);  // 첫 번째 줄은 구분자, 두 번째 줄은 숫자들
        if (parts.length != 2) {
            throw new IllegalArgumentException();
        }

        String customDelimiter = parts[0].substring(2);  // 구분자 추출
        String[] tokens = parts[1].split(customDelimiter);  // 구분자로 숫자 분리
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i].trim());
        }

        // 추출된 숫자들을 Calculator의 add 메서드로 넘겨 덧셈 처리
        int result = calculator.add(numbers);
        printer.printResult(result);
    }
}

public class Application {
    public static void main(String[] args) {
        // Printer 객체 생성
        Printer printer = new Printer();

        // 객체 생성
        Extraction extraction = new Extraction(printer);
        Calculator calculator = new Calculator();

        // 입력 받기
        printer.printInputMessage();
        String inputStr = Console.readLine();

        // 입력값 처리
        extraction.processInput(inputStr, calculator);


    }
}
