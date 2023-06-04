import java.io.*;
import java.util.*;

// 우선순위 큐

public class B1966프린터큐 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[] arr = new int[N];
      boolean[] p = new boolean[N];
      PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        que.add(arr[i]);
      }

      int cnt = 0, i = -1;
      while (true) {
        i = (i + 1) % N;
        if (p[i])
          continue;
        int max = que.peek();
        if (arr[i] == max) {
          p[i] = true;
          que.poll();
          cnt++;
          if (i == M)
            break;
        }
      }
      sb.append(cnt).append('\n');
    }
    System.out.print(sb);
  }
}
