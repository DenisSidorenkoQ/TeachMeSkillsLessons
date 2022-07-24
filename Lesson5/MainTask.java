import java.util.Scanner;

public class MainTask
{    
    public static void increaseArrayElementsByNumber()
    {
        int[][][] arr = {{{2, 3, 4}, {8,8,3}, {3,5,6}}, {{1,2,3}, {6, 3, 5}, {1, 5, 4}}, {{1,7,9}, {4,4,4}, {3, 6, 6}}};
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
  
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
                for(int g = 0; g < arr[i][j].length; g++)
                {
                    arr[i][j][g] += number;
                    System.out.print(arr[i][j][g] + "\t");
                }
                System.out.println();
            }
        }
  
    }
 
    public static void chessBoard()
    {
        String[][] board =  new String[8][8];
        final String BLACK = "B";
        final String WHITE = "W";
  
        for(int i = 0; i < board.length; i++)
        {
            if(i % 2 == 0)
            {
                for(int j = 0; j < board[i].length; j++)
                {
                    if(j % 2 == 0)
                    {
                        board[i][j] = WHITE;
                    }
                    else
                    {
                        board[i][j] = BLACK;
                    }
                    System.out.print(board[i][j] + " ");
                 }
             }
             else
             {
                 for(int j = 0; j < board[i].length; j++)
                 {
                     if(j % 2 == 0)
                     {
                         board[i][j] = BLACK;
                     }
                     else
                     {
                         board[i][j] = WHITE;
                     }
                     System.out.print(board[i][j] + " ");
                 }
             }
             System.out.println();
         } 
     }
}
