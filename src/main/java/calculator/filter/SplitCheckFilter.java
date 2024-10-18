package calculator.filter;

import calculator.configuration.CalculatorConfig;
import calculator.configuration.Delimiters;
import calculator.exception.IllegalFormatException;
import calculator.exception.InvalidException;
import calculator.utility.StringUtility;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitCheckFilter extends CalculatorFilter
{
    private CalculatorConfig configuration;

    public SplitCheckFilter()
    {
        this.configuration = CalculatorConfig.getInstance();
    }

    @Override
    public Optional<String> run(String input)
    {
        try
        {
            if(isIllegal(input)) throw new InvalidException();
            return Optional.of(input);
        }

        catch (Exception e)
        {
            return Optional.empty();
        }
    }

    private boolean isIllegal(String input)
    {
        String splitter = configuration.getSplitter();
        if (input.contains(splitter) || input.contains(Delimiters.GROUP))
        {
            String delim = (input.contains(splitter)) ? splitter : Delimiters.GROUP;
            String[] items = input.split(delim);
            for (String item : items)
            {
                if(isIllegal(item)) return true;
            }

            return false;
        }

        return !StringUtility.isNumber(input) || (Integer.parseInt(input) < 0);
    }
}
