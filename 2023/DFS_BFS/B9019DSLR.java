import java.io.*;
import java.util.*;

public class B9019DSLR {
  static String result;

  static class DSLR {
    String type;
    int num;

    DSLR(String t, int n) {
      this.type = t;
      this.num = n;
    }
  }

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      result = "";
      BFS(A, B);
      sb.append(result).append('\n');
    }

    System.out.print(sb);
  }

  private static void BFS(int a, int b) {
    Queue<DSLR> que = new LinkedList<>();
    boolean[] visited = new boolean[10000]; // BFS 탐색의 방문 여부 체크
    que.add(new DSLR("", a));
    visited[a] = true;

    while (!que.isEmpty()) {
      DSLR now = que.poll();
      for (DSLR nx : calcN(now.num)) {
        if (visited[nx.num])
          continue;
        if (b == nx.num) {
          result = now.type + nx.type;
          return;
        }
        visited[nx.num] = true;
        que.add(new DSLR(now.type + nx.type, nx.num));
      }
    }
  }

  private static DSLR[] calcN(int now) {
    int D = (2 * now) % 10000;
    int S = (now == 0) ? 9999 : now - 1;
    int L = (now % 1000) * 10 + now / 1000;
    int R = (now % 10) * 1000 + now / 10;
    return new DSLR[] {
        new DSLR("D", D),
        new DSLR("S", S),
        new DSLR("L", L),
        new DSLR("R", R)
    };
  }
}
