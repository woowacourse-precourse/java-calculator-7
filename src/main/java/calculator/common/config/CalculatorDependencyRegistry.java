package calculator.common.config;

import calculator.model.delimiter.service.DelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public interface CalculatorDependencyRegistry {

    DelimiterService getDelimiterService();

    InputView getInputView();

    OutputView getOutputView();
}
