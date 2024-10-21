package calculator.tool;

import java.util.ArrayList;
import java.util.List;

public class JavaCalculator {

    public List<String> partitions;

    public JavaCalculator() {
        partitions = new ArrayList<>();
        partitions.add(",");
        partitions.add(":");
    }

    public int solution(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
    }
}
