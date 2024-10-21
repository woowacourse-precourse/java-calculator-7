package calculator;

public class ListAdder {

    public int listAdd(int[] list){
        int sum = 0;
        for (int i= 0; i<list.length; i++){
            sum += list[i];
        }
        return sum;
    }
}
