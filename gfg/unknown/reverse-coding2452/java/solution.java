import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        System.out.println(sumN(n));
        
        
        
    }
    public static int sumN(int num){
        if(num==0)return 0;
        
        return num+sumN(num-1);
        
    }
}