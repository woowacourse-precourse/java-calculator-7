package calculator.ui;

import calculator.domain.Message;

public class OutputView {

    public void printCalculatorStartMessage(){
        System.out.println(Message.CALCULATOR_START_MESSAGE.getMessage());
    }

    public void printCalculatorsRESULTMessage(int total){
        System.out.println(Message.CALCULATOR_RESULT_MESSAGE.getMessage()+total);
    }





}
