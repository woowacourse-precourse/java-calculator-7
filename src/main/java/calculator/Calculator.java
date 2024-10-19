package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private String inputString;
    private String removedString = "";
    private List<String> separator = new ArrayList<>();
    private int[] operand;

    /**
     * 사용자 입력
     */
    private void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        this.inputString = Console.readLine();
        Console.close();
    }

    /**
     * 커스텀 구분자 유뮤
     * 커스텀 구분자 짝 맞는지 확인 후 파싱
     */
    private boolean parseCustomSeparator() {
        Stack<String> buffer = new Stack<>();
        boolean flag = false;
        int idx = 0;

        for (int i = 0; i <= inputString.length() - 1; i++) {
            if (flag == false && (inputString.charAt(i) == '/' && inputString.charAt(i + 1) == '/')) {
                buffer.push(inputString.substring(i, i + 2));
                separator.add("");
                flag = true;
                i += 1;
            } else if (inputString.charAt(i) == '\\' && inputString.charAt(i + 1) == 'n') {
                if (buffer.isEmpty() || !flag)
                    throw new IllegalArgumentException("커스텀 구분자의 짝이 맞지 않습니다.");
                buffer.pop();
                idx++;
                flag = false;
                i += 1;
            } else {
                if (flag == true) {
                    separator.set(idx, separator.get(idx) + inputString.charAt(i));
                } else {
                    removedString += inputString.charAt(i);
                }
            }
        }

        if (!buffer.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자의 짝이 맞지 않습니다.");
        }
        if (separator.isEmpty()) {
            return false;
        } else
            return true;
    }

    private void addBasicSeparator() {
        separator.add(",");
        separator.add(":");
    }

    private boolean isSeparator(String tmpSeparator) {
        for (int i = 0; i < separator.size(); i++) {
            if (separator.get(i).equals(tmpSeparator)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 피연산자 파싱하여 operand 배열에 저장
     */
    private void parseOperand() {

    }

    /**
     * 결과 출력
     */
    private void printResult() {
        if (operand != null) {
            System.out.println("결과 : " + Arrays.stream(operand).sum());
        } else {
            System.out.println("결과 : 0");
        }
    }

    public void run() {
        getUserInput();
        parseCustomSeparator();
        addBasicSeparator();
        // todo: 피연산자 문자열 파싱 및 저장 -> 예외처리
        parseOperand();
        // todo: 결과 출력
        printResult();
    }
}

