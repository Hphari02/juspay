package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class largest_sum_cycle {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        List<List<Integer>> ll=new ArrayList<>();
        int n=s.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            ll.add(new ArrayList<>());
            arr[i]=s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if(arr[i]==-1)
            {
                continue;
            }
            ll.get(i).add(arr[i]);
        }
        int j=0;
        for(List<Integer> l:ll)
        {
            System.out.println(j+" "+l);
            j++;
        }
        int max=0;
        for (int i = 0; i < n; i++) {
            List<Integer> l=new ArrayList<>();
            int count=cycle(arr,l,i);
            max=Math.max(max,count);
        }
        System.out.println(max);
    }
    public static int cycle(int[]arr,List<Integer> l,int val)
    {
        if(l.size()>1 && l.get(0)==val)
        {
            return l.size();
        }
        if(arr[val]==-1 || l.contains(val))
        {
            return 0;
        }
        l.add(val);
        return cycle(arr,l,arr[val]);
    }
}
