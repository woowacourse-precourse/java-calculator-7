package calculator.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SeparatorDto {
    private static SeparatorDto instance;
    private final List<Character> separators;

    private SeparatorDto() {
        this.separators = new ArrayList<>();
        separators.add(',');
        separators.add(':');
    }
    // 싱글톤
    public static SeparatorDto getInstance() {
        if (instance == null) {
            instance = new SeparatorDto();
        }
        return instance;
    }
    public List<Character> getSeparators() {
        return separators;
    }


    public void addSeparator(Character separator) {
        separators.add(separator);
    }
    public boolean isContainSeparator(Character separator) {
        return this.separators.contains(separator);
    }
}
