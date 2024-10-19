package calculator.option;

public interface Calculator {

    String[] validate();
    //구분자로 분리 된 문자열 배열에서 합을 구한다.
    default int sum(String[] arr){
        int sum = 0;
        for (String s : arr) {
            int num = Integer.parseInt(s);
            sum += num;
        }
        return sum;
    }

    default int getSum(){
        return sum(validate());
    }

}
