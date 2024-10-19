# java-calculator-precourse


## 🎯목표: 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현
## 미션 조건,이해
- 입력: 구분자와 양수로 구성된 문자열. int타입의 양수, 구분자 이렇게 2가지 타입만 처리하면 된다.
- 입력형식: 입력문자 갯수, "int와 구분자 조합"
- 구분자: 기본 ','와 ':' 이 있고, 커스텀 추가 가능
- 커스텀 구분자: //""\n 형식을 1가지 커스텀 구분자로 인식한다. 그리고 커스텀 구분자는 여러개가 될 수 있게 한다. 
    - 커스텀 구분자를 ArrayList로 저장하고 사용하자.
- docs 폴더를 만들고 새로 README.md를 만들까 고민중.

## 🚀기능구현 목록
- [X] V. class 생성및 필드 선언
    - class Application -> Main
    - class IOManager -> input, output 처리
    - class Calculation -> 데이터 연산 처리
        - 필드로 ArrayList 타입의 숫자,구분자 만들기
- [X] A. IOManager의 함수 
    - [X] 1. 문자열 입력받기
    - [X] 2. 결과 출력하기
- [X] B. Calculation의 함수
    - [X] 0. getter, setter
    - [X] 1. 입력 받은 문자열 분석하고 필드에 저장하기
    - [X] 2. 필드 데이터 연산하고, 결과값 리턴하기


#### 아이콘: 📮✏️🎯