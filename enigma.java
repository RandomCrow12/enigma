import java.util.*;

public class enigma {
    public static int[] row1 = {1, 2, 3};
    public static int[] row2 = {4, 5, 6, 7};
    public static int[] row3 = {8, 9, 10, 11, 12};
    public static int[] row4 = {13, 14, 15, 16};
    public static int[] row5 = {17, 18, 19};
    public static void main(String[] args) {
        
        permHelper(new int[19], 0, new boolean[19]);

    }



    public static boolean checkRows(int[] input){

       row1[0] = input[0];
       row1[1] = input[1];
       row1[2] = input[2];
       row2[0] = input[3];
       row2[1] = input[4];
       row2[2] = input[5];
       row2[3] = input[6];
       row3[0] = input[7];
       row3[1] = input[8];
       row3[2] = input[9];
       row3[3] = input[10];
       row3[4] = input[11];
       row4[0] = input[12];
       row4[1] = input[13];
       row4[2] = input[14];
       row4[3] = input[15];
       row5[0] = input[16];
       row5[1] = input[17];
       row5[2] = input[18];


        // horizontal
        if (row1[0] + row1[1] + row1[2] != 38) return false;
        if (row2[0] + row2[1] + row2[2] + row2[3] != 38) return false;
        if (row3[0] + row3[1] + row3[2] + row3[3] + row3[4] != 38) return false;
        if (row4[0] + row4[1] + row4[2] + row4[3] != 38) return false;
        if (row5[0] + row5[1] + row5[2] != 38) return false;

        //top left
        if (row1[0] + row2[0] + row3[0] != 38) return false;
        if (row1[1] + row2[1] + row3[1] + row4[0] != 38) return false;
        if (row1[2] + row2[2] + row3[2] + row4[1] + row5[0] != 38) return false;
        if (row2[3] + row3[3] + row4[2] + row5[1] != 38) return false;
        if (row3[4] + row4[3] + row5[2] != 38) return false;

        //bottom left
        if (row1[2] + row2[3] + row3[4] != 38) return false;
        if (row1[1] + row2[2] + row3[3] + row4[3] != 38) return false;
        if (row1[0] + row2[1] + row3[2] + row4[2] + row5[2] != 38) return false;
        if (row2[0] + row3[1] + row4[1] + row5[1] != 38) return false;
        if (row3[0] + row4[0] + row5[0] != 38) return false;

    
        return true;
    }

    public static void permHelper(int[] perm, int index, boolean[] used){
        // generate all permuations and check

        if (index == 19){ // base case, full array
            //System.out.println(Arrays.toString(perm)); // check if working

            if(checkRows(perm)) System.out.println(Arrays.toString(perm));

            return;
        }
         
        for (int i = 1; i <= 19; i++) {
            boolean[] newUsed = Arrays.copyOf(used, used.length);

            if (used[i-1] == false){
                perm[index] = i;
                newUsed[i-1] = true;
                permHelper(perm, index+1, newUsed);
            }

        }
    }

// this solution takes literally forever
}