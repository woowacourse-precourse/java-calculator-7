package calculator.domain.delimiter;

import java.util.List;

public interface Delimiter {

    boolean matches();

    List<String> split();

}
