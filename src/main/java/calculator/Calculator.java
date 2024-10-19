package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    // 전체 입력 문자열
    private String inputString;
    // 구분자 배열
    private List<String> separator = new ArrayList<>();
    // 피연산자 배열
    private int[] operand;

    /**
     * 사용자 입력
     */
    private void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        this.inputString = readLine();
    }

    /**
     * 커스텀 구분자 찾기
     */
    private boolean findCustomSeparator() {
        return true;
    }

    /**
     * 커스텀 구분자의 짝이 맞는지 확인
     */
    private boolean isSeparatorValid() {
        return true;
    }

    /**
     * 커스텀 구분자 파싱하여 separator 배열에 저장
     */
    private void parseCustomSeparator() {

    }

    /**
     * 피연산자 파싱하여 operand 배열에 저장
     */
    private void parseOperand() {

    }

    private void printResult() {
        System.out.print("결과 : ");
        System.out.println("결과 : " + Arrays.stream(operand).sum());
    }

    public void run() {
        getUserInput();
        // todo: 구분자 파싱 및 저장 -> 예외처리
        if (findCustomSeparator()) {
            // todo: 커스텀 구분자가 짝이 맞는지 확인
            if (!isSeparatorValid()) {
                throw new IllegalArgumentException("커스텀 구분자의 짝이 맞지 않습니다.");
            }
            // todo: 커스텀 구분자 배열에 넣기
            parseCustomSeparator();
        }

        // todo: 피연산자 문자열 파싱 및 저장 -> 예외처리
        parseOperand();

        // todo: 결과 출력
        printResult();
    }
}
