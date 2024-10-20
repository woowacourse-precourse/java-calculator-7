package calculator.api;

public class Calculation {
    private Double sum;

    public Calculation(){
        this.sum=0.0;
    }

    public Double calculationString(String separator, String input){

        if(!separator.equals("[,;]")){
            int i = input.indexOf("\\");
            input = input.substring(i+2);
        }

        String[] split = input.split(separator);

        try{
            for(String temp : split){
                sum+=Double.parseDouble(temp);
            }
        } catch(NumberFormatException err){
            throw new IllegalArgumentException();
        }
        return sum;
    }
}
