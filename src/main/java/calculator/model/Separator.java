package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    List<String> characters = new ArrayList<>();

    public Separator() {
        characters.add(":");
        characters.add(",");
    }

    public boolean extractCustomCharacter(String input) {
        int firstIndex = input.indexOf("//");
        int lastIndex = input.lastIndexOf("\\n");
        if (firstIndex == -1 || lastIndex == -1) {
            return false;
        }

        String character = input.substring(firstIndex + 2, lastIndex);
        characters.add(character);
        return true;
    }

    public List<String> getCharacters() {
        return characters;
    }
}
