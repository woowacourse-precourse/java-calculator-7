package calculator.repository.separator;

import java.util.List;

public interface SeparatorRepository {
    List<Character> getSeparators();
    void saveSeparator(String separatorLine);

    //test용
    void clearAll();
}
