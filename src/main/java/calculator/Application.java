package calculator;

import calculator.domain.UserRequest;
import calculator.io.CustomReader;
import calculator.io.CustomWriter;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CustomWriter.printInitMessage();
        String userInput = CustomReader.readLine();
        UserRequest userRequest = new UserRequest(userInput);
        userRequest.extractNumbers();


    }
}
