package calculator.repository.number;

import java.util.List;

public interface NumberRepository {
    List<Integer> getNumbers();
    void saveNumbers(String numbers);

    //TEST 용도
    void clearAll();
}
