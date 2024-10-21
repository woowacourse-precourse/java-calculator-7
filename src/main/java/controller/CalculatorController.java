package controller;

import domain.Number;
import service.CalculatorService;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        try{
            String input = inputView.readbuffer();
            inputView.validateInput(input);
            Number number = calculatorService.tokenizeInput(input);
            int result = calculatorService.sum(number);
            outputView.writeSumResult(result);
        }catch(IllegalArgumentException e){
            if(e.getMessage().equals("입력이 비어있습니다.")){
                System.out.println("결과 : 0");
            }
            else
                throw e;
        }catch(Exception e){
            outputView.printErrorMessage("예상치 못한 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
