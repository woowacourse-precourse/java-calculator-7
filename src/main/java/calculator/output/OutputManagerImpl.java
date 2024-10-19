package calculator.output;

/**
 * 출력과 관련된 객체
 */
public class OutputManagerImpl implements OutputManager {

    /**
     * 결과를 받으면 출력형식에 맞춰 출력
     * @param result int 형식의 결과값
     */
    @Override
    public void doPrint(final int result) {
        String formatOutput = String.format("결과 : %d", result);
        System.out.println(formatOutput);
    }
}
