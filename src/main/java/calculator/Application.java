package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String inputString = readLine();

        splitString(inputString);
    }

    /**
     * @param inputString: 입력값
     * @return 계산 결과 만약 입력값이 "//"로 시작되고 그 뒤에 "\n"가 존재한다면 커스텀 구분자가 존재한다 (커스텀 구분자 내 공백 제외).
     */
    static public int splitString(String inputString) {
        if (inputString.startsWith("//")) {
            int newLineIndex = inputString.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정 후 '\\\\n'이 없습니다.");
            }

            String customDelimiter = inputString.substring(2, newLineIndex);

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.")
            }
        }
    }
}
