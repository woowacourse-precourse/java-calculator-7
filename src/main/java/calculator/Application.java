package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        String input = Console.readLine();

        // 입력이 null이거나 공백일 경우 처리
        if (input == null || input.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;  // 입력이 비었을 경우 바로 종료
        }

        // 커스텀 구분자가 있는 경우
        if (input.startsWith("//")) {
            SeparatorManager separatorManager = new SeparatorManager();
            separatorManager.processInput(input);

            String numberString = separatorManager.getNumberString();
            ArrayList<String> separators = separatorManager.getSeparators();

            NumberManager numberManager = new NumberManager();
            numberManager.numberInput(numberString, separators);
            numberManager.calculateSum();
        } else {
            // 커스텀 구분자가 없는 경우
            if (Character.isDigit(input.charAt(0))) {
                ArrayList<String> separators = new ArrayList<>();
                separators.add(",");
                separators.add(":");

                NumberManager numberManager = new NumberManager();
                numberManager.numberInput(input, separators);
                numberManager.calculateSum();
            }
        }
    }
}