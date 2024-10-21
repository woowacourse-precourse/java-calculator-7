package calculator;

import java.util.List;
import java.util.Objects;

public class Calculator {
    public int calculate() {
        int sum = 0;
        String rawLine = Writer.write();
        Parser parser = new Parser();
        List<String> tokens = parser.parsing(Objects.requireNonNull(rawLine));
        for (String token : tokens) {
            if (!tokens.isEmpty()) {
                sum += Integer.parseInt(token);
            }
        }
        return sum;
    }
}
