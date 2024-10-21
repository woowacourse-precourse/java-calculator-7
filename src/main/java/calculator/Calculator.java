package calculator;

import java.util.ArrayList;

public class Calculator {
    public void getResult(ArrayList<Integer> arr){
        printResult(sum(arr));
    }

    private int sum(ArrayList<Integer> arr){
        int result = 0;
        for(int i = 0; i < arr.size(); i++){
            result += arr.get(i);
        }
        return result;
    }

    private void printResult(int result){
        System.out.print("결과 : "+result);
    }
}
