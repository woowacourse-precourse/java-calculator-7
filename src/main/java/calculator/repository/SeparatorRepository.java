package calculator.repository;

import calculator.model.Separator;
import java.util.Set;

public interface SeparatorRepository {
    void save(Separator separator);
    Set<Separator> findAll();
}
