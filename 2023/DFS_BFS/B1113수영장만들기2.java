import java.io.*;
import java.util.*;

public class B1113수영장만들기2 {
  static int[] dy = { -1, 0, 1, 0 }; // 상,우,하,좌
  static int[] dx = { 0, 1, 0, -1 };
  static int N, M, map[][];

  static class Pos {
    int y, x;

    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N + 2][M + 2];
    int max = 1; // 수영장 최대 높이

    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = str.charAt(j - 1) - '0';
        max = Math.max(max, map[i][j]);
      }
    }

    int result = 0;
    for (int poolNum = 2; poolNum <= max; poolNum++) {
      bfs(poolNum);
      for (int y = 1; y <= N; y++) {
        for (int x = 1; x <= M; x++) {
          if (map[y][x] < poolNum) {
            map[y][x]++; // 물을 1만큼 채워줌
            result++;
          }
        }
      }
    }

    System.out.println(result);
  }

  private static void bfs(int poolNum) {
    Queue<Pos> que = new LinkedList<>();
    map[0][0] = poolNum;
    que.add(new Pos(0, 0));

    while (!que.isEmpty()) {
      Pos pos = que.poll();
      for (int d = 0; d < 4; d++) {
        int ny = pos.y + dy[d];
        int nx = pos.x + dx[d];

        if (ny < 0 || nx < 0 || ny >= N + 2 || nx >= M + 2)
          continue;

        if (map[ny][nx] < poolNum) {
          map[ny][nx] = poolNum;
          que.add(new Pos(ny, nx));
        }
      }
    }

  }

}