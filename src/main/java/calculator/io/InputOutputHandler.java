package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputOutputHandler {
	
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	private static final String INPUT_PREFIX = "덧셈할 문자열을 입력해 주세요.\n";
	private static final String OUTPUT_PREFIX = "\n결과 : ";
	
	public InputOutputHandler(InputValidator inputValidator, InputParser inputParser) {
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public InputParseResult handleInput() {
		System.out.print(INPUT_PREFIX);
		String input = Console.readLine();
		
		inputValidator.validate(input);
		
		return inputParser.parse(input);
	}
	
	public void handleOutput(int result) {
		System.out.print(OUTPUT_PREFIX);
		
		System.out.print(result);
	}
}
