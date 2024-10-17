package calculator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String[] originalSplitters = {",", ":"};
    private static Set<String> inputSplitters = new HashSet<>(); 

    public static void main(String[] args) {
        String input = Console.readLine();
        makeInputSplitters(input);
    }

    private static void makeInputSplitters(String input){
        for (String originalSplitter : originalSplitters) {
            if(input.contains(originalSplitter)){
                inputSplitters.add(originalSplitter);
            }
        }
    }
}
