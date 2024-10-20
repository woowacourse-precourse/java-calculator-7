package calculator;

import java.util.Set;

public class CalculatorController {
    private final CalculatorModel model;
    private final ConsoleView view;
    private final DelimiterFactory delimiterFactory;

    // DelimiterFactory를 의존성으로 받도록 변경
    public CalculatorController(CalculatorModel model, ConsoleView view, DelimiterFactory delimiterFactory) {
        this.model = model;
        this.view = view;
        this.delimiterFactory = delimiterFactory;
    }

    public void run() {
        try {
            String input = view.getInput();
            Set<Character> delimiters;

            // 커스텀 구분자가 없는 경우 기본 구분자로 처리
            if (!input.startsWith("//")) {
                delimiters = delimiterFactory.getBaseDelimiters(); // 기본 구분자만 사용
                int result = model.add(input, delimiters);  // 전체 입력을 덧셈할 부분으로 처리
                view.printResult(result);
                return;
            }

            // 커스텀 구분자 정의가 끝난 이후 부분을 계산할 문자열로 설정
            int lastNewlineIndex = delimiterFactory.findFirstIndexAfterDelimiters(input);
            delimiters = delimiterFactory.createDelimiters(input);

            if (lastNewlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format. Missing '\\n'.");
            }

            String expression = input.substring(lastNewlineIndex);  // 마지막 "\n" 이후 덧셈할 부분

            // 덧셈 결과 계산
            int result = model.add(expression, delimiters);
            view.printResult(result);

        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            throw e;
        }
    }
}
