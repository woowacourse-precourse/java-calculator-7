package calculator.models;

import java.util.ArrayList;

public class SeparatorModel {
    private final ArrayList<String> items;
    private static final int SEPARATOR_START_INDEX = 2;
    private static final int SEPARATOR_END_INDEX = 3;
    private static final int NUMBER_START_INDEX = 5;

    public SeparatorModel() {
        this.items = new ArrayList<>();
        this.items.add(",");
        this.items.add(":");
    }

    public void addSeparator(String input) {
        String newItem = input.substring(SEPARATOR_START_INDEX, SEPARATOR_END_INDEX);
        this.items.add(newItem);
    }

    public String removeCustomPrefix(String string) {
        return string.substring(NUMBER_START_INDEX);
    }

    public String getRegex() {
        String[] array = this.items.toArray(new String[0]);
        return "(" + String.join("|", array) + ")";
    }
}
