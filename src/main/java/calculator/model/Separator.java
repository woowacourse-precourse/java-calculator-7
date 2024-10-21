package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private final List<String> characters = new ArrayList<>();
    private final int IS_NOT_FOUND = -1;
    private final int PADDING = 2;

    public Separator() {
        characters.add(":");
        characters.add(",");
    }

    public boolean extractCustomCharacter(String input) {
        int firstIndex = input.indexOf("//");
        int lastIndex = input.lastIndexOf("\\n");
        if (firstIndex == IS_NOT_FOUND || lastIndex == IS_NOT_FOUND) {
            return false;
        }

        String character = input.substring(firstIndex + PADDING, lastIndex);
        characters.add(character);
        return true;
    }

    public List<String> getCharacters() {
        return characters;
    }
}
