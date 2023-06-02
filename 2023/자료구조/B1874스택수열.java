import java.io.*;
import java.util.*;

public class B1874스택수열 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    int num = 1;
    for (int i = 0; i < N; i++) {
      int temp = Integer.parseInt(br.readLine());
      if (!stack.isEmpty() && stack.peek() > temp) {
        sb.setLength(0);
        sb.append("NO");
        break;
      }

      while (stack.isEmpty() || stack.peek() < temp) {
        stack.push(num++);
        sb.append("+\n");

      }
    }

    System.out.print(sb);
  }
}
