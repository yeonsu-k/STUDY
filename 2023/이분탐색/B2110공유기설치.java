import java.io.*;
import java.util.*;

public class B2110공유기설치 {

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");
    int N = Integer.parseInt(str[0]); // 집의 개수
    int C = Integer.parseInt(str[1]); // 공유기 개수
    int[] house = new int[N];

    for (int i = 0; i < N; i++) {
      house[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(house);

    int low = 1, high = house[N - 1] - house[0] + 1;
    while (low < high) {
      int mid = (low + high) / 2;

      int count = 1;
      int backPos = house[0];

      for (int i = 1; i < house.length; i++) {
        if ((house[i] - backPos) >= mid) {
          count++;
          backPos = house[i];
        }
      }

      if (count < C) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }

    System.out.println(low - 1);
  }
}