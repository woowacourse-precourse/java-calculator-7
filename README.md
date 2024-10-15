# 프리코스 미션 1. 문자열 덧셈 계산기

---

## 구현 기능 목록

### 1. 유저에게 문자열을 입력받음
### 2. 입력한 문자열에서 숫자를 추출하여 덧셈 계산
- 입력 값이 없으면 결과 값을 0으로 처리
- 문자열 앞에 커스텀 구분자 있는지 확인
    -  “//”와 “\n”이 둘 다 있는지 확인
        - 둘 다 있는 경우
            1. 커스텀 구분자 저장
                - 커스텀 구분자 사이에 문자열이 없는 경우
            2. 구분자를 기준으로 숫자 추출
            3. 추출한 숫자들의 합 계산
        - 둘 중에 하나라도 없는 경우
            - 잘못된 값 입력 처리
  - 쉼표(,) 또는 콜론(:) 구분자가 있는지 확인
    - 둘 중 하나라도 있을 경우
      - 구분자를 기준으로 숫자 추출
      - 추출한 숫자들의 합 계산
- 입력 값에 숫자만 있으면 입력한 값을 그대로 출력
  - 유저의 잘못된 입력 값 유무 확인
    * IllegalArgumentException 발생시키고 종료
      - 입력 값에 숫자가 없는 경우
      - 커스텀 구분자 지정자가 완벽하지 않을 경우
      - 유저가 입력한 문자열 중간에서 커스텀을 시도할 경우
      - 구분자가 아닌 알 수 없는 문자열이 입력된 경우
### 3. 결과 출력