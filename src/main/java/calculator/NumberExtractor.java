package calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberExtractor {

    private String text;

    public NumberExtractor(String input) {
        this.text = input;
    }

    public List<Double> extract(String regex) {
        if (!hasNumber()) {
            return Collections.singletonList(0.0);
        }

        String numberLeft = this.text.replaceAll(regex, " ");

        return Arrays.stream(numberLeft.split(" "))
                .mapToDouble(Double::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean hasNumber() {
        return !this.text.isBlank();
    }
}
