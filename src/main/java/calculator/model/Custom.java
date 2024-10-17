package model;

import java.util.HashSet;

public class Custom {
    private static final String INITIAL_CUSTOM_COLON = ":";
    private static final String INITIAL_CUSTOM_COMMA = ",";

    private final HashSet<String> customSet;

    public Custom() {
        this.customSet = new HashSet<>();
        this.customSet.add(INITIAL_CUSTOM_COLON);
        this.customSet.add(INITIAL_CUSTOM_COMMA);
    }

    public void addCustomSet(String customData) {
        if(!customSet.isEmpty()) {
            customSet.add(customData);
            System.out.println("customDataSet" + customSet);
        }
    }

    public HashSet<String> getCustomSet() {
        return customSet;
    }

}
