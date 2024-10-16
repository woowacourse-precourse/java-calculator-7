package calculator.service;

import java.util.List;

public class CalculateCustom {

    private static final String CUSTOM_PRE = "//";
    private static final String CUSTOM_POST = "\\n";

    public static boolean checkContainCUSTOM_PRE(String userInput) {
        return userInput.contains(CUSTOM_PRE);
    }

    public static boolean checkContainCUSTOM_POST(String userInput) {
        return userInput.contains(CUSTOM_POST);
    }

    public static boolean checkContainCUSTOM(String userInput) {
        return checkContainCUSTOM_PRE(userInput) && checkContainCUSTOM_POST(userInput);
    }

    public static Integer getCustomPreIndex(String userInput) {
        return userInput.indexOf(CUSTOM_PRE);
    }

    public static Integer getCustomPostIndex(String userInput) {
        return userInput.indexOf(CUSTOM_POST) + 2;
    }

    public static String getCustomPreToPost(String userInput) {
        return userInput.substring(getCustomPreIndex(userInput), getCustomPostIndex(userInput));
    }

    public static String getCustomSeparator(String userInput) {
        return getCustomPreToPost(userInput).replaceAll(CUSTOM_PRE+CUSTOM_POST, "");
    }

    public static List<String> splitWithCustom(String userInput) {
        return List.of(userInput.split(getCustomSeparator(userInput)));
    }
}
