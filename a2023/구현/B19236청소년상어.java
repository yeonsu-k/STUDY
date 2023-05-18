import java.io.*;
import java.util.*;

public class B19236청소년상어 {
  static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
  static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
  static int N, map[][], result = 0;
  static Fish[] fish;

  static class Fish {
    int x, y, dir;
    boolean isAlive;

    Fish(int x, int y, int dir, boolean isAlive) {
      this.x = x;
      this.y = y;
      this.dir = dir;
      this.isAlive = isAlive;
    }
  }

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = 4;
    map = new int[N][N];
    fish = new Fish[N * N + 1]; // 물고기 번호 1~16

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        int num = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken()) - 1; // 방향 1~8으로 입력 받아지므로 -1해서 0~7로 맞춰줌
        fish[num] = new Fish(i, j, dir, true);
        map[i][j] = num;
      }
    }

    int sx = 0, sy = 0; // 상어의 위치
    int sd = fish[map[0][0]].dir; // 초기 상어의 방향
    int eatSum = map[0][0]; // 먹은 물고기 번호 합 저장 변수 -> (0, 0) 물고기 먹음
    fish[map[0][0]].isAlive = false; // (0, 0) 물고기 죽음
    map[0][0] = -1; // 상어가 있는 위치 -1

    dfs(sx, sy, sd, eatSum);

    System.out.println(result);
  }

  private static void dfs(int sx, int sy, int sd, int eatSum) {
    result = Math.max(result, eatSum);

    // 지도와 물고기 배열 복사
    int[][] copyMap = new int[N][N];
    for (int i = 0; i < map.length; i++) {
      copyMap[i] = map[i].clone();
    }
    Fish[] copyFish = new Fish[fish.length];
    for (int i = 1; i < fish.length; i++) {
      copyFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].dir, fish[i].isAlive);
    }

    // 물고기 움직임
    fishMove();

    // 상어이동
    for (int i = 1; i < 4; i++) {
      int nx = sx + dx[sd] * i;
      int ny = sy + dy[sd] * i;

      // 경계를 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우
      if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
        int eatFishNum = map[nx][ny];
        int nd = fish[eatFishNum].dir;
        map[sx][sy] = 0; // 기존 상어의 위치는 이동했으므로 0
        map[nx][ny] = -1; // 상어가 이동한 위치는 -1
        fish[eatFishNum].isAlive = false; // 상어가 잡아 먹은 물고기 죽음

        dfs(nx, ny, nd, eatSum + eatFishNum);

        fish[eatFishNum].isAlive = true; // 물고기 상태, 상어의 위치 원래대로 되돌리기
        map[sx][sy] = -1;
        map[nx][ny] = eatFishNum;
      }
    }

    // 맵 상태, 물고기 정보 되돌리기
    for (int j = 0; j < map.length; j++) {
      map[j] = copyMap[j].clone();
      // System.arraycopy(copyMap[j], 0, map[j], 0, map.length);
    }
    for (int i = 1; i <= 16; i++) {
      fish[i] = new Fish(copyFish[i].x, copyFish[i].y, copyFish[i].dir, copyFish[i].isAlive);
    }
  }

  private static void fishMove() {
    for (int i = 1; i <= 16; i++) {
      if (!fish[i].isAlive)
        continue; // 이미 죽은 물고기는 패스

      int x = fish[i].x;
      int y = fish[i].y;

      for (int d = 0; d < 8; d++) {
        int nextDir = (fish[i].dir + d) % 8;
        int nx = x + dx[nextDir];
        int ny = y + dy[nextDir];

        if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) { // 이동할 수 있다면
          if (map[nx][ny] == 0) { // 이동할 위치가 빈칸일 경우
            map[x][y] = 0;
            fish[i].x = nx;
            fish[i].y = ny;
          } else { // 바꿀 물고기가 있을경우
            int temp = map[nx][ny]; // 바꿀 물고기 번호
            // 현재 물고기 위치 변경
            fish[i].x = nx;
            fish[i].y = ny;

            map[x][y] = temp;
            fish[temp].x = x;
            fish[temp].y = y;
          }
          map[nx][ny] = i;
          fish[i].dir = nextDir;
          break; // 물고기 위치를 바꿨다면 방향을 더 이상 바꾸지 말고 다음 물고기로
        }
      }
    }
  }
}