package calculator.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class CustomDeque<T extends ValueObject> extends ArrayDeque<T> {
    public CustomDeque() {
        super();
    }

    public CustomDeque(CustomDeque<T> deque) {
        for (T element : deque) {
            add(element);
        }
    }

    public CustomDeque(List<T> list) {
        for (T element : list) {
            add(element);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deque<?> that)) return false;
        return this.size() == that.size() && this.containsAll(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toArray());
    }
}
