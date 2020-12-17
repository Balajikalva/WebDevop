import java.util.*;

public class triplets{
	
	static class pair implements Comparable<pair>{

		int n1,n2,val;

		public pair(int s1,int s2){

			n1 = s1;
			n2 = s2;
			val = (s1*s1) + (s2*s2);
		}

		public int compareTo(pair that){

			if(this.val < that.val) return -1;
			if(this.val > that.val) return 1;

			return 0;
		}

		public void printpair(){

			System.out.println("n1 : "+n1+" n2: "+n2);
		}
	}

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		HashSet<Integer> set = new HashSet<Integer>();
		PriorityQueue<pair> queue = new PriorityQueue<pair>();

		int k = 1;

		while(k*k <= n){

			queue.add(new pair(k,1));
			set.add(k*k);
			k++;
		}

		pair temp;

		boolean[][] seen = new boolean[k+1][k+1];

		while(queue.size() > 0){

			temp = queue.poll();

			if(((seen[temp.n1][temp.n2] == false && seen[temp.n2][temp.n1] == false) && set.contains(temp.val))){

				System.out.println(temp.n1+" "+temp.n2+" "+(int) Math.sqrt(temp.val));
				seen[temp.n1][temp.n2] = true;
				seen[temp.n2][temp.n1] = true;
			}

			if(((temp.n2 + 1) * (temp.n2 + 1)) + (temp.n1 * temp.n1) <= n){

				queue.add(new pair(temp.n1,temp.n2+1));
			}
		}

		return;
	}
}