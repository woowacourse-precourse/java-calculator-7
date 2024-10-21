package calculator.domain.separator;

import calculator.domain.number.Numbers;

public interface Separator {

    public abstract Numbers separate(String value);
}
