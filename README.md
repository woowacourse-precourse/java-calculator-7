# java-calculator-precourse

## 실행 흐름

1. 문자열을 입력받는다.
2. 구분자의 유효성을 검증한다.
3. 구분자를 제외한 숫자들의 합을 출력한다.

## 기능 목록

- 문자열을 입력받는 기능
- 유효한 구분자를 판별하는 기능
- 커스텀 구분자를 추출하는 기능
- 숫자들의 합을 구하는 기능
- 출력하는 기능

## class 정보

### extract

- Extract : 추출 구분자 정보를 담는 class
- ExtractRepository : Extract를 list로 저장하고 관리하는 class
- ExtractSeparator : 허용되는 추출 구분자를 설정하는 enum
- ExtractService : inputText에서 ExtractRepository를 이용하여
  커스텀 구분자를 추출하는 service class

### separator

- Separator : 일반 구분자 정보를 담는 class
- SeparatorRepository : Separator를 list로 저장하고 관리하는 class
- FixedSeparator : 기본적으로 허용되는 구분자를 설정하는 enum
- SeparatorService : 구분자 정보를 받아 유효한 구분자인지 판별하고,
  새로운 커스텀 구분자를 받아와 저장시키는 service class

### view

- Input : 문자열을 입력받는 class
- Output : 출력하는 class


- calculator : 숫자들의 합을 저장하는 기능
- controller : service class들을 모아 문자열 덧셈 계산기 시스템을 구축한다.

