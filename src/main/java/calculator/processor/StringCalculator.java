package calculator.processor;

import calculator.configuration.CalculatorConfig;
import calculator.configuration.Delimiters;
import calculator.exception.IllegalInputException;
import calculator.pipeline.BasicPipeline;
import calculator.pipeline.CalculatorPipeline;
import java.util.Optional;

public class StringCalculator implements Calculator
{
    private String input;
    private CalculatorConfig config;
    private CalculatorPipeline filters;

    public StringCalculator(String input)
    {
        this.input = input;
        this.config = CalculatorConfig.getInstance();
        this.filters = new BasicPipeline();
        config.setSplitter(Delimiters.DEFAULT_SPLITTER);
    }

    @Override
    public Optional<Integer> calculate()
    {
        try
        {
            Optional<String> result = filters.run(input);
            if (result.isEmpty()) throw new IllegalInputException();
            String real_input = result.get();
            int sum = calculate(real_input);
            return Optional.of(sum);
        }

        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    private int calculate(String input)
    {
        int sum = 0;
        String splitter = config.getSplitter();

        if (input.contains(splitter) || input.contains(Delimiters.GROUP))
        {
            String delim = (input.contains(splitter)) ? splitter : Delimiters.GROUP;
            String[] items = input.split(delim);
            for (String item : items)
            {
                sum += calculate(item);
            }

            return sum;
        }

        return Integer.parseInt(input);
    }
}
