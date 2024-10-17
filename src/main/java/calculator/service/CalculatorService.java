package calculator.service;

public class CalculatorService {
    public int calculator(String input) {
        inValidDefaultInput(input);
        if (defaultOrCustomDelimeter(input)) {
            inValidCustomDelimiter(input);
            return customAdd(input);
        } else {
            return defaultAdd(input);
        }
    }

    private int defaultAdd(String input) {
        String[] str = input.split("[,:]");

        int sum = 0;
        for (String s : str) {
            isDigitNegative(s);
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    private int customAdd(String input) {
        String prefix = input.substring(0, 2);
        String suffix = input.substring(3, 5);
        int sum = 0;

        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimeter = String.valueOf(input.charAt(2));
            String newInput = input.substring(5);
            String[] customSplit = newInput.split(customDelimeter);

            for (String s : customSplit) {
                isDigitNegative(s);
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    private boolean defaultOrCustomDelimeter(String input) {
        if (input.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    /** [공통] Input 값에 대한 공통 예외 처리 */
    private void inValidDefaultInput(String input) {
        if (isInputEmpty(input)) {
            throw new IllegalArgumentException("입력된 값이 없습니다");
        }

        if (isNotExistDigit(input)) {
            throw new IllegalArgumentException("입력된 문자열에 숫자가 존재하지 않습니다");
        }
    }

    /** [공통] 구분자로 분리 후 Digit 이 음수가 있을 경우  */
    private void isDigitNegative(String s) {
        int digit = Integer.parseInt(s);
        if (digit < 0) {
            throw new IllegalArgumentException("양수가 아닌 음수가 존재 합니다. 프로그램을 종료합니다");
        }
    }

    // 커스텀 구분자 예외 처리
    private void inValidCustomDelimiter(String input) {
        if (isInvalidCustomDelimiter(input)) {
            throw new IllegalArgumentException("잘못된 커스텀 지정자가 존재 합니다.");
        }
    }

    private boolean isInputEmpty(String input) {
        return input.isEmpty();
    }

    private boolean isNotExistDigit(String input) {
        return !input.matches(".*\\d.*");
    }

    private boolean isInvalidCustomDelimiter(String input) {
        if (!input.startsWith("//")) {
            return true;
        }
        if (!input.contains("\\n")) {
            return true;
        }
        return false;
    }

}
