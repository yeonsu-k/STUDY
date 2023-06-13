import java.io.*;
import java.util.*;

public class B1027고층건물 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int arr[] = new int[N];
    int cnt[] = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      double max = Integer.MIN_VALUE;
      for (int j = i + 1; j < N; j++) {
        int x = j - i; // x증가량
        int y = arr[j] - arr[i]; // y증가량
        double s = (double) y / x;
        if (max < s) {
          max = s;
          cnt[i]++;
          cnt[j]++;
        }
      }
    }

    Arrays.sort(cnt);

    // for (int i : cnt) {
    // System.out.print(i + " ");
    // }

    System.out.print(cnt[N - 1]);
  }
}
