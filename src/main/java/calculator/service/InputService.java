package calculator.service;

import calculator.view.InputView;
import java.lang.IllegalArgumentException;

public class InputService {

    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public String getValidInput() {
        //TODO: 사용자 입력 받기 및 검증 로직 구현
        try{
            String input = inputView.readInput();
            validateCustomDelimiter(input);
            return input;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private void validateCustomDelimiter(String input) {
        //TODO: 커스텀 구분자 검증 로직 구현
        if(input.startsWith("//")){
            int newlineIndex = input.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("\\n 가 존재하지 않습니다.");
            }

            String delimiter = input.substring(2, newlineIndex);

            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.");
            }
        }
    }
}
