import java.util.*;

public class tabline_one{
	
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		for(int i = 0; i < n; i++){

			System.out.print(i+" ");
		}

		scan.close();
	}
}