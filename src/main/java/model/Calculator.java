package model;

import java.util.ArrayList;

public class Calculator {
    /**
     * 숫자를 합하는 함수
     * **/
    public static int add(ArrayList<Integer> numArr){
        int sum = 0;
        for(int i : numArr){
            sum += i;
        }
        return sum;
    }
}
