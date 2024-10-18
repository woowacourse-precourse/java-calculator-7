package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;
import net.bytebuddy.implementation.bytecode.Throw;

public class SeparatorManager {
    public Separator getSeparator(String originString) {
        if (originString.startsWith("//")) {
            String[] parts = originString.split("\n", 2);
            String delimiter = Pattern.quote(parts[0].substring(2));

            Separator separator = new Separator();
            separator.addSeparator(Arrays.toString(parts[1].split(delimiter)));

            return separator;
        }
        else{
            return new Separator();
        }
    }

    public Number getNumber(Separator separator, String originString){
        Number number = new Number();
        originString = separateCustomSeparator(originString);

        for(int i = 0; i < originString.length(); i = i + 2){
            if(!Character.isDigit(originString.charAt(i))){
                throw new IllegalArgumentException();
            }
            if(!separator.isValidSeparator(String.valueOf(originString.charAt(i+1)))){
                throw new IllegalArgumentException();
            }
            number.addNumber(originString.charAt(i));
        }
        return number;
    }

    public String separateCustomSeparator(String originString){
        String[] parts = originString.split("\n", 2);
        if (parts.length > 1) {
            return Pattern.quote(parts[1].substring(2));
        } else {
            return Pattern.quote(parts[0].substring(2));
        }
    }
}
