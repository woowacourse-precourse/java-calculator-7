package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputHandler.printInputRequest();
        // 입력
        String input = InputHandler.readInput();

        // custom input 처리
        List<Character> customInputList = CustomInputHandler.evaluateCustomInput(input);
        input = CustomInputHandler.removeCustomInput(input);

        // 구분점에 custom input에서 처리된 부분 추가
        List<Character> divisionCharacter = new ArrayList<>(List.of(':', ','));
        if(!customInputList.isEmpty()) {
            divisionCharacter.addAll(customInputList);
        }

        // 계산
        int result = Calculater.calculateInput(input, divisionCharacter);
        OutputHandler.printResult(result);
    }
}
