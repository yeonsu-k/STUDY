import java.io.*;
import java.util.*;

public class B1113수영장만들기1 {
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
    map = new int[N][M];

    int min = 9; // 수영장 최소 높이
    int max = 1; // 수영장 최대 높이

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j) - '0';
        min = Math.min(min, map[i][j]);
        max = Math.max(max, map[i][j]);
      }
    }

    int result = 0;
    for (int poolNum = min; poolNum < max; poolNum++) {
      for (int y = 1; y < N - 1; y++) {
        for (int x = 1; x < M - 1; x++) {
          if (map[y][x] <= poolNum)
            result += bfs(y, x, poolNum); // 시작 지점, 수영장 높이
        }
      }
    }

    System.out.println(result);
  }

  private static int bfs(int y, int x, int poolNum) {
    Queue<Pos> que = new LinkedList<>();
    que.add(new Pos(y, x));
    map[y][x]++;
    int cnt = 1;
    boolean check = true;

    while (!que.isEmpty()) {
      Pos pos = que.poll();
      for (int d = 0; d < 4; d++) {
        int ny = pos.y + dy[d];
        int nx = pos.x + dx[d];

        if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
          check = false;
          continue;
        }

        if (map[ny][nx] <= poolNum) {
          map[ny][nx]++; // 물을 1만큼 채워줌
          cnt++;
          que.add(new Pos(ny, nx));
        }
      }
    }

    return check ? cnt : 0;
  }

}