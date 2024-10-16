package calculator.controller;

import calculator.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Calculator{
    List<String> delimilter = new ArrayList<>(); // 구분자를 저장할 리스트
    static String input; // 사용자가 입력한 값을 저장할 변수

    public static void run(){
        input = InputView.getInput();

    }
}
