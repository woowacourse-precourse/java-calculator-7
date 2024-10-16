package calculator;

public class Separator {
    private final String separatorString;

    public Separator(String seperatorString) {
        this.separatorString = seperatorString;
    }

    public String getSeparatorString() {
        return separatorString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() == o.getClass()) {
            return separatorString.equals(((Separator) o).separatorString);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return separatorString.hashCode();
    }
}
