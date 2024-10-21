package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputText;
    private String separators = ",;";

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

    private boolean haveCustomSeparator(String text) {
        return Pattern.matches("^//.*\\\\n.*$", text);
    }

    private void addCustomSeparator(String separatorText) {
        separatorText = separatorText.substring(2);
        for (char separator : separatorText.toCharArray()) {
            separators = separators + separator;
        }
    }

}
