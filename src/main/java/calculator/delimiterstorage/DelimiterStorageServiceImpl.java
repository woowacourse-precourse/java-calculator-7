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
            int n=s.indexOf(110);

            if (n ==-1 || s.charAt(n-1)!=92){
                throw  new IllegalArgumentException("잘못된 문자열입니다");
            }
            for (int i=2;i<n-1;i++){
                delimiters.add(s.charAt(i));
            }

        }

    }
}
