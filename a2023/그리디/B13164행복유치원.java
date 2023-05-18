import java.io.*;
import java.util.*;

public class B13164행복유치원 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];
    int[] diff = new int[N - 1];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (i != 0)
        diff[i - 1] = arr[i] - arr[i - 1];
    }
    Arrays.sort(diff);

    int result = 0;
    for (int i = 0; i < N - K; i++) {
      result += diff[i];
    }

    System.out.println(result);
  }
}
