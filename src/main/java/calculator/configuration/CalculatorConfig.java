package calculator.configuration;

public class CalculatorConfig
{
    private static CalculatorConfig instance = null;
    private String splitter;

    private CalculatorConfig()
    {
        this.splitter = Delimiters.DEFAULT_SPLITTER;
    }

    public void setSplitter(String splitter)
    {
        this.splitter = splitter;
    }

    public String getSplitter()
    {
        return splitter;
    }

    public static CalculatorConfig getInstance()
    {
        if (instance != null) return instance;
        return (instance = new CalculatorConfig());
    }
}
