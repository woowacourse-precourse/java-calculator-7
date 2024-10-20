package calculator.calculator;

import calculator.Add.AddService;
import calculator.delimiterstorage.DelimiterStorageService;
import calculator.parsing.ParsingNumberService;

import java.math.BigInteger;

public class CalculatorServiceImpl implements CalculatorService {
    private final String s;
    private final  DelimiterStorageService delimiterStorageService;
    private final ParsingNumberService parsingNumberService;
    private final AddService addService;


    @Override
    public BigInteger calculate()
    {
        delimiterStorageService.delimeterStore(s);
        parsingNumberService.parsingNumber(s,delimiterStorageService.getDelimiters());
        addService.add(parsingNumberService.getNumbers());

        return addService.getAddResult();
    }

    public CalculatorServiceImpl(String s, DelimiterStorageService delimiterStorageService, ParsingNumberService parsingNumberService, AddService addService) {

        this.s = s;
        this.delimiterStorageService = delimiterStorageService;
        this.parsingNumberService = parsingNumberService;
        this.addService = addService;
    }
}
