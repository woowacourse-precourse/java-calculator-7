package calculator;

import java.util.List;
import java.util.Objects;

public class Positives {

    private final List<Positive> positives;

    public Positives(List<Positive> positives) {
        this.positives = positives;
    }

    public static Positives from(List<String> value) {
        return new Positives(toNumbers(value));
    }

    private static List<Positive> toNumbers(List<String> input) {
        return input.stream().map(Positive::from).toList();
    }

    public Positive sum() {
        Positive result = Positive.zero();
        for (Positive positive : positives) {
            result = result.sum(positive);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Positives positives1 = (Positives) o;
        return positives.equals(positives1.positives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positives);
    }
}
