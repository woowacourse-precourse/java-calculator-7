package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    static final String DEFAULT_DELIMITERS = "[,:]"; //정규식 표현
    static final String CUSTOM_DELIMITER_PREFIX = "//"; //커스텀 구분자를 구별해주는 앞부분
    static final String CUSTOM_DELIMITER_POSTFIX = "\\n"; //커스텀 구분자를 구별해주는 뒷부분
    static String customDelimiter;

    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static String[] extractNumber(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            if (delimiterIndex == -1) { // 만약 //는 들어왔는데 뒤에 나오는 문자열이 \n이 아니라 다른 문자열이 온다면 indexof는 -1을 반환함
                // ex) //;?n1;2;3 - o
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            String customTempDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), delimiterIndex);
            String number = input.substring(CUSTOM_DELIMITER_PREFIX.length() + customTempDelimiter.length()
                    + CUSTOM_DELIMITER_POSTFIX.length());
            customDelimiter = "[" + customTempDelimiter + ",:]"; // 새로운 정규식 생성
            // 커스텀 구분자로만 이루어진 입력 체크
            if (number.matches(customTempDelimiter + "+")) {
                throw new IllegalArgumentException("커스텀 구분자로만 이루어진 입력은 허용되지 않습니다.");
            }
            // ex) //;\n;;; - o

            // 구분자로 끝나거나 시작하는 경우 체크
            if (number.matches(".*" + customTempDelimiter + "$|^" + customTempDelimiter + ".*")) {
                throw new IllegalArgumentException("입력되지 않은 수가 있습니다.");
            }
            // ex) //;\n10;;; || //;\n;;;10
            return number.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    public static int sum(String[] str) {
        int result = 0;
        for (String s : str) {
            result += Integer.parseInt(s);
        }
        return result;
    }

    public static int preExceptionHandler(String input) {
        /*
        문자열을 입력 받았을 때 먼저 확인하면 좋을 예외처리!
        1. 커스텀 구분자와 일반 구분자가 같이 온다면? -> 숫자를 추출할 때 커스텀 구분자와 기본 구분자를 모두 포함한 정규식을 생성! - o
        2. 커스텀 구분자를 지정해주는 얘들이 아닌 다른 녀석들이 들어왔을 때 -> 바로 IllegalArgumentException
        3. 빈 문자열이 들어왔을 때에는 0을 반환 - o
        4. 구분자만 들어오면? -> IllegalArgumentException, 잘못된 입력이다
         */
        if (input.isEmpty()) { // 빈 문자열이 들어왔을 시에 0 return
            return 0;
        }

        if (input.matches("[,:]+")) {
            throw new IllegalArgumentException("구분자로만 이루어진 입력은 허용되지 않습니다.");
        }
        // ex) ::: || ,,, - o
        if (input.matches(".*[,:]$|^[,:].*")) {  // 구분자로 끝나거나 시작하는 경우 체크
            throw new IllegalArgumentException("입력되지 않은 수가 있습니다.");
        }
        // ex) :10: || ::10 - o
        return 1;
    }

    public static int postExceptionHandler(String[] input) {
    /*
    post에서 확인할 예외처리들!
    1. 음수가 들어왔을 때 - o
    2. 최대한 예외를 많이 생각했고 그에 상응하게 코드를 구현하였지만 생각하지 못한 예외가 있을 수 있으므로 전체적으로도 잡는게 좋아보임 - o
    3. 커스텀 구분자만 설정해두면 0을 반환해야할까? 혹은 IllegalArgumentException을 반환시켜야할까 -> 0을 반환하는 것이 맞는 것이라 생각한다.
    ex ) //;\n
     */
        for (String str : input) {
            try {
                int number = Integer.parseInt(str);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다 : " + number);
                    // ex) 1:-1:10 || //;\n1;-10;10 - o
                }
            } catch (NumberFormatException e) { // 구분자에 의해 분리시킨 값이 숫자가 아닐경우
                // ex) 1:?:10 || //;\n1;?;10
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다 : " + str);
            }
        }
        return 1;
    }

    public static int run() {
        String input = inputString();
        if (preExceptionHandler(input) == 0) {
            return 0;
        }
        String[] str = extractNumber(input);
        int postExceptionNumber = postExceptionHandler(str);
        if (postExceptionNumber == -1) {
            return -1;
        }
        return sum(str);
    }
}
