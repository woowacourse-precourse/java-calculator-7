# java-calculator-precourse
## 기능 목록
### 1. 시작 문구 출력
````
"덧셈할 문자열을 입력해 주세요."
````
위 문구를 출력한다.
### 2. 덧셈할 문자열 입력 받기
#### (1)사용자가 잘못된 값을 입력 받았는지 파악한다.
입력값을 검증할 땐 다음의 조건을 확인한다.
1. 구분자와 양수로 구성됐는지
#### (2) 커스텀 구분자가 있는지 파악
파악 시엔 다음의 과정을 거친다. 
1. 문자열 앞부분의 "//"와 "\n" 사이에 커스텀 구분자가 있는지 파악
2. 없을 시에 3-1 을 가고, 있을 시엔 3-2 로 간다.
### 3. 문자열을 분리하고 합을 계산한 뒤 반환한다.
#### (1) 커스텀 구분자가 있을 시엔 커스텀 구분자를 기준으로 문자열을 분리한 뒤 각 숫자의 합을 반환한다.
#### (2) 커스텀 구분자가 없을 시엔 쉼표 또는 콜론을 사용하여 분리한 뒤 각 숫자의 합을 반환한다.

### 4. 결과를 사용자에게 표시
#### (1) 결과를 양식에 맞추어 표시한다.
````
결과 : 6
````
