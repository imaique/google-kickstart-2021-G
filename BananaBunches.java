import java.util.*;
public class BananaBunches {

    /*
    Problem

    Barbara goes to Alan's banana farm, where the N banana trees are organized in one long line represented by an array B.
    The tree at position i has Bi banana bunches. Each tree has the same cost. Once Barbara buys a tree, she gets all the banana bunches on that tree.
    Alan has a special rule: because he does not want too many gaps in his line, he allows Barbara to buy at most 2 contiguous sections of his banana tree line.

    Barbara wants to buy some number of trees such that the total number of banana bunches on these purchased trees equals the capacity K of her basket.
    She wants to do this while spending as little money as possible. How many trees should she buy?
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int z = 1; z <= T; z++){
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) arr[i] = scanner.nextInt();
            int[][][] memo = new int[2][N][K];
            for(int i = 0; i < memo.length; i++){
                for (int j = 0; j < memo[i].length; j++){
                    for(int k = 0; k < memo[i][j].length; k++){
                        memo[i][j][k] = Integer.MIN_VALUE;
                    }
                }
            }
            int answer = dp(0, K, 2, arr, memo, true);

            System.out.println("Case #" + z + ": " + answer);
        }
    }
    
    public static int dp(int index, int currentSum, int remainingSections, int[] arr, int[][][] memo, boolean prevSkip){
        if(currentSum == 0) return 0;
        if(remainingSections == 0 || currentSum < 0 || index == arr.length) return -1;
        if(memo[remainingSections-1][index][currentSum-1] != Integer.MIN_VALUE) return memo[remainingSections-1][index][currentSum-1];
        int with = dp(index+1, currentSum - arr[index], remainingSections, arr, memo, false);
        int without = dp(index + 1, currentSum, remainingSections - (prevSkip ? 0 : 1), arr, memo, true);
        if(with == -1 && without == -1) {
            memo[remainingSections-1][index][currentSum-1] = -1;
            return -1;
        }
        if(with == -1) {
            memo[remainingSections-1][index][currentSum-1] = without;
            return without;
        }
        if(without == -1) {
            memo[remainingSections-1][index][currentSum-1] = 1 + with;
            return 1 + with;
        }
        memo[remainingSections-1][index][currentSum-1] = Math.min(1 + with, without);
        return Math.min(1 + with, without);
    }
}