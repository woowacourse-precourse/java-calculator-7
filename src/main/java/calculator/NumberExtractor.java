package calculator;

import java.util.ArrayList;

public class NumberExtractor {
    public ArrayList<Integer> getArray(String str){
        String delimiter = extractCustomString(str);
        if(delimiter.isEmpty()){
            return extractNumbers(str);
        } else {
            return extractCustomNumbers(str, delimiter);
        }
    }
    private String extractCustomString(String str){
        String[] arr = str.split("");
        String delimiter = "";

        if(arr.length > 1 && arr[0].equals("/") && arr[1].equals("/")) {
            for (int i = 2; i < arr.length - 1; i++) {
                if (arr[i].equals("\\") && arr[i + 1].equals("n")) {
                    break;
                } else {
                    delimiter += arr[i];
                }
            }
        }
        return delimiter;
    }

    private ArrayList<Integer> extractNumbers(String str){
        String [] extractedString = str.split(",|:");
        ArrayList<Integer> result = new ArrayList<>();

        try{
            for(String text : extractedString){
                result.add(Integer.parseInt(text));
            }
        } catch (NumberFormatException e){
            System.out.print("입력이 잘못되었습니다.");
            Application.flag = true;
        }

        return result;
    }
    private ArrayList<Integer> extractCustomNumbers(String str, String delimiter){
        String removedString = removeCustomString(str);

        String [] extractedString = removedString.split(",|:|"+delimiter);
        ArrayList<Integer> result = new ArrayList<>();

        try{
            for(String text : extractedString){
                result.add(Integer.parseInt(text));
            }
        } catch (NumberFormatException e){
            System.out.print("입력이 잘못되었습니다.");
            Application.flag = true;
        }

        return result;
    }

    private String removeCustomString(String str){
        String [] customString = str.split("");
        String result = "";

        for(int i = 0; i < customString.length -1; i++){
            if(customString[i].equals("\\") && customString[i+1].equals("n")){
                for(int j = i+2; j < customString.length; j++){
                    result += customString[j];
                }
            }
        }

        return result;
    }
}
