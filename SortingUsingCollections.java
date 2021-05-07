package Week3.day2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<String>();
		input.add("HCL");
		input.add("Wipro");
		input.add("Aspire Systems");
		input.add("CTS");
		
		System.out.println("Length of Array: " + input.size());
		Collections.sort(input, Collections.reverseOrder());
		System.out.println("Reversed Output: " + input);
	}

}
