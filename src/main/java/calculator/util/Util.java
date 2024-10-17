package calculator.util;

public class Util {
    private final String BASIC_SEPARATOR = "[,:]";
    private String[] extractList;
    public void extract(String text){
        basicSeparatorExtract(text);
    }

    private void basicSeparatorExtract(String text){
        extractList = text.split(BASIC_SEPARATOR);
    }


}
