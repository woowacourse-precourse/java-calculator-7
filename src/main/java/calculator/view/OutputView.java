package calculator.view;

import calculator.model.Calculator;

import static calculator.util.Constants.OUTPUT_ANSWER;
import static calculator.util.Constants.OUTPUT_SUM_STRING;

public class OutputView {
    public void printInputMessage(){
        System.out.println(OUTPUT_SUM_STRING);
    }
    public void printAnswerMessage(int answer){
        System.out.println(OUTPUT_ANSWER + answer);
    }

}
