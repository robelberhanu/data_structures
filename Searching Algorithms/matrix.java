import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

 
public class matrix
{
   static int[][] a_matrix = new int[9][9];
   //int[] a = {}
   public static void main(String[] args)
   {
       File file = new File("1.txt");
       String line = "";
       
       int i = 0;
       try(BufferedReader br = new BufferedReader(new FileReader(file)))
       {
           while( (line = br.readLine())!=null)
           {
             
               String[] s = line.split("");
               int k = 0, count=0;
              for(int r=0; r<9; r++)
              {
                   for(int t=0; t<9; t++)
                   {
                       if(Integer.parseInt(s[k])==0)count++;
                       
                       a_matrix[r][t] = Integer.parseInt(s[k]);
                       k++;
                   } 
              }
                   
               System.out.println("number of zeros: "+count);
              for(int r=0; r<9; r++)
              {
                  for(int t=0; t<9; t++)
                     System.out.print(" "+a_matrix[r][t]); 
                  System.out.println("");
              } 
              System.out.println("");
              System.out.println("");
              
              i++;
           }
       }
       catch(Exception e)
       {
           System.out.println("error");
       }
   }
}