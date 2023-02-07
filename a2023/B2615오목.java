import java.io.*;
import java.util.*;

public class B2615오목 {
  static int[] dy = { -1, 0, 1, 1 }; // ↗, →,↘, ↓
  static int[] dx = { 1, 1, 1, 0 };
  static int[][] map;
  static Stack<Pos> doll = new Stack<>();
  static int cnt;
  static StringBuilder sb = new StringBuilder();

  static class Pos {
    int x, y, color;
    Pos(int y, int x, int color) {
      this.y = y;
      this.x = x;
      this.color = color;
    }
  }

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    map = new int[19][19];
    for (int i = 0; i < 19; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < 19; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0)
          doll.add(new Pos(i, j, map[i][j]));
      }
    }

    omock();
    System.out.print(sb.length() == 0 ? 0 : sb);
    br.close();
  }

  private static void omock() {
    while (!doll.empty()) {
      Pos p = doll.pop();
      for (int i = 0; i < 4; i++) {
        cnt = 1;
        int x = p.x, y = p.y;
        while (true) {
          int ny = y + dy[i];
          int nx = x + dx[i];
          if (ny < 0 || nx >= 19 || ny >= 19 || p.color != map[ny][nx]) break;
          y = ny;
          x = nx;
          cnt++;
        }
        if (cnt == 5) {
          int ny = p.y - dy[i];
          int nx = p.x - dx[i];
          if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && p.color == map[ny][nx]) break;
          sb.append(p.color + "\n").append((p.y + 1) + " " + (p.x + 1));
        }
      }
    }
  }
}
