package calculator;

public class Delimiter {
    public  static  String escape(String delimiter) {
        return delimiter.replaceAll("[*]", "\\\\$0");
    }
}