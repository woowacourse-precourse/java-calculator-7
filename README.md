# java-calculator-precourse

## 구현 기능 목록

### 계산기 기능

- 입출력 기능
- 구분자 추가 <br>
  ~~입력 전처리~~ 추후 작업하면서 통합됨
- 에러던지기 및 처리
- 통합 수행 함수
- 덧셈 수행

### 요구사항 외 내가 추가로 제한한 기능

- "//;\n//^\n1;2^3" 과 같은 형식으로 복수 개의 구분자 지정 가능
- 커스텀 구분자는 기본 구분자에 추가되는 형식임(기본 구분자도 동작을 같이 함)
- 커스텀 구분자는 단일 특수 문자이여야 함( '-' 제외)
- 구분자로 끝나는 경우 에러 발생시킴
- 숫자는 Int 범위 내에서만 가능

## 함수 간단 설명

### 1. getter 및 setter

getter는 모두 존재, setter는 추후 입력을 제한할 가능성을 생각해서 input만 만듦.

### 2. private String addSeparator(String str)

입력에서 커스텀 구분자를 구분해서 내부 구분자 리스트에 추가하는 함수

### 3. private int parseAndAdd(String number)

stack 에 들어있는 숫자들을 더해주는 함수.

### 4. public void manageAdd(String input)

함수들을 통해서 모든 과정이 진행되는 함수. <br>
입력 전처리가 stack을 사용하면서 여기에 통합되었다.