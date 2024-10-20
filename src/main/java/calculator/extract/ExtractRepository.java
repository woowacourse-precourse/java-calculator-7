package calculator.extract;

import java.util.ArrayList;
import java.util.List;

public class ExtractRepository {
    private final List<Extract> extracts = new ArrayList<>();

    public void save(Extract extract) {
        extracts.add(extract);
    }

    public List<Extract> getExtracts() {
        return extracts.stream().toList();
    }
}
