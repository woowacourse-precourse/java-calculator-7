package calculator.models;

import java.util.ArrayList;

public class SeparatorModel {
    private final ArrayList<String> items;

    public SeparatorModel() {
        this.items = new ArrayList<String>();
        this.items.add(",");
        this.items.add(":");
    }

    public void addSeparator(String prefix) {
        String newItem = prefix.substring(2, 3);
        this.items.add(newItem);
    }

    public String removeSeparatorPrefix(String string) {
        return string.substring(5);
    }

    public String getRegex() {
        String[] array = this.items.toArray(new String[0]);
        return "(" + String.join("|", array) + ")";
    }
}
