import java.io.*;
import java.util.*;

public class B11660구간합구하기5 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N + 1][N + 1];

    // 누적합
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      int sum = 0;
      for (int j = 1; j <= N; j++) {
        sum += Integer.parseInt(st.nextToken());
        map[i][j] = sum;
      }
    }

    // for (int[] m : map) {
    // System.out.println(Arrays.toString(m));
    // }

    // 구간합
    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = 0;
      for (int x = x1; x <= x2; x++) {
        sum += map[x][y2] - map[x][y1 - 1];
      }

      sb.append(sum).append('\n');
    }

    System.out.print(sb.toString().trim());
  }
}
