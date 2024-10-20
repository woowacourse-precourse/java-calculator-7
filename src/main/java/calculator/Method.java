package calculator;

public class Method {

    public String changeString(String input){

        String index= input.substring(2,3);
        input= input.substring(4);
        input=input.replace(index,",");

        return input;
    }

    public String[] changeToArray(String changeInput){
        String [] toArray= changeInput.split(",|;");

        for(int i=0;i<toArray.length;i++){
            if(toArray[i].contains("-")){
                throw new IllegalArgumentException("음수가 포함되어 있습니다.");
            }
        }

        for (int i = 0; i < toArray.length; i++) {
            toArray[i] = toArray[i].replaceAll("[^0-9]", "");
        }

        return toArray;
    }

}
