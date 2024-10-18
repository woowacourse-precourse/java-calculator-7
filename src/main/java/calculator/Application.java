package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class Application {
    static String DELIMITER = ",|:";

    public static void main(String[] args) {
        String inputString = readLine();

        String newInputString = splitCustomDelimiter(inputString);
        splitDelimiter(newInputString, DELIMITER);
    }

    /**
     * @param inputString: 입력값
     * @return 커스텀 구분자 분리 이후 새로운 inputString 값 만약 입력값이 "//"로 시작되고 그 뒤에 "\n"가 존재한다면 커스텀 구분자가 존재한다 (커스텀 구분자 내 공백 제외).
     */
    static public String splitCustomDelimiter(String inputString) {
        if (inputString.startsWith("//")) {
            int newLineIndex = inputString.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 '\\\\n'이 없습니다.");
            }

            String customDelimiter = inputString.substring(2, newLineIndex);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.")
            }

            DELIMITER += "|" + Pattern.quote(customDelimiter);
            inputString = inputString.substring(newLineIndex + 1);
        }

        return inputString;
    }

    static private void splitDelimiter(String newInputString, String delimiter) {

    }
}
