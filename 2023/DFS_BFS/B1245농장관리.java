import java.io.*;
import java.util.*;

public class B1245농장관리 {
  static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
  static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static boolean check;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0 && !visited[i][j]) {
          check = true;
          DFS(i, j);
          if (check)
            cnt++;
        }
      }
    }

    System.out.print(cnt);
  }

  private static void DFS(int y, int x) {
    visited[y][x] = true;
    for (int i = 0; i < 8; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] != 0) {
        if (map[ny][nx] > map[y][x])
          check = false;
        if (!visited[ny][nx] & map[ny][nx] == map[y][x])
          DFS(ny, nx);
      }
    }
  }
}