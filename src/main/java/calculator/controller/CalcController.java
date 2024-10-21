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

    private List<Long> prepToCalc(List<String> dicedExpression) {
        List<Long> inputNums = Prep.convertToNumbers(dicedExpression);
        checkingNumbers(inputNums);
        return inputNums;
    }

    public void receiveData(List<String> dicedExpression) {
        numberRepository.save(prepToCalc(dicedExpression));
    }

    private void checkingResult() {
        Validation.overflowOccurInLongValue(calc.getValue());
    }

    public Long calcTheNumbers() {
        calc.sumAllNumbers(numberRepository.getNumbers());
        checkingResult();
        return calc.getValue();
    }

}
