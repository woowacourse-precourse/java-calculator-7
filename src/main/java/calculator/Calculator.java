package calculator;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class Calculator {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Tokenization tokenization = new Tokenization();


    /**
     * 문자열 계산기를 실행 함수
     * **/
    public static void run(){
        String str = inputView.input();
        int result = 0;
        // 빈 문자열이면 "0"을 반환
        if(!str.isEmpty()) {
            result = add(tokenization.operator(str));
        }
        outputView.output(result);
    }

    /**
     * 숫자를 합하는 함수
     * **/
    private static int add(ArrayList<Integer> numArr){
        int sum = 0;
        for(int i : numArr){
            sum += i;
        }
        return sum;
    }
}