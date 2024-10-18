package calculator;

public class ParsingInput {

    private static String[] splitAsToken(String input, String token){
        if (token.equals("[,:]")) {
            return input.split(token);
        }
        return input.substring(input.indexOf("\\n")+2).split(token);
    }

}
