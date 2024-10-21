package calculator.service;

public interface Service {

    void createSeparators();

    boolean isCustomSeparator(String input);

    void saveCustomSeparator(String input);

    String removeCustomPart(String input);

    String[] separateInput(String input);

    int calculate(String[] nums);
}
