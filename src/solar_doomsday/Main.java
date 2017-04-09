package solar_doomsday;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int test = 12;
		System.out.println(answer(test));
		
		
	}
	
	public static <T> List <T> answer(int area){
		List list = new ArrayList<>();
		
		int tmp = area;
		
		while (area > 0){
			//checking if number is a perfect square
			double sqrt = Math.sqrt(tmp);
			int x = (int) sqrt;
			if(Math.pow(sqrt,2) == Math.pow(x,2)){
				list.add(tmp);
				area -= tmp;
				tmp = area;
			}
			
			tmp -= 1;
		}
		
		return list;
	}

}
