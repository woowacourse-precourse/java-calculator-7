package calculator.Controller;
import calculator.DTO.ParsedInputDTO;
import calculator.Model.CalculatorModel;
import calculator.Validator.InputValidator;
import calculator.View.InputView;
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

        ParsedInputDTO parsedInputDTO = calculatorModel.parseInput(userInput);

        System.out.println(parsedInputDTO.getNumbers());
        System.out.println(parsedInputDTO.getSeparators());

    }
}
