import java.io.*;
import java.util.*;

/**
 * 구현
 * 브루트포스 알고리즘(완전탐색)
 */

public class B18111마인크래프트A {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][M];
    int min = 256;
    int max = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (min > map[i][j])
          min = map[i][j];
        if (max < map[i][j])
          max = map[i][j];
      }
    }

    int time = 99999999;
    int high = 0;
    for (int i = min; i <= max; i++) {
      int count = 0;
      int block = B;

      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          // 현재 땅 높이가 맞출 높이보다 높으면 차이나는 만큼 블록 제거(2초씩)
          if (i < map[j][k]) {
            count += (map[j][k] - i) * 2;
            block += (map[j][k] - i);
            // 낮을 경우 블록은 제거(1초씩)
          } else {
            count += (i - map[j][k]);
            block -= (i - map[j][k]);
          }
        }
      }
      // 블록의 개수가 음수가 되면 반복문 종료
      if (block < 0)
        continue;

      if (time >= count) {
        time = count;
        high = i;
      }
    }
    System.out.printf("%d %d", time, high);
  }
}
