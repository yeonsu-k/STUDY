import java.io.*;
import java.util.*;

class B11866요세푸스문제0 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    ArrayList<Integer> list = new ArrayList<>(N);

    for (int i = 1; i <= N; i++) {
      list.add(i);
    }

    int idx = 0;
    while (!list.isEmpty()) {
      idx = (idx + K - 1) % N;
      sb.append(list.get(idx));
      if (list.size() != 1)
        sb.append(", ");
      list.remove(idx);
      N--;
    }

    System.out.printf("<%s>", sb.toString().trim());
  }
}
