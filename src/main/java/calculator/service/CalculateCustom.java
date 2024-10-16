package calculator.service;

public class CalculateCustom {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\n";

    public boolean checkContainCUSTOM_PRE(String userInput) {
        return userInput.contains(CUSTOM_PRE);
    }

    public boolean checkContainCUSTOM_POST(String userInput) {
        return userInput.contains(CUSTOM_POST);
    }

    public boolean checkContainCUSTOM(String userInput) {
        return checkContainCUSTOM_PRE(userInput) && checkContainCUSTOM_POST(userInput);
    }
}
