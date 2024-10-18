package calculator.service;

import calculator.dto.CalculatorDTO;

import java.util.StringTokenizer;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(CalculatorDTO calculatorDTO) {
        int calcResult = 0;

        StringTokenizer st = new StringTokenizer(calculatorDTO.getStr(),calculatorDTO.getDelim());
        while (st.hasMoreTokens()){
            calcResult += Integer.parseInt(st.nextToken());
        }

        return calcResult;
    }
}
