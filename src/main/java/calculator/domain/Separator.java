package calculator.domain;

public class Separator {

    private static String separators = "[,:]";


    public static void addSeparator(String customSeparator){
        separators += "|";
        separators += customSeparator;
    }

    public static String getSeparators(){
        return separators;
    }
}
