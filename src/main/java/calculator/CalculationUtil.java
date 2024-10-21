package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculationUtil {

    public CalculationUtil(String input) {
        this.input = input;
    }

    private final char colon = ':';
    private final char rest = ',';

    private String input;
    private char customDivider;
    private boolean isCustom = false;
    private List<Integer> numbers = new ArrayList<>();

    /**
     * 커스텀 구분자를 포맷을 체크하고 있다면 구분자를 추출
     *
     * @throws IllegalAccessException : 커스텀 구분자 선언부가 포맷이 부적절할 때
     */
    private void checkCustomDivider() {
        if (input.startsWith("/") && input.length() >= 5) {
            String customDividerString = input.substring(0, 5);
            if (customDividerString.startsWith("//") && customDividerString.endsWith("\\n")) {
                this.isCustom = true;
                this.customDivider = input.charAt(2);
                this.input = this.input.substring(5);
            } else {
                throw new IllegalArgumentException("Custom Divider format is wrong");
            }
        }
    }

    /**
     * 적절한 식인지 확인 & 숫자만 추출
     *
     * @throws IllegalAccessException : 구분자의 위치가 적절하지 않을때
     */
    private void checkDivider() {
        char start = this.input.charAt(0);
        char end = this.input.charAt(this.input.length() - 1);

        if (checkDivider(start) || checkDivider(end)) {
            throw new IllegalArgumentException("Divider location is wrong");
        }

        char[] inputCharArray = this.input.toCharArray();

        boolean numTurn = true;
        String numString = "";

        for (int i = 0; i < inputCharArray.length; i++) {
            if (numTurn && Character.isDigit(inputCharArray[i])) {
                numString = numString + inputCharArray[i];

                if (i == inputCharArray.length - 1) {
                    numbers.add(Integer.valueOf(numString));
                } else if (!Character.isDigit(inputCharArray[i + 1])) {
                    numbers.add(Integer.valueOf(numString));
                    numTurn = false;
                    numString = "";
                }

            } else if (!numTurn && checkDivider(inputCharArray[i])) {
                numTurn = true;
            } else {
                throw new IllegalArgumentException("Expression is wrong");
            }
        }
    }

    /**
     * 구분자가 유효한 구분자인지 체크
     *
     * @param divider : 체크할 구분자 문자
     * @return : 구분자면 true, 아니면 false
     */
    private boolean checkDivider(char divider) {
        if (isCustom == true) {
            return divider == colon || divider == rest || divider == customDivider;
        } else {
            return divider == colon || divider == rest;
        }
    }
}