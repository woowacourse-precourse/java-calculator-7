package calculator.controller;

import calculator.domain.Calc;
import calculator.repository.NumberRepository;

public class CalcController {

    private Calc calc;
    private NumberRepository numberRepository;

    private void createNewCalc() {
        calc = new Calc();
        numberRepository = new NumberRepository();
    }
}
