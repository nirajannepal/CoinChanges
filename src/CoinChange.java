import java.util.Arrays;

public class CoinChange {

    public int solve(int[] typesOfCoins, int total) {

        Arrays.sort(typesOfCoins);

        int x =0, y=0, newInt = 0;

        //creats new array adding new coin value 0
        if(typesOfCoins[0]!=0){
            x=typesOfCoins.length+1;
            y=total+1;
            newInt = typesOfCoins.length + 1;
            int [] newTypesOfCoin = new int[newInt];
            newTypesOfCoin[0] = 0;
            for(int i=1;i<newTypesOfCoin.length;i++){
                newTypesOfCoin[i]= typesOfCoins[i-1];
            }
            int result = solveDynamically(newTypesOfCoin,x,y,total);
            return result;
        }
        else {
            x=typesOfCoins.length;
            y=total+1;
            int result =solveDynamically(typesOfCoins,x,y,total);
            return result;
        }
    }

    private int solveDynamically(int[] newTypesOfCoin, int x, int y, int total) {



        int [][] matrixArray = new int[x][y];

        // first step: fill the first row of (0,0) , (0,1), (0,2) ..... ,(0,total)
        matrixArray[0][0]=1;

        //using dynamic program
        // row>column copy the above cell ;
        for(int i=1;i<x;i++){
            for(int j=0;j<y;j++){
                //above cell:((0,0))  current cell:(1,0)
                if(newTypesOfCoin[i]>j){
                    matrixArray[i][j] = matrixArray[i-1][j];
                }
                else {
                    /*
                    use 3 rules
                    1) exclude new coin
                    2) include new coin
                    3) add (1 + 2)
                     */

                    //1st rule : get element from above cell
                    int first = matrixArray[i-1][j];

                    //2nd rule: identify new coin; total in that cell - newCoin =(column-row) =(j-i) ; get a value from cell of same row and newCoin
                    int coinToUse = j - newTypesOfCoin[i];
                    int second = matrixArray[i][coinToUse];

                    //3rd rule: add first + second
                    int third = first + second;

                    //fill the array
                    matrixArray[i][j] = third;
                }
            }
        }
        return matrixArray[x-1][y-1];
    }
}
