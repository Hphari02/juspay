package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class larges {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<List<Integer>> ll = new ArrayList<>();
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            ll.add(new ArrayList<>());
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {
                continue;
            }
            ll.get(arr[i]).add(i);
        }
        int max=0;
        int index=-1,j=0;
        int sum=0;
        for (List<Integer> l : ll) {
            for(int i:l)
            {
                sum=sum+i;
            }
            if(sum>max)
            {
                index=j;
            }
            max=Math.max(sum,max);

            j++;
        }
        System.out.println(index);
    }
}
