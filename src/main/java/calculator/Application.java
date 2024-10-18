package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();  // Input 객체 생성
        String userInput = input.getUserInput();  // 사용자 입력 받기
        Select select = new Select(userInput); // 처음 조건을 위해 입력받은 값 전송.
    }
}
