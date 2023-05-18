package 순조부;
import java.io.*;
import java.util.*;

// 순열
public class B15649N과M {
  static int N, M;
  static int[] numbers;
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    //System.setIn(new FileInputStream("index.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    numbers = new int[M];
    visit = new boolean[N];

    nPr(0);
    System.out.println(sb);
  }

  private static void nPr(int cnt) {
    if (cnt == M) {
      for (int n: numbers) sb.append(n).append(' ');
      sb.append('\n');
      return;
    }
    for (int i = 0; i < N; i++) {
      if (visit[i]) continue;
      numbers[cnt] = i+1;
      visit[i] = true;
      nPr(cnt + 1);
      visit[i] = false;
    }
  }
}
