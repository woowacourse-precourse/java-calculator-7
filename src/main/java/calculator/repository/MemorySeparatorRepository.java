package calculator.repository;

import calculator.model.Separator;
import java.util.HashSet;
import java.util.Set;

public class MemorySeparatorRepository implements SeparatorRepository{
    private static final Set<Separator> store = new HashSet<>();

    @Override
    public void save(Separator separator) {
        store.add(separator);
    }

    @Override
    public Set<Separator> findAll() {
        return store;
    }
}
