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
        customSeparator = identifier.findDelimiter(string);
        String separatorRegex = fixedSeparator1 + "|" + fixedSeparator2;

        if (customSeparator != null) {
            separatorRegex += "|" + customSeparator;
            string = string.substring(string.indexOf("\\n") + 2);
        }

        strings = string.split(separatorRegex, -1);

        for (String s : strings) {
            queue.add(s);
        }

        return queue;
    }

}
