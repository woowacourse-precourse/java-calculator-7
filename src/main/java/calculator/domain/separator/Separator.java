package calculator.domain.separator;

import calculator.domain.number.Number;
import java.util.List;

public interface Separator {

    public abstract List<Number> separate(String value);
}
