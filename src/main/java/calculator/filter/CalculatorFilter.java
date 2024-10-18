package calculator.filter;

import java.util.Optional;

public abstract class CalculatorFilter
{
    protected CalculatorFilter nextStrategy;

    public CalculatorFilter()
    {
        this.nextStrategy = null;
    }

    public void setNextStrategy(CalculatorFilter nextStrategy)
    {
        this.nextStrategy = nextStrategy;
    }

    public abstract Optional<String> run(String input);
}
