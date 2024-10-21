package calculator.business;

import calculator.business.command.CalculateCommand;
import calculator.domain.service.Calculator;
import calculator.domain.model.value.PositiveNumber;
import calculator.domain.model.Translator;

import java.util.List;

public class TextCalculatorServiceImpl implements TextCalculatorService {

    private final Calculator calculator;

    public TextCalculatorServiceImpl(final Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Long calculateSumTotal(final CalculateCommand calculateCommand) {

        Translator translator = new Translator(calculateCommand.customSeparators);

        List<PositiveNumber> positiveNumbers = translator.translate(calculateCommand.majorData);

        return calculator.getSum(positiveNumbers);
    }
}
