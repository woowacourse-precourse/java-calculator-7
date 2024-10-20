package calculator.api;

public class Validation {
    private String separator;

    public Validation() {
        this.separator = "[,:]";
    }

    public String validateString(String input){
        try{
            checkCustom(input);
            return separator;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    private void checkCustom(String input){
        if(input.substring(0,2).equals("//") && input.contains("\\n")){
            int i = input.indexOf("\\");
            separator = input.substring(2, i);
        }else if(input.substring(0,2).equals("//") && !input.contains("\\n")){
            throw new IllegalArgumentException();
        }else if(!input.substring(0,2).equals("//") && input.contains("\\n")){
            throw new IllegalArgumentException();
        }
    }
}
