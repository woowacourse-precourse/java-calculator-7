package calculator.adapters.input.cli;

import static calculator.infrastructure.constants.ResponseFormat.*;
import static calculator.infrastructure.constants.ResponseMessage.*;

import calculator.application.ports.input.InputReader;
import calculator.application.ports.output.OutputWriter;
import calculator.application.service.CalculateStringCommand;
import calculator.application.usecase.CalculateStringUseCase;

public class CliCalculationController {

    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final CalculateStringUseCase calculateStringUseCase;

    public CliCalculationController(
        InputReader inputReader,
        OutputWriter outputWriter,
        CalculateStringUseCase calculateStringUseCase) {

        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.calculateStringUseCase = calculateStringUseCase;
    }

    public void handle() {
        outputWriter.printLine(REQUEST_INPUT_MESSAGE.getMessage());
        String input = inputReader.readLine();
        String result = calculateStringUseCase.calculate(input);
        outputWriter.printLine(CALCULATION_RESULT.applyFormat(result));
    }
}
