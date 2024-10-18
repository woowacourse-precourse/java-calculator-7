package calculator.pipeline;

import calculator.filter.CalculatorFilter;
import calculator.filter.FormatCheckFilter;
import calculator.filter.PreprocessFilter;
import calculator.filter.SplitCheckFilter;

public class BasicPipeline extends CalculatorPipeline
{
    public BasicPipeline()
    {
        super();
        CalculatorFilter first = new PreprocessFilter();
        CalculatorFilter second = new FormatCheckFilter();
        CalculatorFilter third = new SplitCheckFilter();
        addFilters(first, second, third);
    }
}
