# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

### 프로그램 동작 순서

1. 체스 게임 시작 문구를 출력한다
2. 사용자는 start 명령을 입력한다
3. 초기화된 체스판을 출력한다
4. 게임을 진행한다
   4-1. 사용자는 move 명령으로 체스말을 이동시킬 수 있다
   4-2. 변화된 체스판을 출력한다
5. 사용자는 end 명령을 입력한다
6. 게임을 종료한 

### 기능 목록 구현
- [x] 위치
    - [x] file(열)과 rank(행)를 갖는다
- [ ] 방향
  - [ ] 상하좌우, 대각선, 나이트의 단위 이동 방향을 갖는다
  - [ ] 단위 이동 방향을 구할 수 있다
- [x] 체스말
    - [x] 이름을 갖는다
    - [x] 체스말은 Rook, Knight, Bishop, King, Queen, Pawn을 갖는다
    - [x] 체스말이 없는 곳은 Empty를 갖는다.
    - [ ] 비숍
      - [ ] 대각선으로 이동할 수 있다
    - [ ] 킹
      - [ ] 모든 방향으로 한 칸만 이동할 수 있다
    - [ ] 나이트
      - [ ] 상하좌우 한 칸 후 대각선 한 칸만 이동할 수 있다
    - [ ] 폰
      - [ ] 앞으로 한 칸만 이동할 수 있다
      - [ ] 처음 이동 시 두칸 이동할 수 있다
    - [ ] 퀸
      - [ ] 모든 방향으로 이동할 수 있다
    - [ ] 룩
      - [ ] 상하좌우로 이동할 수 있다
- [x] 체스판
    - [x] 위치와 체스말을 갖는다
    - [ ] 체스말을 이동시킬 수 있다
      - [ ] 출발지에 체스말이 존재하는지 확인한다
      - [ ] 체스말의 이동 방향을 구한다
      - [ ] 경로에 체스말이 있는지 확인한다
      - [ ] 체스말이 이동할 수 있는지 확인한다
      - [ ] 체스말의 위치를 변경한다
- [x] 체스판 청사진
    - [x] 체스판을 빈 공간으로 채운다
    - [x] 체스판에 검은말을 채운다
    - [x] 체스판에 흰말을 채운다
- [x] 커맨드
  - [x] 커맨드 목록은 start, end, move가 있다 
  - [x] 커맨드가 start, end, move인지 확인한다
    - [x] move일 경우 `move 출발지 도착지` 형식인지 확인한다
- [x] 뷰
  - [x] 입력
    - [x] 사용자는 명령어를 입력한다(start, end, move)
  - [x] 출력
    - [x] 초기화된 체스판을 출력한다
