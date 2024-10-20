# java-calculator-precourse

## 기능목록
- [o] 사용자로부터 문자열을 입력받는다.
- [o] 사용자로부터 입력받은 문자열에서 커스텀 구분자를 사용하는지 판단한다.
  - [o] 첫 문자가 숫자면 ,또는 ;를 구분자로 한다.
  - [o] 첫 문자가 숫자가 아니면 //와 \n 사이에 있는 커스텀 구분자를 구분자로 한다.
    - [o] 커스텀 구분자를 //와 \n를 사용해서 입력하지 않았으면 IllegalArgumentException을 발생시킨다.
  - [o] 구분자를 통해서 문자열을 분할한다.
- [o] 분할된 문자열을 숫자로 변환한다.
  - [o] 구분자를 통해서 분리한 값이 숫자가 아니면 IllegalArgumentException을 발생시킨다.
  - [o] 구분자를 통해서 분리한 값이 비어있으면 IllegalArgumentException을 발생시킨다.
  - [o] 사용자로부터 입력 받은 숫자값이 양수가 아니면 IllegalArgumentException을 발생시킨다.
- [] 추출한 숫자들을 더한다.
- [] 결과값을 출력한다.