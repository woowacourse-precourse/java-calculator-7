package calculator.delimiterstorage;

import java.util.HashSet;

public class DelimiterStorageServiceImpl implements DelimiterStorageService {
    private HashSet<Character> delimiters= new HashSet<Character>();



    public DelimiterStorageServiceImpl() {
        delimiters.add(':');
        delimiters.add(',');
    }
    @Override
    public HashSet<Character> getDelimiters() {
        return delimiters;
    }

    @Override
    public void delimeterStore(String s) {
        if (s.length()<=5){
            return;
        }

        if (s.startsWith("//") ){
            int n=-1;
            for (int i=0;i<s.length();i++){
                if (s.charAt(i)=='n' && s.charAt(i-1)==92){
                    n=i;
                    break;
                }
            }

            if (n ==-1 ){
                throw  new IllegalArgumentException("잘못된 문자열입니다");
            }
            for (int i=2;i<n-1;i++){
                delimiters.add(s.charAt(i));
            }

        }

    }
}
