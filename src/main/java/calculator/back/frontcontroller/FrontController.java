package calculator.back.frontcontroller;

import calculator.back.controller.CalculatorController;
import calculator.back.dto.RequestDTO;
import calculator.back.dto.ResponseDTO;
import calculator.front.input.TotalDelimitedInput;
import calculator.back.resolver.ArgumentResolver;
import calculator.front.view.InputView;
import calculator.front.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class FrontController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ArgumentResolver argumentResolver;
    private final CalculatorController calculatorController;

    public FrontController(InputView inputView, OutputView outputView, ArgumentResolver argumentResolver,
                           CalculatorController calculatorController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.argumentResolver = argumentResolver;
        this.calculatorController = calculatorController;
    }

    public void run() {
        TotalDelimitedInput totalDelimitedInput = inputView.read();
        RequestDTO requestDTO = argumentResolver.resolve(totalDelimitedInput);
        ResponseDTO responseDTO = calculatorController.calculate(requestDTO);
        outputView.write(responseDTO.output());
        Console.close();
    }
}
