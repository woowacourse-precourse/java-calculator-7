# java-calculator-precourse
### Index별 데이터 검사
1. Method 'calculate1' - 문자열에서 합계를 계산
    * 다른 메서드(isNum, typeChar, extractCustom 등)를 호출하며 계산


2. Method 'inNum' - 특정 인덱스에 해당하는 값의 자료형 판단
    * 숫자인지?
    * 문자인지?


3. Method 'typeChar' - 특정 인덱스에 해당하는 값이 문자일 때 어떤 문자인지
    * 구분자인지?
    * 커스텀 구분자 생성 구문인지?
    * 구분자가 아닌 문자인지?


4. Method 'extractCustom' - 입력받은 문자열에서 커스텀 구분자를 뽑아내는 함수
    * ex) //\*\n1;2*3 --> 커스텀 구분자 : *