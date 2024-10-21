package calculator.stringSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SeparatorManager {
    private  List<String> separators;
    public SeparatorManager(){
        this.separators = new ArrayList<>(Arrays.asList(",",":"));
    }

    public void addSeparator(String customParts){
        for(String part : customParts.split("")){
            separators.add(part);
        }
    }

    public List<String> getSeparators() {
        return separators;
    }

    public String createSeparatorPattern(){
        return separators.stream().map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
