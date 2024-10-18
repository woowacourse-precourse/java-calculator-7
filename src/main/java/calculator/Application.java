package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class Application {
    static String DELIMITER = ",|:";

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = readLine();

        String newInputString = splitCustomDelimiter(inputString);
        String[] splitDelimiterString = splitDelimiter(newInputString);
        calculateNumbers(splitDelimiterString);
    }

    /**
     * @param inputString: 입력값
     * @return 커스텀 구분자 분리 이후 새로운 inputString 값 만약 입력값이 "//"로 시작되고 그 뒤에 "\n"가 존재한다면 커스텀 구분자가 존재한다 (커스텀 구분자 내 공백 제외).
     * @Exception 1. '//'로 시작하지만 이후 '\n'가 존재하지 않을때 2. 커스텀 구분자가 정확히 하나의 유니코드 문자가 아닐때 3. 커스텀 구분자가 비어있을 때
     */
    public static String splitCustomDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            int newLineIndex = inputString.indexOf("\\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 " + "\\n" + "이 없습니다.");
            }

            String customDelimiter = inputString.substring(2, newLineIndex);

            if (customDelimiter.codePoints().count() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 정확히 하나의 유니코드 문자여야 합니다.");
            }

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
            }

            DELIMITER += "|" + customDelimiter;
            inputString = inputString.substring(newLineIndex + 2);
        }

        return inputString;
    }

    /**
     * @param newInputString: 커스텀 구분자 분리 후 새로운 문자열 새로운 문자열 내 계산해야할 숫자만 분리
     */
    private static String[] splitDelimiter(String newInputString) {
        return newInputString.split(DELIMITER);
    }

    /**
     * @param numbers : 계산해야할 각각의 숫자
     * @return 계산 결과
     * @Explain 각각의 숫자에 대해 유효성 검사후 하나씩 더해준다.
     */
    private static int calculateNumbers(String[] numbers) {
        return Arrays.stream(numbers).filter(s -> !s.isEmpty()).mapToInt(Application::parseNumber).sum();
    }


    /**
     * @param number
     * @return 유효성 검사를 마친 숫자
     */
    private static int parseNumber(String number) {
        try {
            int parsingNumber = Integer.parseInt(number.trim());
            if (parsingNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsingNumber);
            }
            return parsingNumber;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("잘못된 숫자 형식: " + exception);
        }
    }
}
