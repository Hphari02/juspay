package graphs;

import java.util.*;

public class reachability {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number_edges = s.nextInt();

        HashMap<Integer, List<Integer>> h = new HashMap<>();
        for (int i = 0; i < number_edges; i++) {
            h.put(s.nextInt(), new ArrayList<>());
        }
        int number_of_edges = s.nextInt();
        for (int i = 0; i < number_of_edges; i++) {
            int vertex=s.nextInt();
            int vertex2=s.nextInt();
            h.get(vertex).add(vertex2);
            s.nextLine();
        }
        int start=s.nextInt();
        int end=s.nextInt();
        for(HashMap.Entry<Integer,List<Integer>> map:h.entrySet())
        {
            System.out.println(map.getKey()+" "+map.getValue());
        }
        boolean ans=reachable(start,end,h);
        System.out.println(ans);
    }
    public static boolean reachable(int start, int end, HashMap<Integer, List<Integer>> h)
    {
            Queue<Integer> q=new LinkedList<>();
            Set<Integer> l=new HashSet<>();
            q.add(start);
            l.add(start);
            while(!q.isEmpty())
            {
                int temp=q.poll();
                List<Integer> templist=h.get(temp);
                for(int i=0;i<templist.size();i++)
                {
                    if(!l.contains(templist.get(i))) {
                        if (templist.get(i) == end) {
                            return true;
                        }
                        q.add(templist.get(i));
                        l.add(templist.get(i));
                    }

                }
            }
            return false;

    }
}
