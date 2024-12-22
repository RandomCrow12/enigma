import java.util.*;
import java.util.stream.*;

public class enigma {
    public static int[] row1 = {1, 2, 3};
    public static int[] row2 = {4, 5, 6, 7};
    public static int[] row3 = {8, 9, 10, 11, 12};
    public static int[] row4 = {13, 14, 15, 16};
    public static int[] row5 = {17, 18, 19};

    public static ArrayList<int[]> threes = new ArrayList<>();
    public static ArrayList<int[]> fours = new ArrayList<>();
    public static ArrayList<int[]> fives = new ArrayList<>();

    public static void main(String[] args) {
        
        permHelper(new int[3], 0, new boolean[19]);
        permHelper(new int[4], 0, new boolean[19]);
        permHelper(new int[5], 0, new boolean[19]);


        // System.out.println(threes.size());
        // System.out.println(fours.size());
        // System.out.println(fives.size());
        threeWorker();
    }



    public static boolean checkRows(int[] input){

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

    public static boolean threeWorker(){
        // this method does NOT work yet lol
        int[] usedTwice = new int[19];
        int[] r1 = new int[3];
        int[] r2 = new int[3];
        int[] r3 = new int[3];
        int[] r4 = new int[3];
        int[] r5 = new int[3];
        int[] r6 = new int[3];
         

        for(int i = 0;  i< threes.size(); i++){
            ArrayList<int[]> copyThrees = new ArrayList<>();
            for (int[] item : threes) {
            copyThrees.add(item);
            }

            for(int ii = 0; ii < copyThrees.size(); ii++){
                if (ii < 0) ii = 0;
                System.out.println(ii);

                if (copyThrees.get(ii)[0] == threes.get(i)[0]) {copyThrees.remove(ii); ii--; continue;};
                if (copyThrees.get(ii)[0] == threes.get(i)[1]) {copyThrees.remove(ii); ii--; continue;};
                if (copyThrees.get(ii)[1] == threes.get(i)[1]) {copyThrees.remove(ii); ii--; continue;};
                if (copyThrees.get(ii)[2] == threes.get(i)[1]) {copyThrees.remove(ii); ii--; continue;};
            }

            for(int k = 0; k < copyThrees.size(); k++){
                // make another copy of each little version going down the list making sure everything complies
                ArrayList<int[]> cT2 = new ArrayList<>();
                for (int[] item : copyThrees) {
                cT2.add(item);
                }
                for(int ii = 0; ii < cT2.size(); ii++){
                    int rem = 0;
                    if (ii < 0) ii = 0;

                    if (cT2.get(ii)[0] != copyThrees.get(k)[2]) {cT2.remove(ii); rem++;};
                    if (cT2.get(ii)[0] == copyThrees.get(k)[1]) {cT2.remove(ii); rem++;};
                    if (cT2.get(ii)[1] == copyThrees.get(k)[1]) {cT2.remove(ii); rem++;};
                    if (cT2.get(ii)[2] == copyThrees.get(k)[1]) {cT2.remove(ii); rem++;};

                    ii = ii - rem;
                }

                for(int x = 0; x < cT2.size(); x++){

                    ArrayList<int[]> cT3 = new ArrayList<>();
                    for (int[] item : cT2) {
                    cT3.add(item);
                    }
                for(int ii = 0; ii < cT3.size(); ii++){
                    int rem = 0;
                    if (ii < 0) ii = 0;

                    if (cT3.get(ii)[0] != cT2.get(x)[2]) {cT3.remove(ii); rem++;};
                    if (cT3.get(ii)[0] == cT2.get(x)[1]) {cT3.remove(ii); rem++;};
                    if (cT3.get(ii)[1] == cT2.get(x)[1]) {cT3.remove(ii); rem++;};
                    if (cT3.get(ii)[2] == cT2.get(x)[1]) {cT3.remove(ii); rem++;};

                    ii = ii - rem;
                }

                    for(int z = 0; z < cT3.size(); z++){

                        ArrayList<int[]> cT4 = new ArrayList<>();
                    for (int[] item : cT3) {
                    cT4.add(item);
                    }
                for(int ii = 0; ii < cT4.size(); ii++){
                    int rem = 0;
                    if (ii < 0) ii = 0;

                    if (cT4.get(ii)[0] != cT3.get(z)[2]) {cT4.remove(ii); rem++;};
                    if (cT4.get(ii)[0] == cT3.get(z)[1]) {cT4.remove(ii); rem++;};
                    if (cT4.get(ii)[1] == cT3.get(z)[1]) {cT4.remove(ii); rem++;};
                    if (cT4.get(ii)[2] == cT3.get(z)[1]) {cT4.remove(ii); rem++;};

                    ii = ii - rem;
                }

                        for(int v = 0; v < cT4.size(); v++){

                            ArrayList<int[]> cT5 = new ArrayList<>();
                    for (int[] item : cT4) {
                    cT5.add(item);
                    }
                for(int ii = 0; ii < cT5.size(); ii++){
                    int rem = 0;
                    if (ii < 0) ii = 0;

                    if (cT5.get(ii)[0] != cT4.get(v)[2]) {cT5.remove(ii); rem++;};
                    if (cT5.get(ii)[0] == cT4.get(v)[1]) {cT5.remove(ii); rem++;};
                    if (cT5.get(ii)[1] == cT4.get(v)[1]) {cT5.remove(ii); rem++;};
                    if (cT5.get(ii)[2] == cT4.get(v)[1]) {cT5.remove(ii); rem++;};

                    ii = ii - rem;
                }

                            for(int j = 0;  j< cT5.size(); j++){
                                r1 = threes.get(i);
                                r2 = copyThrees.get(k);
                                r3 = cT2.get(x);
                                r4 = cT3.get(z);
                                r5 = cT4.get(v);
                                r6 = cT5.get(j);

                                if (r6[2] == r1[0] && r5[2] == r6[0]){
                                    System.out.println(Arrays.toString(r1));
                                    System.out.println(Arrays.toString(r2));
                                    System.out.println(Arrays.toString(r3));
                                    System.out.println(Arrays.toString(r4));
                                    System.out.println(Arrays.toString(r5));
                                    System.out.println(Arrays.toString(r6));
                                    System.out.println(" ");
                                }  
                                
                            }
                        }
                    }
                }
            }
        }
        

        return true;
    }

    public static void permHelper(int[] perm, int index, boolean[] used){
        // generate all permuations and check

        if (index == perm.length){ // base case, full array
            //System.out.println(Arrays.toString(perm)); // check if working

            if(IntStream.of(perm).sum() == 38){ // sums the array
                //System.out.println(Arrays.toString(perm));
                if (perm.length == 3) threes.add(perm);
                if (perm.length == 4) fours.add(perm);
                if (perm.length == 5) fives.add(perm);
            }

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


}