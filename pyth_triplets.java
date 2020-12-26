import java.util.*;

public class pyth_triplets {
    
    public static class triple implements Comparable<triple>{

        public int n1,n2,val;

        public triple(int n1,int n2){

            this.n1 = n1;
            this.n2 = n2;

            val = (this.n1 * this.n1) + (this.n2 * this.n2);
        }

        public int compareTo(triple that){

            if(this.val < that.val) return -1;
            if(this.val > that.val) return 1;
            return 0;
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int max = scan.nextInt();
        int k = 1;

        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<triple> pq = new PriorityQueue<triple>();

        while(k*k <= max){

            set.add(k*k);
            pq.add(new triple(k,1));
            k++;
        }

        triple temp;

        boolean[][] seen = new boolean[k+1][k+1];

        while(pq.size() > 0){

            temp = pq.poll();

            if(set.contains(temp.val) && !seen[temp.n1][temp.n2] && !seen[temp.n2][temp.n1]){

                System.out.println(temp.n1+" "+temp.n2+" "+(int) Math.sqrt(temp.val));
                seen[temp.n1][temp.n2] = true;
                seen[temp.n2][temp.n1] = true;
            }

            int next = ((temp.n2 + 1) * (temp.n2 + 1)) + (temp.n1 * temp.n1);
/*
            if(next < 0){

                System.out.println("neg :: >> next ->> "+next);
            }
*/
            if(next <= max){

                pq.add(new triple(temp.n1,temp.n2 + 1));
            }
        }

        scan.close();
        return;
    }
}
