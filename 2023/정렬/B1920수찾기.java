import java.io.*;
import java.util.*;

class B1920수찾기 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0)
        sb.append(1);
      else
        sb.append(0);

      sb.append("\n");
    }

    System.out.print(sb.toString().trim());
  }
}
