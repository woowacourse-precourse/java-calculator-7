package calculator.controller;

import calculator.common.di.NumberCalculatorDependencyRegistry;
import calculator.model.delimiter.service.DelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public abstract class CalculatorController implements Controller {

    protected final DelimiterService delimiterService;
    protected final InputView inputView;
    protected final OutputView outputView;

    public CalculatorController(NumberCalculatorDependencyRegistry numberCalculatorDependencyRegistry) {
        this.delimiterService = numberCalculatorDependencyRegistry.getDelimiterService();
        this.inputView = numberCalculatorDependencyRegistry.getInputView();
        this.outputView = numberCalculatorDependencyRegistry.getOutputView();
    }
}
