import java.util.*;

class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        
        long val = 1; 
        row.add(1);

        for (int r = 1; r < n; r++) {
            val = val * (n - r) / r;
            row.add((int) val);
        }

        return row;
    }
}