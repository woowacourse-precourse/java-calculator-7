package calculator.domain;

import java.util.List;

public class Calculator {

    private List<String> separator;

    public Calculator() {
        this.separator.add(",");
        this.separator.add(";");
    }

    public void addSeparator(String separator) {
        this.separator.add(separator);
    }
}
