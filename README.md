# java-calculator-precourse

## 커스텀 구분자 판별 
1. 기본적으로 ,과 : 은 구분자
2. 숫자와 ,과 :를 제외한 문자열은 커스텀 구분자인지 판별
3. //과 \n 사이에 들어있는걸 커스텀 구분자로 함.

## Calculator 클래스
1. 파싱된 숫자들을 더하는 기능
2. 음수나 잘못된 값을 입력했을 경우 IllegalArgumentException 반환


## Factor 클래스
1. 정규식 Pattern을 이용해 숫자를 추출한다.