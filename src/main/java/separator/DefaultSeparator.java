package separator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultSeparator implements Separator {
    private final List<String> defaultSeparators;
    private String inputData;

    public DefaultSeparator(List<String> defaultSeparators) {
        this.defaultSeparators = defaultSeparators;
    }

    public DefaultSeparator(String inputData, Separator separator) {
        this.defaultSeparators = separator.getSeparator();
        this.inputData = inputData;
    }

    @Override
    public List<String> getSeparator() {
        return defaultSeparators;
    }

    @Override
    public List<BigInteger> getNumbers() {
        String createOrString = createOrString();
        String[] split = inputData.split(createOrString);
        List<BigInteger> bigIntegerList = new ArrayList<>();
        for (String str:split) {
            bigIntegerList.add(new BigInteger(str));
        }
        return bigIntegerList;
    }

    public void generateInputData(String inputData) {
        this.inputData = inputData;
    }

    public String createOrString(){
        StringBuilder orString = new StringBuilder();
        for (int i = 0; i < defaultSeparators.size(); i++) {
            if(i<defaultSeparators.size()-1){
                orString.append(defaultSeparators.get(i)).append("|");
            }else{
                orString.append(defaultSeparators.get(i));
            }
        }
        return orString.toString();
    }
}
