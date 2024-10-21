package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Calculator {
    //입력받은 데이터
    private String inputData;
    //구분자 리스트
    private List<String> dTList;

    public Calculator() {}
    public Calculator(String inputData) {
        this.inputData = inputData;
        this.dTList = new ArrayList<>(Arrays.asList(",", ":"));
    }
}