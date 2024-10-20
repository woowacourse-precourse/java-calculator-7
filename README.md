# java-calculator-precourse
***
# 기능정리
***
## 1. 사용자 입력
사용자로부터 문자열을 입력받는다.

문자열은 숫자를 ',' 또는 ';' 구분자로 분리하여 입력받는다.

## 2. 문자열 분리
split 메서드를 이용하여 ',' 또는 ':' 구분자를 통하여 문자열 분리한다.

분리한 문자들을 ArrayList<String> 인덱스에 추가한다.

## 3. 커스텀 구분자
문자열 앞이 //로 시작하는지 확인한다.
* //로 시작하면 커스텀 구분자를 추출한다.
* //로 시작하지 않으면 넘어간다.

## 4. 문자열을 정수로 변환
분리된 문자를 Interger형으로 변환한다.

변환한 숫자를 ArratList<Integer> 인덱스에 추가한다.

## 5. 덧샘 계산
숫자들을 더한다.

## 6. 예외처리
',' 또는 ';' 외의 구분자를 입력받으면 예외처리한다.

## 7. 결과출력
결과를 출력한다.