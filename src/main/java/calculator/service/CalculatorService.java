package calculator.service;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorService {
    private final InputView inputView;
    private final OutputView outputView;
    public CalculatorService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public List<String> init(){
        String input = inputView.readString();
        List<String> result = new StringParser().splitNumber(input);

        return result;
    }
    public int calculate(List<String> numbers){
        int sum =0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    public void printResult(int sum){
        outputView.printSum(sum);
    }



}
