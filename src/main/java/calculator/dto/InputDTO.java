package calculator.dto;

import java.util.Optional;

public class InputDTO{
    private final String sumExp;
    private final String dividerExp;

    public InputDTO( String exp ) {
        int divider_end = exp.indexOf("\\n");
        if ( divider_end > -1 ) {
            this.dividerExp = exp.substring( 2, divider_end );
            divider_end += 2;
        } else {
            this.dividerExp = "";
            divider_end = 0;
        }

        this.sumExp = exp.substring( divider_end, exp.length() );
//
//        System.out.println("dividerExp: " + this.dividerExp);
//        System.out.println("sumExp: " + this.sumExp);
    }

    public String getSumExp() { return this.sumExp; }

    public String getDividerExp() { return this.dividerExp; }
};