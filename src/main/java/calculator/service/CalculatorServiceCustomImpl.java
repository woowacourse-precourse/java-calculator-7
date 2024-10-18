package calculator.service;

import calculator.dto.CalculatorDTO;

import java.util.regex.Pattern;

public class CalculatorServiceCustomImpl implements CalculatorService {

    @Override
    public int calculate(CalculatorDTO calculatorDTO) {
        int calcResult = 0;

        // get need parameter by dto
        String str = calculatorDTO.getStr();
        String customDelimiter = calculatorDTO.getDelim();

        // process the arguments for use
        String escapeCustomDelimiter = Pattern.quote(customDelimiter);
        String[] calcList = str.split(escapeCustomDelimiter);

        // iterate to calculate by custom delimiters
        for (String eachList : calcList) {
            calcResult += Integer.parseInt(eachList);
        }

        return calcResult;
    }

}
