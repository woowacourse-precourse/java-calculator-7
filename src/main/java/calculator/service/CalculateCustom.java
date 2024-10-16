package calculator.service;

import java.util.List;

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

    public Integer getCustomPreIndex(String userInput) {
        return userInput.indexOf(CUSTOM_PRE);
    }

    public Integer getCustomPostIndex(String userInput) {
        return userInput.indexOf(CUSTOM_POST);
    }

    public String getCustomPreToPost(String userInput) {
        return userInput.substring(getCustomPreIndex(userInput), getCustomPostIndex(userInput));
    }

    public String getCustomSeparator(String userInput) {
        return getCustomPreToPost(userInput).replaceAll(CUSTOM_PRE+CUSTOM_POST, "");
    }
}
