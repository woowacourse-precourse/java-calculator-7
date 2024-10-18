package calculator.view;

import java.util.Scanner;

public class InputView {

    public String inputCalculationValue(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String calculationValue = scanner.nextLine();
        return calculationValue;
    }
}
