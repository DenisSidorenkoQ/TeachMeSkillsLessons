public class AdditionalTask
{
     public static void matrixMultiplication()
     {
         int[][] firstMatrix = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
         int[][] secondMatrix = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
  
         int n = firstMatrix.length;
         int m = firstMatrix[0].length;
         int h = secondMatrix[0].length;
  
         int[][] matrix = new int[n][h];
  
         for(int i = 0; i < n; i++)
         {
             for(int j = 0; j < h; j++)
             {
                 for(int g = 0; g < m; g++)
                 {
                     matrix[i][j] += firstMatrix[i][g] * secondMatrix[g][j];
                 }
             }
         }
         for(int i = 0; i < n; i++)
         {
             for(int j = 0; j < h; j++)
             {
                 System.out.print(matrix[i][j] + "\t");
             }
             System.out.println();
         }
    }
 
    public static void matrixSum()
    {
        int[][] matrix = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
        int sum = 0;
  
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                sum += matrix[i][j];
            }
        }
        System.out.print(sum);
    }
 
    public static void matrixDiag()
    {
        int[][] matrix = {{1, 2, 3}, {1, 1, 1}, {2, 1, 0}};
        int firstPosition = 0;
        int size = matrix.length;
        int secondPosition = size - 1;

  
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(j != firstPosition && j != secondPosition)
                {
                    System.out.print(" ");     
                }
                else
                {
                    System.out.print(matrix[i][j]);
                }
            }
   
            firstPosition++;
            secondPosition--;
            System.out.println();
        }
    }
 
    public static void matrixSort()
    {
        int[][] arr = {{8, 2, 3}, {4, 9, 6}, { 8, 9, 7}};
 
        for (int i = 0; i < arr.length; i++)
        {
            for (int out = arr[i].length - 1; out >= 1; out--)
            {
                for (int in = 0; in < out; in++)
                {
                    if(arr[i][in] > arr[i][in + 1])
                    {
                        int dummy = arr[i][in];
                        arr[i][in] = arr[i][in + 1];
                        arr[i][in + 1] = dummy;          
                    }             
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
            {
   
                System.out.print(arr[i][j] + " ");
            }
  
            System.out.print("\n");
        }
    }
}
