package calculator;

import calculator.api.Calculation;
import calculator.api.Validation;

import javax.swing.plaf.SeparatorUI;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputString = readLine();

        if(inputString.isBlank()){
            if(inputString.isEmpty()){
                System.out.println("결과 : 0.0");
                return;
            }else{
                throw new IllegalArgumentException();
            }
        }
        try{
            Validation validation = new Validation();
            String separator = validation.validateString(inputString);

            Calculation calculation = new Calculation();
            Double result = calculation.calculationString(separator,inputString);

            System.out.println("결과 : " + result);
        }catch (IllegalStateException err){
            return;
        }
    }
}
