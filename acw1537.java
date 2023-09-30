import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] nums;
    static boolean[] flags;
    static int[] temp;
    
    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        in.nextToken();
        n = (int) in.nval;
        nums = new int[n];
        temp = new int[n];
        flags = new boolean[n];
        Arrays.fill(flags, false);
        for(int i = 0; i < n; i++) {
            in.nextToken();
            nums[i] = (int) in.nval;
        }
        Arrays.sort(nums);
        dfs(0);
    }

    static void dfs(int index) {
        if (index >= n) {
            // output
            for(int i = 0; i < n; i++) {
                out.print(temp[i] + " ");
            }
            out.println();
            out.flush();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!flags[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && flags[i - 1] == false) {
                    // 前一个相同数字已经被选中的情况下,当前数字才会被选择
                    continue;
                }

                // 可以在其中加一些特定的流程

                flags[i] = true;
                temp[index] = nums[i];
                dfs(index + 1);
                flags[i] = false;
            }
        }
    }
}