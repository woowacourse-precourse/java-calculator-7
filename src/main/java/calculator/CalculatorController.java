package calculator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }

    public void calculate() {
        String input = inputView.inputString();
        Separators separators = new Separators();
        Optional<String> customSeparator = findCustomSeparator(input);
        if (customSeparator.isPresent()) {
            separators.add(new Separator(customSeparator.get()));
            input = input.substring(5);
        }
        List<String> separate = separators.separate(input);
        int sum = separate.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        outputView.printResult(sum);
    }

    private static Optional<String> findCustomSeparator(String input) {
        String pattern = "^//.+\\\\n";  // 여기서 . 은 하나의 문자만을 의미
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);

        if (matcher.find()) {
            // 전체 매칭된 문자열의 시작과 끝 인덱스
            int matchStart = matcher.start();
            int matchEnd = matcher.end();

            // 원하는 부분 추출
            return Optional.of(input.substring(matchStart + 2, matchEnd - 2));
        }

        return Optional.empty();
    }
}
