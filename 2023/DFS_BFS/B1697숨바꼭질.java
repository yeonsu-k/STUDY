import java.io.*;
import java.util.*;

public class B1697숨바꼭질 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    System.out.print(N == K ? 0 : BFS(N, K));
  }

  private static int BFS(int n, int k) {
    Queue<Integer> que = new LinkedList<>();
    int[] result = new int[100001];
    que.add(n);
    result[n] = 1;

    while (!que.isEmpty()) {
      int pos = que.poll();
      for (int nx : new int[] { pos - 1, pos + 1, pos * 2 }) {
        if (nx < 0 || nx > 100000 || result[nx] != 0)
          continue;
        if (nx == k)
          return result[pos];

        result[nx] = result[pos] + 1;
        que.add(nx);
      }
    }

    return result[k];
  }
}
