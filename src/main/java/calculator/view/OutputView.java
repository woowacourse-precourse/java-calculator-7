package calculator.view;

import static calculator.util.Constants.*;

public class OutputView {
    public void printInputMessage(){
        System.out.println(OUTPUT_SUM_TEXT);
    }
    public void printAnswerMessage(int answer){
        System.out.println(OUTPUT_ANSWER + answer);
    }

}
