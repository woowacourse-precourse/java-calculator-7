package separator;

import java.math.BigInteger;
import java.util.List;

public class DefaultSeparator implements Separator {
    private final List<String> defaultSeparators;

    public DefaultSeparator(List<String> defaultSeparators) {
        this.defaultSeparators = defaultSeparators;
    }

    @Override
    public List<String> getSeparator() {
        return defaultSeparators;
    }

    @Override
    public List<BigInteger> getNumbers(String input) {
        input.split(createOrString());
        return null;
    }

    private String createOrString(){
        String orString = "";
        for (int i = 0; i < defaultSeparators.size(); i++) {
            if(i<defaultSeparators.size()-1){
                orString+=defaultSeparators.get(i)+"|";
            }else{
                orString+=defaultSeparators.get(i);
            }
        }
        return orString;
    }
}
