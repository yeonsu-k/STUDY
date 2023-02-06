package 순조부;
import java.io.*;
import java.util.*;

// 조합
public class B15650N과M_2 {
  static int N, M;
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("index.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[M];

    nCr(0, 0);

    System.out.println(sb);
  }

  private static void nCr(int start, int cnt) {
    if (cnt == M) {
      for (int n : numbers) sb.append(n).append(' ');
      sb.append('\n');
      return;
    }
    for (int i = start; i < N; i++) {
      numbers[cnt] = i + 1;
      nCr(i + 1, cnt + 1);
    }
  }
}
