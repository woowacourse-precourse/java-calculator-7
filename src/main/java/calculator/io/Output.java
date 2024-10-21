package calculator.io;

public class Output {

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void printInputGuide() {
        printString("덧셈할 문자열을 입력해 주세요.");
    }

    public static void printCalculationResult(int sum) {
        printString("결과 : " + sum);
    }
}
