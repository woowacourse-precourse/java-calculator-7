package calculator;

import calculator.logic.CalcLogic;
import calculator.dto.InputDTO;
import calculator.io.CalculatorIO;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputDTO input = CalculatorIO.getInput();

        List<Long> numbers = CalcLogic.getNumbers( input );
        long result = CalcLogic.sumAll( numbers );

        CalculatorIO.loggingRes( result );
    }
}