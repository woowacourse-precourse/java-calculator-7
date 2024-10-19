package calculator.service;

import calculator.model.Separator;
import java.util.Set;

public interface SeparatorService {
    void join(Separator separator);
    Set<Separator> findAllSeparator();
}
