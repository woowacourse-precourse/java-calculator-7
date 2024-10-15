package calculator;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static String userInput;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {
        System.out.println(Message.START.getMessage());
        getUserInput();
    }

    /**
     * 사용자가 콘솔에 입력한 값을 저장하는 함수
     */
    public void getUserInput() {
        String input = Console.readLine();
        userInput = input.replace("\\n", "\n");
    }
}