package calculator;

public class stringCal {

    public static String reverseStr(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    public String numCal(String first, String second){
        int carry = 0;
        String result ="";
        //각 자리수 비교하기 위해 min, max로 비교
        int min_val = Integer.min(first.length(), second.length());
        int max_val = Integer.max(first.length(), second.length());
        //index 뒤집기(일의 자리수부터 합하기 위함)
        first = reverseStr(first); second = reverseStr(second);
        //겹치는 자리수들끼리 더하고 carry 저장하기
        for(int i = 0; i < min_val; i++){
            int first_int = Character.getNumericValue(first.charAt(i));
            int second_int = Character.getNumericValue(second.charAt(i));
            int temp = carry + first_int + second_int;
            carry = temp / 10;
            temp = temp % 10;
            result = result + temp;
        }

        //자리수가 같다면 carry 더하고 리턴
        if(min_val == max_val){
            if(carry != 0) result += carry;
            return reverseStr(result);
        }
        //second가 first보다 자릿수가 더 높은 경우
        if(first.length() < second.length()){
            for(int i = first.length(); i < second.length(); i++){
                int temp = carry + Character.getNumericValue(second.charAt(i));
                carry = temp / 10;
                temp = temp % 10;
                result = result + temp;
            }

        }
        //first가 second보다 자릿수가 더 높은 경우
        else{
            for(int i = second.length(); i < first.length(); i++){
                int temp = carry + Character.getNumericValue(first.charAt(i));
                carry = temp / 10;
                temp = temp % 10;
                result = result + temp;
            }
        }
        if(carry != 0) result += carry;

        return reverseStr(result);
    }
}