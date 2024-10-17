package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputProcessor {

    private String input;

    public void readInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = br.readLine();
            while (br.ready()) {
                input = input.concat("\n" + br.readLine());
            }

            if (input == null) {
                throw new IllegalArgumentException("Input cannot be null");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error reading input", e);
        }
    }

    public String getInput() {
        return input;
    }

    public boolean hasCustomDelimiter() {
        return input.startsWith("//");
    }
}