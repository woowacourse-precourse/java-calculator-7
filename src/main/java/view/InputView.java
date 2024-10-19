package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 사용자로부터 입력을 받아 검증한 후 반환합니다.
     *
     * @return 입력된 문자열
     */
    String getInput() {
        System.out.print(INPUT_PROMPT);
        String firstLine = readLine();
        validateInput(firstLine);

        // 두 번째 문자열이 있다면 개행문자를 포함하여 리턴합니다.
        String secondLine = readLine();
        if (secondLine != null) {
            return firstLine + '\n' + secondLine;
        }
        return firstLine;
    }

    /**
     * Console로부터 입력값을 읽어옵니다. 입력값이 없으면 null을 반환합니다.
     *
     * @return 입력값
     */
    private String readLine() {
        try {
            return Console.readLine();
        } catch (java.util.NoSuchElementException e) {
            // 입력 스트림에 더 이상 읽을 데이터가 없을 때 처리
            return null;
        }
    }

    /**
     * 입력된 문자열을 검증합니다. 문자열이 null일 경우 예외를 발생시킵니다.
     *
     * @param input 검증할 문자열
     */
    private void validateInput(String input) {
        if (input == null) {
            throw new NoSuchElementException("입력값이 없습니다.");
        }
    }
}
