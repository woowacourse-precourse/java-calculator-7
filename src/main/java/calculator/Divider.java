package calculator;

import java.util.ArrayList;
import java.util.List;

public class Divider {
    private final static String COMMA = ",";
    private final static String CLON = ":";
    private String customDivider;


    public Divider() {
    }

    public void setCustomDivider(String customDivider) {
        this.customDivider = customDivider;
    }

    public String getComma(){
        return COMMA;
    }

    public String getClon(){
        return CLON;
    }

    public String getCustomDivider(){
        return customDivider;
    }




    /**
     * 먼저 customDivider이 비어있는지부터 확인 한 후
     * 비어있으면 : comma, clon만
     * 비어있지 않으면 cutom먼저
     */
}
