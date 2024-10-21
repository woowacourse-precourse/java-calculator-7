package calculator.service;

import calculator.view.InputView;

import java.util.List;

public class CalculatorService {
    private final InputView inputView;

    public CalculatorService(InputView inputView){
        this.inputView = inputView;
    }


    public List<String> init(){
        String input = inputView.readString();
        List<String> result = new StringParser().splitNumber(input);

        return result;
    }
    public void calculate(List<String> numbers){
        int sum =0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
    }



}
