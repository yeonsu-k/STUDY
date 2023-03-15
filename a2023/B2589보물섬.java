import java.io.*;
import java.util.*;

public class B2589보물섬 {
  static int[] dy = { -1, 0, 1, 0 }, dx = { 0, 1, 0, -1 };
  static int N, M, result = 0;
  static char[][] map;

  static class Pos {
    int y, x, time;

    Pos(int y, int x, int time) {
      this.y = y;
      this.x = x;
      this.time = time;
    }
  }

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'L')
          result = Math.max(result, BFS(i, j));
      }
    }

    System.out.println(result);

  }

  private static int BFS(int y, int x) {
    boolean[][] visited = new boolean[N][M];
    Queue<Pos> que = new LinkedList<>();
    int time = 0;

    que.add(new Pos(y, x, 0));
    visited[y][x] = true;

    while (que.size() != 0) {
      Pos pos = que.poll();

      for (int i = 0; i < 4; i++) {
        int ny = pos.y + dy[i];
        int nx = pos.x + dx[i];
        if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 'L' && !visited[ny][nx]) {
          que.add(new Pos(ny, nx, pos.time + 1));
          visited[ny][nx] = true;
          time = Math.max(time, pos.time + 1);
        }
      }
    }

    return time;
  }

}
