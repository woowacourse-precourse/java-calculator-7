package calculator;

public class BasicDelimiter implements Delimiter {
    private static final String BASIC_DELIMITER = "[,:]"; // 기본 구분자

    // 기본 구분자 반환
    public String getBasicDelimiter(){
        return BASIC_DELIMITER;
    }

    //기본 구분자를 기준으로 split
    @Override
    public String[] splitInput(String input){
        return input.split(BASIC_DELIMITER);
    }
}
