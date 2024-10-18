package calculator.dto;

import java.util.regex.Pattern;

public class CalculatorDTO {
    private final String str;
    private final String delim;
    private final boolean custom;

    public CalculatorDTO(String str) {
        if(str.startsWith("//")){
            String[] firstSplit = str.split("\\\\n");
            this.delim = firstSplit[0].split("//")[1].trim();
            this.str = firstSplit[1];
            this.custom = true;
        }else{
            this.str = str;
            this.delim = ",:";
            this.custom = false;
        }
    }

    public String getStr() {
        return str;
    }

    public String getDelim() {
        return delim;
    }

    public boolean hasCustomDelim(){
        return custom;
    }
}
