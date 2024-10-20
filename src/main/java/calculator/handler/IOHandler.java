package calculator.handler;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    // 입력 및 출력 메시지를 상수로 캡슐화
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT_MESSAGE = "결과 : ";
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값이 존재하지 않습니다.";

    /**
     * 사용자 입력을 처리하는 메서드.
     * 입력이 빈 문자열일 경우 IllegalArgumentException을 발생시킵니다.
     *
     * @return 사용자 입력 문자열
     */
    public static String input() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
        return input;
    }

    /**
     * 계산 결과를 출력하는 메서드.
     *
     * @param result 출력할 결과 값
     */
    public static void output(int result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }
}
