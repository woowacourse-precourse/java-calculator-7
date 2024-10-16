package calculator.service;

public class StringParsing {
    public static String[] userInputStrToArr(String strInput) {
        return strInput.split("[,:]");
    }
}
