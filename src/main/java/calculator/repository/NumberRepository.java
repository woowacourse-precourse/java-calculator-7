package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class NumberRepository {

    private List<Long> numbers;

    public NumberRepository() {
        numbers = new ArrayList<>();
    }

    public void save(List<Long> nums) {
        numbers = nums;
    }

    public List<Long> getNumbers() {
        return numbers;
    }
}
