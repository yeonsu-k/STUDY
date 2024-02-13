import java.io.*;
import java.util.*;

/* 
 * 그리디 알고리즘
 * 정렬
 * 두 포인터
 */

public class B2831댄스파티 {
  static int count = 0;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> boysPlus = new PriorityQueue<Integer>(); // 남자 양수
    PriorityQueue<Integer> boysMinus = new PriorityQueue<Integer>(); // 남자 음수
    PriorityQueue<Integer> girlsPlus = new PriorityQueue<Integer>(); // 여자 양수
    PriorityQueue<Integer> girlsMinus = new PriorityQueue<Integer>(); // 여자 음수

    String[] boys = br.readLine().split(" ");
    String[] girs = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      int boyHeight = Integer.parseInt(boys[i]);
      int girsHeight = Integer.parseInt(girs[i]);

      if (boyHeight > 0)
        boysPlus.add(boyHeight);
      else
        boysMinus.add(-boyHeight);

      if (girsHeight > 0)
        girlsPlus.add(girsHeight);
      else
        girlsMinus.add(-girsHeight);
    }

    mating(boysMinus, girlsPlus); // 남자 > 여자
    mating(girlsMinus, boysPlus); // 여자 > 남자

    System.out.print(count);
  }

  static void mating(Queue<Integer> minus, Queue<Integer> plus) {
    while (!minus.isEmpty() && !plus.isEmpty()) {
      int m = minus.poll(); // minus > plus
      int p = plus.peek();
      if (m > p) {
        plus.poll();
        count++;
      }
    }
  }
}
