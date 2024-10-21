package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    private String inputText;

    private void read() {
        inputText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(new IllegalArgumentException().getMessage());
        }
    }

}
