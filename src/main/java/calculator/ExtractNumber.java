package calculator;

public class ExtractNumber {

    public String input;

    public ExtractNumber(String input) {
        this.input = input;
    }

    public String[] split(){
        if(input.startsWith("//")){
            return splitByCustomExtracter();
        }
        else{
            return splitByDefaultExtracter();
        }
    }

    private String[] splitByCustomExtracter(){
        String delimiter = input.substring(2,input.indexOf("\\n"));
        String numberPart=input.substring(input.indexOf("\\n")+2);
        return numberPart.split(delimiter);
    }

    private String[] splitByDefaultExtracter(){
        return input.split(",|:");
    }
}
