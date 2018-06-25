/*/
Ask user to give denomination of coin in single array and total in int.
calculates dynamically and returns how many types of coin changes are possible
 */

public class Main {

    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        int [] typesOfCoins = {10,25,50};
        int total = 50;
        System.out.println(coinChange.solve(typesOfCoins,total));
    }
}
