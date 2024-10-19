package calculator;

public class SumController {
    public static char[] separator = new char[3];

    public static int checkValue(String text) throws Exception {
        if(text.charAt(0) == '/' && text.charAt(1) == '/') {
            if(text.charAt(3) == '\\' && text.charAt(4) == 'n') {
                separatorExtraction(text.charAt(2));
            }
            for(int i = 5; i<text.length(); i++) {
                if(i % 2 != 0) {
                    if(text.charAt(i) <= '0' || text.charAt(i) >= '9') {
                        throw new IllegalArgumentException();
                    }
                } else {
                    if(text.charAt(i) != separator[0] && text.charAt(i) != separator[1] && text.charAt(i) != separator[2]) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return sum(text);
        }
        for(int i = 0; i<text.length(); i++) {
            separatorExtraction(' ');
            if(i % 2 == 0) {
                if(text.charAt(i) <= '0' || text.charAt(i) >= '9') {
                    throw new IllegalArgumentException();
                }
            } else {
                if(text.charAt(i) != separator[0] && text.charAt(i) != separator[1]) {
                    System.out.println("2");
                    System.out.println(separator);
                    System.out.println(text.charAt(i));
                    throw new IllegalArgumentException();
                }
            }
        }
        return sum(text);
    }

    public static char[] separatorExtraction(char word) {
        separator[0] = ',';
        separator[1] = ':';
        separator[2] = word;
        return separator;
    }

    public static int sum(String text) {
        int result = 0;
        if(text.charAt(0) == '/') {
            for(int i = 5; i<text.length(); i += 2) {
                result += text.charAt(i) - '0';
            }
        } else {
            for(int i = 0; i<text.length(); i += 2) {
                result += text.charAt(i) - '0';
            }
        }
        return result;
    }
}
