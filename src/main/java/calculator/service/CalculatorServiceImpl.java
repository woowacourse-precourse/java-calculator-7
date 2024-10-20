package calculator.service;

import calculator.dto.CalculatorDTO;
import static calculator.util.ExceptionUtil.checkNextTargetIsLiteral;
import static calculator.util.ExceptionUtil.checkStringHasRightNumOfTarget;

import java.util.StringTokenizer;

public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int calculate(CalculatorDTO calculatorDTO) {
        int calcResult = 0;

        checkStringHasRightNumOfTarget(calculatorDTO);

        StringTokenizer st = new StringTokenizer(calculatorDTO.getStr(),calculatorDTO.getDelim());
        while (st.hasMoreTokens()){
            calcResult += checkNextTargetIsLiteral(st.nextToken());
        }

        return calcResult;
    }
}
