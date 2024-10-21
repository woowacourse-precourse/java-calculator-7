package calculator.service;

import java.util.List;

public interface Service {

    List<String> createSeparators();

    boolean isCustomSeparator(String input);

    String saveCustomSeparator(String input);

    String removeCustomPart(String input);

    String[] separateInput(String input, List<String> separators);

    int calculate(String[] nums);
}
