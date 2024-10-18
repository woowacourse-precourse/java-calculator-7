package calculator.io;

import camp.nextstep.edu.missionutils.Console;

/**
 * IO작업을 수행하고, 적절히 검증하는 역할
 */
public class InputOutputHandler {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    private static final String INPUT_PREFIX = "덧셈할 문자열을 입력해 주세요.\n";
    private static final String OUTPUT_PREFIX = "\n결과 : ";

    public InputOutputHandler(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    /**
     * 사용자 입력을 읽어 검증하고 파싱한다.
     *
     * @return 파싱된 결과값, 커스텀구분자 문자열과 숫자 문자열로 구성된다.
     */
    public InputParseResult handleInput() {
        System.out.print(INPUT_PREFIX);
        String input = Console.readLine();

        inputValidator.validate(input);

        return inputParser.parse(input);
    }

    /**
     * 덧셈 결과값을 출력한다.
     *
     * @param result 덧셈 결과값
     */
    public void handleOutput(int result) {
        System.out.print(OUTPUT_PREFIX);

        System.out.print(result);
    }
}
