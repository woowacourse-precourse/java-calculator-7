package calculator.config;

import calculator.controller.CalculatorController;
import calculator.repository.MemorySeparatorRepository;
import calculator.service.CalculatorService;
import calculator.service.Parser;
import calculator.service.SeparatorService;
import calculator.service.SeparatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }



    public MemorySeparatorRepository separatorRepository() {
        return new MemorySeparatorRepository();
    }



    public CalculatorService calculatorService() {
        return new CalculatorService();
    }

    public SeparatorService separatorService() {
        MemorySeparatorRepository repository = separatorRepository();
        SeparatorInitializer separatorInitializer = new SeparatorInitializer(repository);
        separatorInitializer.initialize();

        return new SeparatorServiceImpl(repository);
    }

    public Parser parser() {
        return new Parser(separatorService());
    }



    public CalculatorController calculatorController() {
        return new CalculatorController(calculatorService(), parser(), outputView());
    }
}
