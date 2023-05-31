import java.io.*;
import java.util.*;

class B18428감시피하기 {
  static class Pos {
    int x, y;

    Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int N;
  static char[][] map;
  static ArrayList<Pos> per;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    per = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String str = br.readLine().replace(" ", "");
      if (check(str)) {
        System.out.print("NO");
        return;
      }
      for (int j = 0; j < N; j++) {
        char ch = str.charAt(j);
        map[i][j] = ch;
        if (ch == 'X')
          per.add(new Pos(i, j));
      }
    }

    nCr(0, 0);

    System.out.print("NO");
  }

  private static void nCr(int start, int cnt) {
    if (cnt == 3) {
      char[][] copyMap = new char[N][N];
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          copyMap[j][k] = map[k][j];
        }
      }

      boolean result = true;
      for (int i = 0; i < N; i++) {
        String strX = String.valueOf(map[i]).replace("X", "");
        String strY = String.valueOf(copyMap[i]).replace("X", "");
        result &= !check(strX) & !check(strY);
      }

      if (result) {
        System.out.println("YES");
        System.exit(0);
      }

      return;
    }

    for (int i = start; i < per.size(); i++) {
      Pos pos = per.get(i);
      map[pos.x][pos.y] = 'O';
      nCr(i + 1, cnt + 1);
      map[pos.x][pos.y] = 'X';
    }
  }

  private static boolean check(String str) {
    return str.contains("TS") || str.contains("ST");
  }

}