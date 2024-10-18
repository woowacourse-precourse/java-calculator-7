package adder;

import separator.Separator;

import java.util.ArrayList;

public class Adder {

    public Integer addNumbers(ArrayList<Integer> numbers) {

        int result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private boolean isSeparator(String e) {

        for (char separator : Separator.separators) {
            if (e.equals(String.valueOf(separator))) {
                return true;
            }
        }

        return false;
    }


}
