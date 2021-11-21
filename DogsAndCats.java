import java.util.*;
public class DogsAndCats {

    /*
    Problem

    You work for an animal shelter and you are responsible for feeding the animals.
    You already prepared D portions of dog food and C portions of cat food.

    There are a total of N animals waiting in a line, some of which are dogs and others are cats.
    It might be possible that all the animals in the line are dogs or all the animals are cats. A string S of N characters C and D represents the order of cats and dogs in the line.
    The i-th character is equal to C if the i-th animal in the line is a cat. Similarly, the i-th character is equal to D if the i-th animal in the line is a dog.

    The animals are fed in the order they stay in the line. Each dog eats exactly 1 portion of dog food and similarly each cat eats exactly 1 portion of cat food.
    Moreover, you have extra portions of cat food. Every time a dog eats food, you bring M extra portions of cat food for cats.

    Animals have to be fed in the order they wait in line and an animal can only eat if the animal before it has already eaten.
    That means that if you run out of dog (or cat) food portions and a dog (or a cat) is about to get fed, the line will not move, as all the animals will wait patiently.

    You need to determine if in this scenario all the dogs in the line will be fed. Note that this means that some cats might remain in the line, but worry not, you will eventually feed them later!
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int z = 1; z <= T; z++){
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long C = (long)scanner.nextInt();
            int M = scanner.nextInt();
            String s = scanner.next();

            int index = 0;
            for(; index < s.length(); index++){
                if(s.charAt(index)=='C'){
                    if(C <= 0) break;
                    C--;
                }
                else {
                    if(D <= 0) break;
                    D--;
                    C += M;
                }
            }
            boolean yes = true;
            for(; index < s.length(); index++){
                if (s.charAt(index) == 'D'){
                    yes = false;
                    break;
                }
            }
            System.out.println("Case #" + z + ": " + (yes ? "YES" : "NO"));
        }
    }
}