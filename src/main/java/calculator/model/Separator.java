package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private List<Character> separatorList = new ArrayList<>(Arrays.asList(',', ':'));

    private Separator() {
    }

    private static class SingletonHelper {
        private static final Separator INSTANCE = new Separator();
    }

    public static Separator getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public List<Character> getSeparator() {
        return separatorList;
    }

    public void initiateSeparator() {
        separatorList.clear();
        separatorList.add(',');
        separatorList.add(':');
    }

    public void insertSeparator(char newSeparator) {
        separatorList.add(newSeparator);
    }

}
