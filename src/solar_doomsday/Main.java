package solar_doomsday;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int test = 12;
		answer(test);
		
		
	}
	
	public static <T> List<T> answer(int measure){
		List list = new ArrayList<>();
		
		for(int i = measure; i > 0; i--){
			//checking if number is a perfect square
			double sqrt = Math.sqrt(i);
			int x = (int) sqrt;
			if(Math.pow(sqrt,2) == Math.pow(x,2)){
				list.add(i);
			}else{
				System.out.println("Not possible");
			}
		}

		System.out.println(list);
		return list;
		
	}

}
