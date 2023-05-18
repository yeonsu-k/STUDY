import java.io.*;
import java.util.*;

public class B13023ABCDE {
  static int N, M;
  static ArrayList<Integer>[] list;
  static boolean[] visit;
  static boolean result = false;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 사람수
    M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

    list = new ArrayList[N];
    for (int i = 0; i < N; i++)
      list[i] = new ArrayList<Integer>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }

    visit = new boolean[N];
    for (int i = 0; i < N; i++) {
      dfs(i, 1);
      if (result)
        break;
    }

    System.out.print(result ? 1 : 0);
  }

  private static void dfs(int start, int cnt) {
    if (cnt == 5) {
      result = true;
      return;
    }

    visit[start] = true;
    for (int next : list[start]) {
      if (!visit[next])
        dfs(next, cnt + 1);
    }
    visit[start] = false;
  }

}
