package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int operandA = inPut();
        int operandB = inPut();

        int result = add(operandA, operandB);
        System.out.println("결과 : " + result);
    }

    // 문자열에서 숫자 추출 기능 구현 시 리턴 타입과 구현 내용을 int -> String 으로 수정할 것
    public static int inPut() {
        System.out.println("덧셈할 정수를 입력해 주세요.");
        Scanner operand = new Scanner(System.in);
        return operand.nextInt();
    }

    public static int add(int operandA, int operandB) {
        return operandA + operandB;
    }
}
