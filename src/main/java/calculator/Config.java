package calculator;

import calculator.Add.AddServiceImpl;
import calculator.calculator.CalculatorService;
import calculator.calculator.CalculatorServiceImpl;
import calculator.delimiterstorage.DelimiterStorageServiceImpl;
import calculator.parsing.ParsingNumberServiceImpl;

public class Config {
    private String s;

    public CalculatorService calculatorService(){
        return new CalculatorServiceImpl(s,new DelimiterStorageServiceImpl(),new ParsingNumberServiceImpl(),new AddServiceImpl());
    }




    public Config(String s) {
        this.s = s;
    }
}
