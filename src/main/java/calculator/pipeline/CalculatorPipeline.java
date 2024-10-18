package calculator.pipeline;

import java.util.Objects;
import java.util.Optional;

public class CalculatorPipeline
{
    private calculator.filter.CalculatorFilter head;
    private calculator.filter.CalculatorFilter tail;

    public CalculatorPipeline()
    {
        head = null;
        tail = null;
    }

    public void addFilters(calculator.filter.CalculatorFilter...filters)
    {
        for(calculator.filter.CalculatorFilter filter : filters)
        {
            addFilter(filter);
        }
    }

    public void addFilter(calculator.filter.CalculatorFilter filter)
    {
        if (Objects.isNull(head))
        {
            head = filter;
            tail = filter;
        }

        else
        {
            tail.setNextStrategy(filter);
            tail = filter;
        }
    }

    public Optional<String> run(String input)
    {
        return head.run(input);
    }
}
