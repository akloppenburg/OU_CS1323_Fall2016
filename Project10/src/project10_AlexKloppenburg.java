import java.util.Arrays;

public class project10_AlexKloppenburg {
	
	public static int SIZE = 10;
	public static int sortedSize = 0;

	public static void main(String[] args) {
		
		//Makes array and fills with values
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println("Here is the current array:");
		System.out.println(Arrays.toString(numbers));
		
		//Shuffles array so that we can actually sort it
		numbers = shuffle(numbers);
		
		System.out.println("Here is the shuffled array:");
		System.out.println(Arrays.toString(numbers));
		
		//Sorts array
		numbers = sortArray(numbers);
		
		System.out.println("Here is the array after it has been sorted:");
		System.out.println(Arrays.toString(numbers));
	}

	public static int findSmallest(int[] data, int min, int i){
		int v;
		
		for(v = i + 1; v < data.length; ++v){
			if(data[v] < data[min]){
				min = v;
			}
		}
		
		return min;
	}
	
	public static int[] shuffle(int[] data){
		
		//Variables for for loop and swap
		int i;
		int temp ;
		
		//
		for(i = 0; i < data.length; ++i){
			int position = (int)Math.round(Math.random() * (SIZE - 1));
			
			temp = data[0];
			data[0] = data[position];
			data[position] = temp;
		}
		
		return data;
	}
	
	public static int[] sortArray(int[] data){
		
		int minimum;
		int i;
		
		for(i = 0; i < data.length; ++i){
			minimum = i;
			minimum = findSmallest(data, minimum, i);
			data = helper(data, minimum, i);
		}
		
		return data;
	}
	
	public static int[] helper(int[] data, int min, int i){
		int v;
		int temp;
		
		if(min != i){
			temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
		
		return data;
	}
}
