package calculator.util;
public class Util {
    private final String BASIC_SEPARATOR = "[,:]";

    public void extract(String text){
        separatorExtract(text);
    }
    private String[] separatorExtract(String text){
        return basicSeparatorExtract(text);
    }

    private String[] basicSeparatorExtract(String text){
        return text.split(BASIC_SEPARATOR);
    }

}
