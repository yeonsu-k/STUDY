import java.io.*;
import java.util.*;

public class B2805나무자르기 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] trees = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(trees);

    int low = 0, high = trees[N - 1];
    while (low <= high) {
      int mid = (low + high) / 2;
      long sum = 0;
      for (int i = trees.length - 1; i >= 0; i--) {
        if (mid > trees[i])
          break;
        sum += (trees[i] - mid);
      }
      if (sum >= M) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    System.out.println(high);
  }

}
