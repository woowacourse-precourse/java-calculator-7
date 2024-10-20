package calculator;

public class Method {

    public String changeString(String input){
        input= input.substring(4);
        String index= input.substring(2,3);
        input=input.replace(index,",");

        return input;
    }

    public String[] changeToArray(String changeInput){
        String [] toArray= changeInput.split(",|;");

        for (int i = 0; i < toArray.length; i++) {
            toArray[i] = toArray[i].replaceAll("[^0-9]", "");
            if(toArray[i].isEmpty()){
                throw new IllegalArgumentException();
            }
        }

        return toArray;
    }

}
