package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    private String inputString;
    private String removedString = "";
    private List<String> separator = new ArrayList<>();
    private List<Integer> operand = new ArrayList<>();

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

    /**
     * 기본 구분자 배열에 추가
     */
    private void addBasicSeparator() {
        separator.add(",");
        separator.add(":");
    }

    /**
     * 현재 문자열이 구분자에 해당하는지 확인하고 자릿수 반환
     */
    private int isSeparator(String tmpString) {
        for (int i = 0; i < separator.size(); i++) {
            // 이 부분 예외처리 잘해야 함
            if (tmpString.length() < separator.get(i).length())
                continue;
            if (separator.get(i).equals(tmpString.substring(0, separator.get(i).length()))) {
                return separator.get(i).length();
            }
        }
        return -1;
    }

    /**
     * 피연산자 파싱하여 operand 배열에 저장
     */
    private void parseOperand() {
        String tmpString = removedString;
        String tmpOperand = "";

        for (int i = 0; i < removedString.length(); i++) {
            int separatorLength = isSeparator(removedString.substring(i));

            if (separatorLength != -1) {
                if (!tmpOperand.equals("")) {
                    operand.add(Integer.parseInt(tmpOperand));
                    tmpOperand = "";
                }
                i += separatorLength - 1;
            } else if (Character.isDigit(removedString.charAt(i))) {
                tmpOperand += removedString.charAt(i);
            } else {
                throw new IllegalArgumentException("등록되지 않은 구분자가 포함되어 있습니다.");
            }
        }
        if (!tmpOperand.equals("")) {
            operand.add(Integer.parseInt(tmpOperand));
        }
    }

    /**
     * 결과 출력
     */
    private void printResult() {
        if (operand != null) {
            int sum = 0;
            for (int i = 0; i < operand.size(); i++) {
                sum += operand.get(i);
            }
            System.out.println("결과 : " + sum);
        } else {
            System.out.println("결과 : 0");
        }
    }

    public void run() {
        getUserInput();
        parseCustomSeparator();
        addBasicSeparator();
        parseOperand();
        printResult();
    }
}

