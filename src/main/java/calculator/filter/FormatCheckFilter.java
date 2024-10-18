package calculator.filter;

import calculator.configuration.CalculatorConfig;
import calculator.configuration.Delimiters;
import calculator.exception.IllegalFormatException;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatCheckFilter extends CalculatorFilter
{
    private CalculatorConfig configuration;

    public FormatCheckFilter()
    {
        this.configuration = CalculatorConfig.getInstance();
    }

    @Override
    public Optional<String> run(String input)
    {
        try
        {
            String splitter = configuration.getSplitter();
            String non_numbers = input.replaceAll("\\d", "");

            Pattern pattern = Pattern.compile("[^" + splitter + "|" + Delimiters.GROUP + "|+]");
            Matcher matcher = pattern.matcher(non_numbers);

            if(isEmpty((input))) input = "0";
            if (
                    isExceptional(input) ||
                            matcher.find() ||
                            !isValid(input))
            {
                throw new IllegalFormatException();
            }

            return Objects.isNull(nextStrategy) ? Optional.of(input) : nextStrategy.run(input);
        }

        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    private boolean isEmpty(String input)
    {
        return (input.isEmpty() || Objects.isNull(input));
    }

    private boolean isValid(String input)
    {
        String splitter = configuration.getSplitter();
        if (splitter.equals("+") && input.startsWith("+")) return false;
        return !input.startsWith(splitter) && !input.endsWith(splitter);
    }

    private boolean isExceptional(String input)
    {
        return input.contains("//") || input.contains("\\n");
    }
}
