package calculator.split;

import java.util.HashSet;
import java.util.Set;

public class Seperator implements SeperatorInterface {
    private static Set<String> seperators;

    public Seperator() {
        seperators = new HashSet<String>();
        seperators.add(",");
        seperators.add(":");
    }

    @Override
    public void addSeperator(String seperator){
        if (seperator != null && !seperator.isEmpty()){
            seperators.add(seperator);
        }
    }

    public Set<String> getSeperators(){
        return new HashSet<> (seperators);
    }
}
