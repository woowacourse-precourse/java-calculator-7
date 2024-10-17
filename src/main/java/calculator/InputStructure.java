package calculator;

public class InputStructure {
    private Character customSeparator = null;
    private String formulaString = "";

    public InputStructure(String str){
        if(str.startsWith("//")){
            int idx = str.indexOf("\\n");
            if(idx != 2 && idx != 3){
                throw new IllegalArgumentException();
            }
            this.formulaString = str.substring(idx+2);
            if(idx==3) this.customSeparator = str.charAt(2);
        } else{
            this.formulaString = str;
        }
    }

    public String getFormulaString(){
        return formulaString;
    }

    public Character getCustomSeparator(){
        return customSeparator;
    }

}
