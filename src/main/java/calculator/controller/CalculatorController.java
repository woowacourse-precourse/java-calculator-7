package calculator.controller;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorController {

    public void run() throws IOException {

        System.out.println("돌아갑니다.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        service.getInputValues(input);
        System.out.println(calculator.getRawValue());
    }


}
