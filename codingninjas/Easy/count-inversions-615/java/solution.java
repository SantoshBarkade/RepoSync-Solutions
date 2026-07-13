import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        return mergeSort(arr,0,n-1);

    }
    private static long mergeSort(long[]arr, int low, int  high){
        if(low>=high)return 0;
        
        int mid=low+(high-low)/2;
        long cnt=0;

        cnt+=mergeSort(arr, low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=merge(arr, low, mid, high);
        return cnt;


    }
    private static long merge(long[] arr, int low, int mid, int high){
        ArrayList<Long>res=new ArrayList<>();

        int left = low;
        int right=mid+1;
        long cnt=0;
        while(left<=mid && right <=high){
            if(arr[left]<=arr[right]){
                res.add(arr[left]);
                left++;

            }
            else{
                res.add(arr[right]);
                cnt+=(mid-left+1);
                right++;

            }
        }
        while(left<=mid){
             res.add(arr[left]);
                left++;
        }
        while(right<=high){
             res.add(arr[right]);
                right++;
        }
        for(int i=low;i<=high;i++){
            arr[i]=res.get(i-low);

        }
        return cnt;
    }
}