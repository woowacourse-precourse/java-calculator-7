package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {

    public InputString getInputString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return new InputString(reader.readLine());
    }
}
