import java.io.*;
import java.util.*;

/**
 * 구현
 * 브루트포스 알고리즘(완전탐색)
 */

public class B18111마인크래프트B {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int[] arr = new int[257];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[Integer.parseInt(st.nextToken())] += 1;
      }
    }

    int time = Integer.MAX_VALUE;
    int high = 0;
    for (int i = 256; i >= 0; i--) {
      int cost = 0;
      int block = B;

      // 현재 높이 보다 높은 블록 깎기
      for (int j = 256; j > i; j--) {
        cost += 2 * arr[j] * (j - i);
        block += arr[j] * (j - i);
      }

      // 현재 높이 보다 낮은 블록 쌓기
      for (int j = i - 1; j >= 0; j--) {
        cost += arr[j] * (i - j);
        block -= arr[j] * (i - j);
      }

      if (block < 0)
        continue;
      if (time > cost) {
        time = cost;
        high = i;
      }
    }
    System.out.print(time + " " + high);
  }
}
