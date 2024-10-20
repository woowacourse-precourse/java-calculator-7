package calculator;

public class Calculator {

    private static final char DEFAULT_DELIMITER1 = ',';
    private static final char DEFAULT_DELIMITER2 = ':';
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private static int result = 0;

    private final CalculatorConsole calculatorConsole = new CalculatorConsole();

    public void run() {
        String s = calculatorConsole.inputString();
        System.out.println("결과 : " + stringSplit(s));
    }

    private int stringSplit(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        // 커스텀 구분자 있을 경우
        if (s.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            if (s.startsWith(CUSTOM_DELIMITER_SUFFIX, 3)) {
                char custom = s.charAt(2);

                // 커스텀 구분자 부분 삭제
                String sliceS = s.substring(5);

                String[] customArr = sliceS.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2 + "|" + custom);

                numberExtract(customArr);
                return result;
            } else {
                throw new IllegalArgumentException();
            }
        }
        // 커스텀 구분자 없을 경우
        String[] defaultArr = s.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2);

        numberExtract(defaultArr);
        return result;
    }

    // 양수 추출 및 더하기, 양수 이외의 값일 경우 예외처리
    private void numberExtract(String[] arr) {
        for (String str : arr) {
            try {
                int positiveNum = Integer.parseInt(str);
                // 0 또는 음수일 경우 예외처리
                if (positiveNum <= 0) {
                    throw new IllegalArgumentException();
                }
                result += positiveNum;
                // 숫자가 아닌 경우 예외처리
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}
