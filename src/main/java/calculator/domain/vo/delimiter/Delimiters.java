package calculator.domain.vo.delimiter;

import java.util.List;

public class Delimiters {

    private final List<Delimiter> delimiters;

    private Delimiters(List<Delimiter> delimiters) {
        this.delimiters = delimiters;
    }

    public static Delimiters from(List<Delimiter> delimiters) {
        addDefaultDelimiters(delimiters);

        return new Delimiters(delimiters);
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }

    private static void addDefaultDelimiters(List<Delimiter> delimiters) {
        delimiters.add(Delimiter.from(","));
        delimiters.add(Delimiter.from("\n"));
    }
}
