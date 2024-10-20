package calculator.domain;

public class Delimiter {
    public static final char COMMA_DELIMITER = ',';
    public static final char COLON_DELIMITER = ':';
    public final Character CUSTOM_DELIMITER;

    public Delimiter(){
        CUSTOM_DELIMITER = null;
    }
    public Delimiter(String userInputMessage){
        this.CUSTOM_DELIMITER = findCustomDelimiter(userInputMessage);
    }

    private Character findCustomDelimiter(String userInputMessage){
        if(userInputMessage.substring(0, 2) == "//" && userInputMessage.substring(3, 5) == "\n"){
            return userInputMessage.charAt(2);
        }
        else throw new IllegalArgumentException();
    }

    public boolean checkDelimiter(char targetChar){
        if(targetChar == COMMA_DELIMITER || targetChar == COLON_DELIMITER){
            return true;
        }
        else if(CUSTOM_DELIMITER != null && targetChar == CUSTOM_DELIMITER){
            return true;
        }
        else return false;
    }
}
