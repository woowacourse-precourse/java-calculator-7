package calculator.domain.separator;

import calculator.domain.identifier.Identifier;
import java.util.LinkedList;
import java.util.Queue;

public class Separator {

    private final Queue<String> queue = new LinkedList<>();
    private final String fixedSeparator1 = ",";
    private final String fixedSeparator2 = ":";
    private String customSeparator;
    private String[] strings;
    private Identifier identifier;

    public Separator() {
        this.identifier = new Identifier();
    }

    public Queue<String> separateString(String string) {

    }
}


