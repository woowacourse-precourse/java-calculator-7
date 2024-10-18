package calculator.controller;

import calculator.common.config.NumberCalculatorDependencyRegistry;
import calculator.model.delimiter.service.DelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public abstract class CalculatorController implements Controller {

    protected final DelimiterService delimiterService;
    protected final InputView inputView;
    protected final OutputView outputView;

    public CalculatorController(NumberCalculatorDependencyRegistry dependencyRegistry) {
        this.delimiterService = dependencyRegistry.getDelimiterService();
        this.inputView = dependencyRegistry.getInputView();
        this.outputView = dependencyRegistry.getOutputView();
    }
}
