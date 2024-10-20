# java-calculator-precourse

## 기능 구현 목록
1. `CommandReader` -> 사용자의 입력을 의미있는 단위로 읽어들인다.
   1. `DelimiterLine` -> ";", "-", " ", "abc" 등등 주어진 포맷안에 있는 구분자를 저장한다.
   2. `NumbersLine` -> 구분자 이후의 숫자 문자열을 저장한다.
2. `Delimiter` -> 구분자를 바탕으로 NumbersLine을 분리한다.
   1. 문자(1글자) 구분자가 아니라면 예외 처리
3. `NumbersRule` -> int[]가 규칙에 부합하는지 검사한다.
   1. `PositiveNumbersRule` -> int[]가 양수인지 검사한다.
4. `NumberReader` -> `DelimiterLine`, `NumbersLine`를 통해 int[]를 반환한다.
   1. NumbersRule에 부합하지 않는다면 예외처리
5. `MyCalculator` - 실행 결과에 맞게 프로그램을 진행할 수 있어야 한다.
