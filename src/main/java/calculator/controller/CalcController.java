package calculator.controller;

import calculator.domain.Calc;
import calculator.domain.Prep;
import calculator.domain.Validation;
import calculator.repository.NumberRepository;
import java.util.List;

public class CalcController {

    private Calc calc;
    private NumberRepository numberRepository;

    private void createNewCalc() {
        calc = new Calc();
        numberRepository = new NumberRepository();
    }

    private void checkingNumbers (List<Long> numbers) {
        Validation.overTheLongRangeNumberElements(numbers);
    }


}
