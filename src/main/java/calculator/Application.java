package calculator;

import calculator.domain.UserInput;
import calculator.service.InputReceiverService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //값을 입력받아 UserInput 형태로 돌려주는 InputReceiverService 초기화
        InputReceiverService inputReceiver = new InputReceiverService();
        
        try {
            UserInput userInput = inputReceiver.getUserInput();
            System.out.println("입력된 값: " + userInput.getText());
        } catch (IllegalArgumentException e) {
            System.out.println("입력하신 값에 오류가 있습니다. 다시 입력해 주세요.");
        }
    }
}
