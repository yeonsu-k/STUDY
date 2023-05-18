import java.io.*;
import java.util.*;

/**
 * 그래프 이론
 * 그래프 탐색
 * 깊이 우선 탐색
 */
public class B16929TwoDots {
  static int[] dx = { -1, 0, 1, 0 };
  static int[] dy = { 0, 1, 0, -1 };
  static int N, M;
  static char[][] map;
  static boolean visit[][];
  static String result = "No";

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (visit[i][j])
          continue;
        dfs(i, j, map[i][j], 0, -1);
      }
    }

    System.out.print(result);
  }

  private static void dfs(int x, int y, char ch, int cnt, int dir) {
    if (result.equals("Yes"))
      return;
    if (cnt >= 4 && visit[x][y]) {
      result = "Yes";
      return;
    }

    visit[x][y] = true;

    for (int i = 0; i < 4; i++) {
      if (i == dir)
        continue;
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || ny < 0 || nx >= N || ny >= M || ch != map[nx][ny])
        continue;

      dfs(nx, ny, ch, cnt + 1, (i + 2) % 4);
    }
  }
}