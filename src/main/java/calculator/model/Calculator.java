package calculator.model;

public class Calculator {
    private String str;
    private String[] strArr;
    private int answer;

    public Calculator(String str){
        this.str = str;
        this.answer = 0;
    }

    public int getAnswer(){
        return this.answer;
    }

    public boolean validateNull(){
        return this.str.isEmpty();
    }

    public void parseNumbers(){
        if(validateCustom()) customParse();
        else normalParse();
    }

    public boolean validateCustom(){
        return str.startsWith("/");
    }

    public void customParse(){
        String separator = String.valueOf(this.str.charAt(2));
        this.str = this.str.substring(5);
        this.strArr = this.str.split(separator);
    }

    public void normalParse(){
        this.strArr = this.str.split("[,;]");
    }

}