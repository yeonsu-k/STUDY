import java.io.*;
import java.util.*;

// stack

public class B4949균형잡힌세상 {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str;
    while (!(str = br.readLine()).equals(".")) {
      Stack<Character> stack = new Stack<>();
      char[] ch = str.toCharArray();
      for (char c : ch) {
        if (c == '(' || c == '[')
          stack.add(c);
        else if ((c == ')' || c == ']')) {
          if (stack.isEmpty())
            stack.add(c);
          else {
            char temp = stack.pop();
            if (temp != (c == ')' ? '(' : '[')) {
              stack.add(c);
            }
          }
        }
      }

      if (stack.size() == 0)
        sb.append("yes\n");
      else
        sb.append("no\n");
    }

    System.out.print(sb);
  }
}
