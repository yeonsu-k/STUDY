import java.io.*;
import java.util.*;

public class B2504괄호의값 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] arr = br.readLine().toCharArray();
    Stack<Character> stack = new Stack<>();
    int result = 0;
    int cacl = 1;

    for (int i = 0; i < arr.length; i++) {
      char temp = arr[i];
      if (temp == '(') {
        stack.push(temp);
        cacl *= 2;
      } else if (temp == '[') {
        stack.push(temp);
        cacl *= 3;
      } else if (temp == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          result = 0;
          break;
        }
        if (arr[i - 1] == '(') {
          result += cacl;
        }

        stack.pop();
        cacl /= 2;
      } else if (temp == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          result = 0;
          break;
        }
        if (arr[i - 1] == '[') {
          result += cacl;
        }

        stack.pop();
        cacl /= 3;
      }
    }

    if (!stack.isEmpty())
      result = 0;

    System.out.println(result);
  }
}
