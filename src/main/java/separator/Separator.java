package separator;

import java.util.ArrayList;

public class Separator {
    public static ArrayList<Character> separators = new ArrayList<>();

    public Separator() {
        separators.add(',');
        separators.add(':');
    }

    public void addNewSeparator(Character separator) {
        if(separator == null){
            return;
        }
        separators.add(separator);
    }

    public Character parseCustomSeparator(String string) {
        Character customSeparator = null;

        if(string.substring(0, 4).equals("//\\n")){
            return customSeparator;
        }

        customSeparator = string.charAt(2);

        return customSeparator;
    }

    public boolean validateCustomSeparatorForParsing(String string){

        if(string.length() < 4){
            return false;
        }

        String separatorWithPadding = string.substring(0, 4);
        if(separatorWithPadding.equals("//\\n")){
            return true;
        }

        if(string.length() < 5){
            return false;
        }

        separatorWithPadding = string.substring(0, 5);
        boolean hasStartPadding = separatorWithPadding.substring(0, 2).equals("//");
        boolean hasEndPadding = separatorWithPadding.substring(3, 5).equals("\\n");
        if(hasStartPadding && hasEndPadding){
            return true;
        }

        return false;
    }

    public String parseString(String string) {
        if(string.substring(0, 4).equals("//\\n")){
            return string.substring(4);
        }

        return string.substring(5);
    }
}
