package calculator.processor;

import calculator.configuration.CalculatorConfig;
import calculator.configuration.Delimiters;
import calculator.exception.IllegalInputException;
import calculator.pipeline.BasicPipeline;
import calculator.pipeline.CalculatorPipeline;
import java.util.Optional;

public class StringCalculator implements Calculator {
    private String input;
    private CalculatorConfig config;
    private CalculatorPipeline filters;

    public StringCalculator(String input) {
        this.input = input;
        this.config = CalculatorConfig.getInstance();
        this.filters = new BasicPipeline();
        config.setSplitter(Delimiters.DEFAULT_SPLITTER);
    }

    @Override
    public Optional<Long> calculate() {
        try {
            Optional<String> result = filters.run(input);
            if (result.isEmpty()) {
                throw new IllegalInputException();
            }
            String real_input = result.get();
            long sum = calculate(real_input);
            return Optional.of(sum);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private long calculate(String input) {
        long sum = 0;
        String splitter = config.getSplitter();

        if (input.contains(splitter) || input.contains(Delimiters.GROUP)) {
            String delim = (input.contains(splitter)) ? splitter : Delimiters.GROUP;
            String[] items = input.split(delim);
            for (String item : items) {
                sum += calculate(item);
            }

            return sum;
        }

        long value = Integer.parseInt(input);

        // TODO: 표현 범위 관련 처리하기
        if (value > Integer.MAX_VALUE) {
            throw new IllegalInputException();
        }
        return Integer.parseInt(input);
    }
}
