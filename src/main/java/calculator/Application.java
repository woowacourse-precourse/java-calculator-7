package calculator;

import calculator.Domain.Extractor;
import calculator.View.InputView;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String calculationInput = InputView.readCalculationInput();

        try {
            ArrayList<Integer> extractedNumbers = Extractor.extractNumbers(calculationInput);

        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다");
        }

    }
}
