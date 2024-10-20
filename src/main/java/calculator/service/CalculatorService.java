package calculator.service;

import calculator.validator.CalculatorValidator;

public class CalculatorService {
    private final CalculatorValidator calculatorValidator;
    private String inputString;
    private String customSeparator;

    public CalculatorService() {
        this.calculatorValidator = new CalculatorValidator();
    }

    /**
     * 덧셈 로직을 순차적으로 진행한다.
     */
    public int add(String inputString) {
        this.inputString = inputString;
        boolean hasCustomSeparator = checkCustomSeparator();
        String[] separatedString = separate(hasCustomSeparator);
        calculatorValidator.hasNaN(separatedString);
        return sumSeparatedStringArr(separatedString);
    }

    /**
     * 커스텀 구분자가 있는지 확인한다.
     *
     * @return 만약 커스텀 구분자가 있다면 true, 없다면 false 를 반환한다.
     */
    private boolean checkCustomSeparator() {
        if (inputString.length() >= 5 && inputString.startsWith("//") && inputString.startsWith("\\n", 3)) {
            customSeparator = String.valueOf(inputString.charAt(2));
            inputString = inputString.substring(5);
            return true;
        }
        return false;
    }

    /**
     * 받은 문자열을 구분자를 기준으로 나눈다. 만약 커스텀 구분자에 역슬래시가 있다면 문제가 생기지 않도록 한다.
     *
     * @param hasCustomSeparator 커스텀 구분자가 있다면 true, 없다면 false 를 입력한다.
     * @return 분리된 문자열을 반환한다. 이 문자열에는 반드시 숫자만 있는 것은 아니다.
     */
    private String[] separate(boolean hasCustomSeparator) {
        if (!hasCustomSeparator) {
            return inputString.split("[:,]");
        }
        if (customSeparator.equals("\\")) {
            return inputString.split("[:," + customSeparator.repeat(2) + "]");
        }
        return inputString.split("[:," + customSeparator + "]");
    }

    /**
     * 문자열을 int 형으로 바꾼 뒤 합한다.
     *
     * @param separatedStringArr 숫자로만 이루어진 문자열 배열을 입력한다.
     * @return 합한다.
     */
    private int sumSeparatedStringArr(String[] separatedStringArr) {
        int sum = 0;
        for (String separatedString : separatedStringArr) {
            if (!separatedString.isEmpty()) {
                sum += Integer.parseInt(separatedString);
            }
        }
        return sum;
    }
}
