# 문자열 덧셈 계산기

## 과제 진행 요구 사항

- [x] [문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7)  저장소를 포크하고 클론할 것
- [x] 기능을 구현하기 전  `README.md`에 구현할 기능 목록을 정리할 것
- [ ] 커밋 단위는 앞 단계에서  `README.md`에 정리한 기능 목록 단위일 것
	- 커밋 시 [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)를 준수할 것

## 기능 요구 사항

- [ ] 입력된 문자열에서 커스텀 구분자를 도출하는 기능
	0. String 입력, char 반환
	1. 문자열의 길이가 4 미만일 경우 0을 반환
	2. 왼쪽부터 4의 길이로 자른 문자열이 "//*\n"의 형태일 경우 커스텀 구분자를 반환
	3. 그렇지 않으면, 해당 문자열이 '0'~'9', ',', ':' 외의 문자를 가지는 지 확인
	4. 가질 경우 예외 처리, 그렇지 않으면 0을 반환
- [ ] 구분자를 기준으로 문자열을 Split하는 기능
	0. String, char(커스텀 구분자) 입력, String[] 반환
	1. split 메서드를 활용
- [ ] 문자열을 양수로 파싱하고, 누적합을 계산하는 기능
	0. String[] 입력, long 반환
	1. 입력된 문자열들을 순차적으로 파싱하여 누적합을 계산 (단, 음수는 예외)
	2. 모든 문자열의 파싱에 성공할 경우 누적합을 반환
	3. 그렇지 않으면 예외 처리
- [ ]  입출력하는 기능
	0. 입력값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용