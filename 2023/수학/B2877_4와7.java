import java.io.*;

public class B2877_4와7 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine()) + 1;
    StringBuilder sb = new StringBuilder();
    while (K / 2 > 0) {
      sb.append(K % 2);
      K /= 2;
    }

    StringBuilder result = new StringBuilder();
    for (int i = sb.toString().length() - 1; i >= 0; i--) {
      if (sb.charAt(i) == '0')
        result.append(4);
      else
        result.append(7);
    }

    System.out.print(result.toString());
  }
}