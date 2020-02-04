import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * Complete the jumpingOnClouds function below.
   */
  static int jumpingOnClouds(int[] c) throws IllegalArgumentException {

    // **** bonus points ****
    ArrayList<Integer> clouds = new ArrayList<Integer>();
    clouds.add(0);

    // **** initialize number of jumps ****
    int jumps = 0;

    // **** traverse the path ****
    for (int i = 0; i < c.length - 1; jumps++) {

      // **** determine the length of the jump ****
      if ((i + 2 < c.length) && (c[i + 2] == 0)) {
        i += 2;
      } else if ((i + 1 < c.length) && (c[i + 1] == 0)) {
        i += 1;
      } else {
        // System.out.println("jumpingOnClouds <<<< unexpected input c: " +
        // Arrays.toString(c));
        // throw new IllegalArgumentException("invalid array contents");
      }

      // **** bonus points ****
      clouds.add(i);
    }

    // **** display path (bonus points) ****
    for (int i = 0; i < clouds.size(); i++) {
      if (i + 1 >= clouds.size()) {
        System.out.print(clouds.get(i));
      } else {
        System.out.print(clouds.get(i) + " -> ");
      }
    }
    System.out.println();

    // **** return the number of jumps ****
    return jumps;
  }

  // **** open scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Test scaffolding.
   */
  public static void main(String[] args) throws IOException, IllegalArgumentException {

    // **** ****
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** ****
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // **** ****
    int[] c = new int[n];

    // **** ****
    String[] cItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // **** ****
    for (int i = 0; i < n; i++) {
      int cItem = Integer.parseInt(cItems[i]);
      c[i] = cItem;
    }

    // **** ****
    int result = jumpingOnClouds(c);

    // **** output result ****
    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    // **** close buffered writer ****
    bufferedWriter.close();

    // **** close scannner ****
    scanner.close();
  }
}