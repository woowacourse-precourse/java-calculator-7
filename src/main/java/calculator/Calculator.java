package calculator;

import calculator.view.InputView;
import calculator.domain.Adder;
import calculator.domain.Separator;
import calculator.view.OutputView;

import java.util.List;

public class Calculator {
    private final Adder adder;
    private final Separator separator;
    private final InputView inputView;
    private final OutputView outPut;

    public Calculator(Adder adder, Separator separator, InputView inputView, OutputView outPut){
        this.adder = adder;
        this.separator = separator;
        this.inputView = inputView;
        this.outPut = outPut;
    }

    public void run(){
        inputView.showStartMessage();
        String inputValue = inputView.getInput();
        System.out.println(inputValue);
        if(separator.isExistCustomSeparator(inputValue)){
            inputValue = separator.processCustomSeparator(inputValue);
        }
        List<Long> numbers =  separator.extractNumbers(inputValue);
        outPut.showResult(adder.add(numbers));
    }

}
