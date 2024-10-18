package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private ArrayList<String> separator = new ArrayList<>(Arrays.asList(",", ":"));
    private String input;
    private int sum = 0;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return this.input;
    }

    public ArrayList<String> getSeparator() {
        return this.separator;
    }

    public int getSum() {
        return this.sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    private String addSeparator(String str) throws IllegalArgumentException {

        while (!str.isEmpty() && str.charAt(0) == '/') {
            if (str.length() >= 5 && str.charAt(1) == '/') { // 문자 길이로 애초에 양식 안맞고 길이 안맞는거 걸러서 indexing 오류 제거
                if (str.substring(2, 3).matches("[^a-zA-Z0-9\\\\\\\\s]")) { //특수 문자인지 확인
                    String sep = str.substring(2, 3);
                    str = str.substring(3);
                    if (str.startsWith("\\n")) {
                        str = str.substring(2);
                        this.separator.add(sep);
                    } else {
                        throw new IllegalArgumentException("잘못된 입력입니다. \\n이 없습니다.");
                    }
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 구분자가 없습니다.");
                }
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다. // 양식 혹은 길이가 맞지 않습니다.");
            }
        }
        return str;
    }

    public void manageAdd(String input) throws IllegalArgumentException {
        this.setInput(input);
        StringBuilder stack = new StringBuilder();
        boolean isSeparator = true;
        if (this.input.isEmpty()) {
            return;
        }
        String remained = this.addSeparator(this.input);

        for (int i = 0; i < remained.length(); i++) {
            char current = remained.charAt(i);
            // separater인 경우
            if (this.separator.contains(String.valueOf(current))) {
                if (isSeparator) { //구분자가 2번 연속 나옴
                    throw new IllegalArgumentException("잘못된 구분자가 연속으로 나왔습니다.");
                }

                this.sum += parseAndAdd(stack.toString()); // 스택에 있는 숫자를 합산하고 초기화
                System.out.println("separator에서 sum 더한 이후" + this.sum);
                stack.setLength(0);
                isSeparator = true; // 다음 문자가 구분자임을 표시
            } else { // 숫자 쌓기
                if (!Character.isDigit(current)) {
                    throw new IllegalArgumentException("유효하지 않은 문자가 입력되었습니다.");
                }
                stack.append(current);
                System.out.println("stack에 숫자 쌓은 이후" + stack);
                isSeparator = false; // 이전 문자가 구분자가 아님
            }
        }

        if (!stack.isEmpty()) {
            sum += parseAndAdd(stack.toString());
        }

        if (isSeparator) {
            throw new IllegalArgumentException("구분자 뒤에 숫자가 나오지 않았습니다");
        }

    }

    private int parseAndAdd(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) { //Int보다 큰 범위 탐지
            throw new IllegalArgumentException("숫자 형식이 잘못되었습니다.");
        }
    }

}
