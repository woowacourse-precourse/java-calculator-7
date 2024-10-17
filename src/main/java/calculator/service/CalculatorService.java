package calculator.service;

public class CalculatorService {
    public int calculator(String input) {
        inValidInput(input);
        if (defaultOrCustomDelimeter(input)) {
            return customAdd(input);
        } else {
            return defaultAdd(input);
        }
    }

    public int defaultAdd(String input) {
        String[] str = input.split("[,:]");

        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    public int customAdd(String input) {
        String prefix = input.substring(0, 2);
        String suffix = input.substring(3, 5);
        int sum = 0;

        if (prefix.equals("//") && suffix.equals("\\n")) {
            String customDelimeter = String.valueOf(input.charAt(2));
            String newInput = input.substring(5);
            String[] customSplit = newInput.split(customDelimeter);

            for (String s : customSplit) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    public boolean defaultOrCustomDelimeter(String input) {
        if (input.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    // 3) 예외 처리
    public void inValidInput(String input) {
        if (isInputEmpty(input)) {
            throw new IllegalArgumentException("입력된 값이 없습니다");
        }

        if (isNotExistDigit(input)) {
            throw new IllegalArgumentException("입력된 문자열에 숫자가 존재하지 않습니다");
        }

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
        if (input.contains("\n")) {
            return true;
        }
        return false;
    }

}
