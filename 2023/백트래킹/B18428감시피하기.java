import java.io.*;
import java.util.*;

class Pos {
  int x, y;

  Pos(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class B18428감시피하기 {
  static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
  static int N;
  static char[][] mapX, mapY, copyMapX, copyMapY; // 가로형 세로형 맵
  static ArrayList<Pos> gap;
  static String answer = "NO";

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    mapX = new char[N][N];
    mapY = new char[N][N];
    copyMapX = new char[N][N];
    copyMapY = new char[N][N];
    gap = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String str = br.readLine().replace(" ", "");
      if (check(str)) {
        System.out.print(answer);
        return;
      }
      for (int j = 0; j < N; j++) {
        char ch = str.charAt(j);
        mapX[i][j] = ch;
        mapY[j][i] = ch;
        if (ch == 'X')
          gap.add(new Pos(i, j));
      }
    }

    for (int i = 0; i < N; i++) {
      copyMapX[i] = mapX[i].clone();
      copyMapY[i] = mapY[i].clone();
    }

    nCr(0, 0, copyMapX, copyMapY);

    System.out.print(answer);
  }

  private static void nCr(int start, int cnt, char[][] copyMapX, char[][] copyMapY) {
    if (answer.equals("YES"))
      return;
    if (cnt == 3) {
      boolean result = true;
      for (int i = 0; i < N; i++) {
        String strX = String.valueOf(copyMapX[i]).replace("X", "");
        String strY = String.valueOf(copyMapY[i]).replace("X", "");
        result &= !check(strX) & !check(strY); // 감시 성공하면
      }
      if (result) {
        // 모든 감시가 성공하면
        answer = "YES";
        for (int j = 0; j < N; j++) {
          System.out.println(Arrays.toString(copyMapX[j]) + "     " + Arrays.toString(copyMapY[j]));
        }
        System.out.println();
        return;
      }

      return;
    }

    for (int i = start; i < gap.size(); i++) {
      Pos pos = gap.get(i);
      copyMapX[pos.x][pos.y] = 'O';
      copyMapY[pos.y][pos.x] = 'O';

      String strX = String.valueOf(copyMapX[pos.x]).replace("X", "");
      String strY = String.valueOf(copyMapY[pos.y]).replace("X", "");
      if (!check(strX) ^ !check(strY)) {

        copyMapX[pos.x][pos.y] = 'X';
        copyMapY[pos.y][pos.x] = 'X';
        continue;
      }

      nCr(i + 1, cnt + 1, copyMapX, copyMapY);
      copyMapX[pos.x][pos.y] = 'X';
      copyMapY[pos.y][pos.x] = 'X';
    }
  }

  private static boolean check(String str) {
    return str.contains("TS") || str.contains("ST");
  }
}