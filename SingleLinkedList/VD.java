
public class VD {
    public static void main(String[] args) {
        int[] a = {5,6,8,2,0,4,6,2,1,5};
        int n=10;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = n-1; j >i; j--) {
//                if (a[j]>a[j-1]) {
//                    int t=a[j]; a[j]=a[j-1]; a[j-1]=t;
//                }                
//            }
//        }
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]>a[j+1]) {
                    int t=a[j]; a[j]=a[j+1]; a[j+1]=t;
                }
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    
}
