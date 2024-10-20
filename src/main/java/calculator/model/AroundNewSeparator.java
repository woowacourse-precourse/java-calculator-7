package calculator.model;

import java.util.HashMap;
import java.util.Set;

public class AroundNewSeparator {
    HashMap<Integer, Character> aroundNewSeparatorMap = new HashMap<>();
    private static final char FIRST_WRAPPING_CHAR = '/';
    private static final char SECOND_WRAPPING_CHAR = '/';
    private static final char THIRD_WRAPPING_CHAR = '\\';
    private static final char FOURTH_WRAPPING_CHAR = 'n';


    private AroundNewSeparator() {
        aroundNewSeparatorMap.put(0, FIRST_WRAPPING_CHAR);
        aroundNewSeparatorMap.put(1, SECOND_WRAPPING_CHAR);
        aroundNewSeparatorMap.put(3, THIRD_WRAPPING_CHAR);
        aroundNewSeparatorMap.put(4, FOURTH_WRAPPING_CHAR);
    }

    private static class SingletonHelper {
        private static final AroundNewSeparator INSTANCE = new AroundNewSeparator();
    }

    public static AroundNewSeparator getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public Set<Integer> getKeys() {
        return aroundNewSeparatorMap.keySet();
    }

    public char getValue(Integer aroundSeparatorIndex) {
        return aroundNewSeparatorMap.get(aroundSeparatorIndex);
    }
}
