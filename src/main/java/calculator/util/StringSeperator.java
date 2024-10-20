package calculator.util;

import java.util.HashSet;
import java.util.Set;

public class StringSeperator {
    public static final Set<String> separator = new HashSet<>(Set.of(",", ":"));
    public static Set<String> getSeperator(){
        return separator;
    }
    public static String parseCustomSeperator(String input) {
        while(input.startsWith("//")){
            input = input.replace("\\n", "\n");

            int index = input.indexOf("\n");

            if(index==-1){
                throw new IllegalArgumentException("커스텀 구분자가 잘못 입력되었습니다.");
            }

            String delimiter = input.substring(2, index);
            String remaining = input.substring(index + 1);

            separator.add(delimiter);

            input = remaining;
        }

        return input;
    }
}
