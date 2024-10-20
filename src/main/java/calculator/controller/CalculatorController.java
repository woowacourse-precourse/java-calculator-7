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

        AdditionResult additionResult = processInput(validatedInput);
        OutputView.printResult(additionResult);
    }

    private AdditionResult processInput(String input) {
        ParsedComponents parsedComponents = parseInput(input);
        Pattern delimiterPattern = createDelimiterPattern(parsedComponents);
        List<String> splittedExpression = splitExpression(parsedComponents, delimiterPattern);
        List<Integer> positiveIntegers = convertToPositiveIntegers(splittedExpression);
        return calculateResult(positiveIntegers);
    }

    private ParsedComponents parseInput(String input) {
        StringParser stringParser = new StringParser(input);
        return stringParser.parse();
    }

    private Pattern createDelimiterPattern(ParsedComponents parsedComponents) {
        DelimiterManager delimiterManager = new DelimiterManager(parsedComponents.delimiters());
        return delimiterManager.createDelimiterPattern();
    }

    private List<String> splitExpression(ParsedComponents parsedComponents, Pattern delimiterPattern) {
        ExpressionSplitter expressionSplitter = new ExpressionSplitter(delimiterPattern,
                parsedComponents.operationalExpression());
        return expressionSplitter.splitOperationalExpressionByDelimiters();
    }

    private List<Integer> convertToPositiveIntegers(List<String> splittedExpression) {
        PositiveIntegerConverter positiveIntegerConverter = new PositiveIntegerConverter(splittedExpression);
        return positiveIntegerConverter.convertToPositiveIntegers();
    }

    private AdditionResult calculateResult(List<Integer> positiveIntegers) {
        Calculator calculator = new SumCalculator(positiveIntegers);
        return AdditionResult.from(calculator.calculate());
    }
}