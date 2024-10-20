package calculator.application;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class DelimiterList {
    private final Set<Delimiter> list;

    private DelimiterList(Set<Delimiter> list) {
        this.list = list;
    }

    public static DelimiterList from(Set<Delimiter> list) {
        return new DelimiterList(list);
    }

    public boolean contains(final Delimiter delimiter) {
        return this.list.contains(delimiter);
    }

    public Set<Delimiter> getList() {
        return new HashSet<>(this.list);
    }

    public void forEach(final Consumer<Delimiter> action) {
        this.getList().forEach(action);
    }

    public void add(final Set<Delimiter> list) {
        this.list.addAll(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelimiterList that = (DelimiterList) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}