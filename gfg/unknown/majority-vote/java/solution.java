class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
      int n=arr.length;
        int cnt1=0,cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;

        for(int num:arr){
            if(cnt1==0 && el2 != num){
                cnt1=1;
                el1=num;

            }
            else if(cnt2==0 && el1 !=num){
                cnt2=1;
                el2=num;
            }
            else if(el1==num)cnt1++;
            else if(el2==num)cnt2++;
            else{
                cnt1--;
                cnt2--;

            }
        }
        
        cnt1=0;
        cnt2=0;
        for(int num:arr){
            if(el1==num)cnt1++;
            else if(el2==num)cnt2++;
        }
        ArrayList<Integer> res=new ArrayList<>();
        int min=n/3+1;

        if(cnt1>=min)res.add(el1);
       if(cnt2>=min) res.add(el2);
       Collections.sort(res);
        return res;
    }
}