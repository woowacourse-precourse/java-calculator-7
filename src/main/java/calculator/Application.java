package calculator;

import calculator.io.ProgramOutput;
import calculator.io.UserInput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ProgramOutput output = new ProgramOutput();

        UserInput input = new UserInput();

        output.requestString();

        String inputString = input.responseString();
    }
}
