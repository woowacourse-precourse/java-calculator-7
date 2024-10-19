package calculator.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Input {
    private final String startWith;
    private final String endWith;

    public Input(String startWith, String endWith) {
        this.startWith = startWith;
        this.endWith = endWith;
    }

    public List<String> read(Supplier<String> reader) {
        String content = reader.get();

        if(content.contains(startWith) ^ content.contains(endWith)) {
            throw new IllegalArgumentException("must start with: " + startWith + " and end with: "
                    + endWith + " at the same time");
        }

        List<String> inputs;
        if(content.contains(startWith)) {
            inputs = Arrays.asList(content.substring(startWith.length(), content.indexOf(endWith)),
                    content.substring(content.indexOf(endWith) + endWith.length()));
        } else {
            inputs = List.of(content);
        }

        return inputs;
    }
}
