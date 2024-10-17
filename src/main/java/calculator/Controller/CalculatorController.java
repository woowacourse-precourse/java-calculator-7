package calculator.Controller;
import calculator.DTO.ParsedInputDTO;
import calculator.Model.CalculatorModel;
import calculator.Validator.InputValidator;
import calculator.View.InputView;
import calculator.View.OutputView;
public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final InputValidator inputValidator;

    public CalculatorController(CalculatorModel calculatorModel, InputValidator inputValidator){
        this.calculatorModel = calculatorModel;
        this.inputValidator = inputValidator;
    }

    public void run(){


        String userInput = InputView.userInput();

        boolean isValid = inputValidator.isValidInput(userInput);

        if(isValid) {
            ParsedInputDTO parsedInputDTO = calculatorModel.parseInput(userInput);
            int result = calculatorModel.addNumbers(parsedInputDTO.getNumbers());
            OutputView.userOutput(result);
        }else{
            throw new IllegalArgumentException("틀린 입력 입니다.");
        }

    }
}
