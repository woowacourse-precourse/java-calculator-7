package calculator;

public class BasicDelimiter implements Delimiter {
    private static final String BASIC_DELIMITER = "[,:]"; // 기본 구분자

    @Override
    public String[] split(String input){
        return input.split(BASIC_DELIMITER);
    }
}
