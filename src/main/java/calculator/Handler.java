package calculator;

public class Handler {
    public int[] inputHandler(String input) {
        if(indicateCustom(input)) {
            String custom = makeCustomSeperator(input);
            return splitter(input, custom);
        }else{
            return splitter(input);
        }
    }

    private boolean indicateCustom(String input) {
        if(input.contains("//") || input.contains("\n")) {
            return true;
        } else {
            return false;
        }
    }

    private String makeCustomSeperator(String input) {
        String custom = input.substring(2, input.indexOf("\\"));
        return custom;
    }

    private int[] splitter(String input){
        String[] initialSplit = input.split("[,:]");
        int[] result = new int[initialSplit.length];
        for(int i = 0; i < initialSplit.length; i++){
            result[i] = Integer.parseInt(initialSplit[i]);
        }
        return result;
    }

    private int[] splitter(String input, String custom) {
        String[] initialSplit = input.split(",|:|"+custom);
        int[] result = new int[initialSplit.length];
        for(int i = 0; i < initialSplit.length; i++){
            result[i] = Integer.parseInt(initialSplit[i]);
        }
        return result;
    }

    //   //%\\n 가 들어있는지 확인해야함.
    // 확인되면 빼내야함.
    // 없다면 " //&1,2,3&5" 가 들어왔다고 치면
    // 자르면 //&1 | 2 | 3&5

}
