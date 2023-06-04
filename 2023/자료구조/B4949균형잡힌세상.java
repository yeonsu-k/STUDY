import java.io.*;
import java.util.*;

public class B4949균형잡힌세상 {
  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str;
    while (!(str = br.readLine()).equals(".")) {
      Stack<Character> stack = new Stack<>();
      str = str.replaceAll("[^\\[\\]\\(\\)]", "");
      boolean pass = false;
      char[] ch = str.toCharArray();
      for (char c : ch) {
        if (c == '(' || c == '[')
          stack.add(c);
        else if (stack.size() == 0)
          pass = true;
        else if (c == ')' || c == ']') {
          char temp = stack.pop();
          if (temp != (c == ')' ? '(' : '[')) {
            pass = true;
            break;
          }
        }
      }

      if (!pass && stack.size() == 0)
        sb.append("yes\n");
      else
        sb.append("no\n");

    }

    System.out.print(sb);
  }
}
