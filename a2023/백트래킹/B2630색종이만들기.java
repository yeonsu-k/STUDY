import java.io.*;
import java.util.*;

public class B2630색종이만들기 {
  static int N, map[][], white = 0, blue = 0;
  static boolean visit[][];

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    slice(0, 0, N);

    System.out.println(white);
    System.out.println(blue);
  }

  private static void slice(int row, int col, int size) {
    if (colorCheck(row, col, size)) {
      if (map[row][col] == 0) {
        white++;
      } else {
        blue++;
      }
      return;
    }

    int sliceSize = size / 2;

    slice(row, col, sliceSize); // 2사분면
    slice(row, col + sliceSize, sliceSize); // 1사분면
    slice(row + sliceSize, col, sliceSize); // 3사분면
    slice(row + sliceSize, col + sliceSize, sliceSize); // 4사분면
  }

  private static boolean colorCheck(int row, int col, int size) {
    int color = map[row][col];

    for (int i = row; i < row + size; i++) {
      for (int j = col; j < col + size; j++) {
        if (map[i][j] != color) {
          return false;
        }
      }
    }

    return true;
  }

}
