package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.DelimiterManager;
import calculator.domain.ExpressionSplitter;
import calculator.domain.PositiveIntegerConverter;
import calculator.domain.StringParser;
import calculator.domain.SumCalculator;
import calculator.dto.AdditionInput;
import calculator.dto.AdditionResult;
import calculator.dto.ParsedComponents;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorController {

    public void run() {
        OutputView.printAdditionInputPrompt();
        AdditionInput additionInput = InputView.readAdditionInput();
        String validatedInput = additionInput.input();

        if (validatedInput.isEmpty()) {
            OutputView.printDefaultResult();
            run();
            return;
        }

        StringParser stringParser = new StringParser(validatedInput);
        ParsedComponents parsedComponents = stringParser.parse();

        DelimiterManager delimiterManager = new DelimiterManager(parsedComponents.delimiters());
        Pattern delimiterPattern = delimiterManager.createDelimiterPattern();

        ExpressionSplitter expressionSplitter = new ExpressionSplitter(delimiterPattern,
                parsedComponents.operationalExpression());
        List<String> splittedExpression = expressionSplitter.splitOperationalExpressionByDelimiters();

        PositiveIntegerConverter positiveIntegerConverter = new PositiveIntegerConverter(splittedExpression);
        List<Integer> positiveIntegers = positiveIntegerConverter.convertToPositiveIntegers();

        Calculator calculator = new SumCalculator(positiveIntegers);
        AdditionResult additionResult = AdditionResult.from(calculator.calculate());

        OutputView.printResult(additionResult);
    }
}