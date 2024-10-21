package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//리스트를 저장하기 위한 클래스
class ListNode {
    //시작 인덱스 저장 리스트
    List<Integer> startDTIndexList;
    //시작 인덱스 저장 리스트
    List<Integer> endDTIndexList;

    public ListNode(List<Integer> startDTIndexList, List<Integer> endDTIndexList) {
        this.startDTIndexList = startDTIndexList;
        this.endDTIndexList = endDTIndexList;
    }
}

public class Calculator {
    //입력받은 데이터
    private String inputData;
    //구분자 리스트
    private List<String> dTList;

    public Calculator() {}
    public Calculator(String inputData) {
        this.inputData = inputData;
        this.dTList = new ArrayList<>(Arrays.asList(",", ":"));
    }

    private String updateDTListAndReturnStr(String inputData) {
        // 인덱스를 가진 list를 통해 구분자의 시작 인덱스 + 끝 인덱스를 파악
        ListNode node = findCustomDTIdx(inputData);
        List<Integer> startIdxList = node.startDTIndexList;
        List<Integer> endIdxList = node.endDTIndexList;

        // substring을 통해 시작 인덱스에서 끝 인덱스 + 1까지 str을 구하기 -> 구분자 가져오기
        if (startIdxList.size() == endIdxList.size()) {
            int size = node.startDTIndexList.size();
            for (int i = 0; i < size; i++) {
                if (startIdxList.get(i) <= endIdxList.get(i)) {
                    dTList.add(inputData.substring(startIdxList.get(i), endIdxList.get(i) + 1));
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        // 이제 '//'과 '\n' -> ""으로 변경 후 return
        for(int i = 0; i < inputData.length() - 1; i++) {
            if(inputData.charAt(i) == '/' && inputData.charAt(i + 1) == '/' || inputData.charAt(i) == '\\' && inputData.charAt(i + 1) == 'n') {
                inputData = inputData.substring(0, i) + inputData.substring(i + 2);
                i--;
            }
        }

        return inputData;
    }

    private ListNode findCustomDTIdx(String inputData) {
        //시작 인덱스를 저장할 리스트
        List<Integer> startDTIdxList = new ArrayList<>();
        //끝 인덱스를 저장할 리스트
        List<Integer> endDTIdxList = new ArrayList<>();

        //조건을 통해 알맞은 리스트에 값 저장
        for (int i = 0; i < inputData.length() - 1; i++) {
            if (inputData.charAt(i) == '/' && inputData.charAt(i + 1) == '/') {
                startDTIdxList.add(i + 2);
                i++;
            } else if (inputData.charAt(i) == '\\' && inputData.charAt(i + 1) == 'n') {
                endDTIdxList.add(i - 1);
                i++;
            }
        }

        //ListNode 형식으로 return
        return new ListNode(startDTIdxList, endDTIdxList);
    }
}