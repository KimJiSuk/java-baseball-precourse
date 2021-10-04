# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* Model 작성 및 유닛 테스트 작성
  * 숫자 생성 - 1부터 9까지 다른 수로 이루어진 3자리 숫자
  * 숫자 판별 - 낫싱부터 3스트라이크까지 판별
* View 작성
  * 숫자 입력 받기
  * 결과 출력
  * 새게임 and 종료 입력 받기
* BallCount DTO 작성
  * 볼 카운트 DTO
  * Controller - Model
* Controller 작성 및 Service 작성
  * 게임 종료 & 게임 재시작 
  * 잘못된 입력 Check 로직 추가
* 기타 Refactoring
  * indent depth 1이하 유지
  * else 사용하지 않기
  * 모든 케이스 테스트 추가