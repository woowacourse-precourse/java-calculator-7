package calculator;

import java.util.regex.Pattern;

public class Factor {

    private static final Pattern customSepratorRegExp = Pattern.compile("//");

    public String[] parseNum(String number){

        String[] factor;
        String separator = ",|:";

        if (number.isEmpty()){
            return new String[]{"0"};
        }

        if (isUsedCustomSeparator(number)){
            separator = parseCustomSeprator(number);
            int idx = endlineidx(number);
            if(idx == -1){
                throw new IllegalArgumentException();
            }
            number = number.substring(idx + 1);
        }

        factor = number.split(separator);
        return factor;
    }

    public boolean isUsedCustomSeparator(String input){
        return customSepratorRegExp.matcher(input).find();
    }

    public String parseCustomSeprator(String input){
        return String.valueOf(input.charAt(2));
    }

    public int endlineidx(String input){
        int idx = -1;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == 'n'){
                idx = i;
                break;
            }
        }
        return idx;
    }
}
