package calculator.output;

import calculator.Constants;

/**
 * 출력과 관련된 객체
 */
public class OutputManagerImpl implements OutputManager {

    /**
     * 결과를 받으면 출력형식에 맞춰 출력
     * @param result int 형식의 결과값
     */
    @Override
    public void printResult(final int result) {
        String formatOutput = String.format(Constants.RESULT_OUTPUT, result);
        System.out.println(formatOutput);
    }

    @Override
    public void printPrompt() {
        System.out.println(Constants.PROMPT_OUTPUT);
    }
}
