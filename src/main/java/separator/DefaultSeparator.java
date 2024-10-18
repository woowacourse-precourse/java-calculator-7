package separator;

import java.util.List;

public class DefaultSeparator implements Separator {
    private final List<String> defaultSeparators;
    private final String inputData;

    public DefaultSeparator(String inputData, List<String> defaultSeparators) {
        this.defaultSeparators = defaultSeparators;
        this.inputData = inputData;
    }

    @Override
    public List<String> getSeparator() {
        return defaultSeparators;
    }

    @Override
    public String[] splitInputDataBySeparator() {
        //TODO 구분자가 기본구분자가 맞는지 검증
        String createOrString = createOrString();
        return inputData.split(createOrString);
    }

    @Override
    public String getInputData() {
        return inputData;
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
