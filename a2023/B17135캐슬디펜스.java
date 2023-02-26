import java.io.*;
import java.util.*;

public class B17135캐슬디펜스 {
  static int N, M, D, result;
  static int[][] map, copyMap;
  static int[] archer;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    copyMap = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        copyMap[i][j] = map[i][j];
      }
    }

    archer = new int[3];
    comb(0, 0);

    System.out.println(result);
  }

  private static void comb(int start, int cnt) {
    if (cnt == 3) {
      for (int i = 0; i < N; i++) {
        map[i] = copyMap[i].clone();
      }
      attack();
      return;
    }
    for (int i = start; i < M; i++) {
      archer[cnt] = i;
      comb(start + 1, cnt + 1);
    }
  }

  private static void attack() {
    int cnt = 0;
    for (int k = 0; k < N; k++) {
      boolean[][] visit = new boolean[N][M];
      for (int temp : archer) {
        int minD = Integer.MAX_VALUE; // 최소거리
        int minY = Integer.MAX_VALUE; // 최소 y좌표
        int minX = Integer.MAX_VALUE; // 최소 x좌표

        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (map[i][j] == 1) {
              int d = Math.abs(i - N) + Math.abs(j - temp); // 거리계산
              if (minD > d) {
                minD = d;
                minY = i;
                minX = j;
              } else if (minD == d) {
                if (minX > j) {
                  minY = i;
                  minX = j;
                }
              }

            }
          }
        }
        // 최소 거리 왼쪽에 있는 적들을 true
        if (minD <= D) {
          visit[minY][minX] = true;
        }
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (visit[i][j]) {
            cnt++;
            map[i][j] = 0;
          }
        }
      }

      // i번째 줄을 i-1번째 줄로 초기화.
      for (int i = N - 1; i >= 1; i--) {
        map[i] = map[i - 1].clone();
      }

      // 성 맨 윗줄을 모두 0으로 초기화.
      for (int i = 0; i < M; i++) {
        map[0][i] = 0;
      }
    }
    result = Math.max(result, cnt);
  }

}
