import java.io.*;
import java.util.*;

public class B3055탈출 {
  static int[] dy = { 0, 1, 0, -1 };
  static int[] dx = { 1, 0, -1, 0 };
  static int R, C, result = 250;
  static char[][] map;
  static Queue<Pos> animal = new LinkedList<>();
  static Queue<Pos> water = new LinkedList<>();

  static class Pos {
    int y, x, time;

    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }

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
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];
    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = str.charAt(j);
        if (map[i][j] == 'S')
          animal.add(new Pos(i, j, 0));
        else if (map[i][j] == '*')
          water.add(new Pos(i, j));
      }
    }

    bfs();
    System.out.print(result == 250 ? "KAKTUS" : result);

  }

  private static void bfs() {
    // 물 이동
    while (!animal.isEmpty()) {
      int size = water.size();
      for (int i = 0; i < size; i++) {
        Pos pos = water.poll();
        for (int d = 0; d < 4; d++) {
          int ny = pos.y + dy[d];
          int nx = pos.x + dx[d];
          if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] == '.') {
            map[ny][nx] = '*';
            water.add(new Pos(ny, nx));
          }
        }
      }

      // 고슴도치 이동
      size = animal.size();
      for (int i = 0; i < size; i++) {
        Pos pos = animal.poll();
        for (int d = 0; d < 4; d++) {
          int ny = pos.y + dy[d];
          int nx = pos.x + dx[d];
          if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
            if (map[ny][nx] == '.') {
              map[ny][nx] = 'S';
              animal.add(new Pos(ny, nx, pos.time + 1));
            } else if (map[ny][nx] == 'D') {
              result = Math.min(result, pos.time + 1);
              return;
            }
          }
        }
      }
    }
  }
}
