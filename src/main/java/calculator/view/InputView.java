package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    /***
     * 사용자로부터 콘솔창을 통해 문자열을 입력받습니다.
     * @return : 입력받은 문자열을 반환합니다.
     */
    public String readInputString() {
        printStartMessage();

        String userInput = Console.readLine();
        checkInputIsNullOrBlank(userInput);

        return userInput;
    }

    /***
     * 계산기 프로그램 시작 메시지를 출력합니다.
     */
    private void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    /***
     * 입력값의 NULL 체크 및 공백 체크
     * @param userInput : 사용자의 입력
     */
    private void checkInputIsNullOrBlank(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException("형식에 맞춰 입력해주세요.");
        }
    }
}
