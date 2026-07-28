class Solution {
    static int inversionCount(int arr[]) {
        
        return mergeSort(arr,0,arr.length-1);
        
        
    }
        // Code Here
          static int mergeSort(int[]arr, int low, int  high){
        if(low>=high)return 0;
        
        int mid=low+(high-low)/2;
        int cnt=0;

        cnt+=mergeSort(arr, low,mid);
        cnt+=mergeSort(arr,mid+1,high);
        cnt+=merge(arr, low, mid, high);
        return cnt;


    }
     static int merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer>res=new ArrayList<>();

        int left = low;
        int right=mid+1;
        int cnt=0;
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
    