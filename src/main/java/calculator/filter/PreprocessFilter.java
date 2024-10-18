package calculator.filter;

import calculator.configuration.CalculatorConfig;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreprocessFilter extends CalculatorFilter
{
    private final String regex = "//([^0-9])\\\\n";
    private final String regex_all = regex + ".*";
    private CalculatorConfig configuration;
    private Pattern pattern;

    public PreprocessFilter()
    {
        this.configuration = CalculatorConfig.getInstance();
        this.pattern = Pattern.compile(regex_all);
    }

    @Override
    public Optional<String> run(String input)
    {
        Matcher matcher = pattern.matcher(input);
        if (input.startsWith("//") && matcher.matches())
        {
            String splitter = matcher.group(1);
            configuration.setSplitter(splitter);
            input = input.replaceAll(regex, "");
        }

        return Objects.isNull(nextStrategy) ? Optional.of(input) : nextStrategy.run(input);
    }
}
