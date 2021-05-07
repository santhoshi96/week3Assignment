package Week3.day2.assignment;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 String name = "PayPal India";
 char[] charArray = name.toCharArray();
 Set<Character> charSet = new HashSet<Character>();
 Set<Character> dupCharSet = new HashSet<Character>();
 for (int i = 0; i < charArray.length; i++) {
	char val = charArray[i];
	
	if (charSet.contains(charArray[i])) {
		dupCharSet.add(new Character(charArray[i]));

	}
	if (dupCharSet.equals(charSet)) {
		charSet.remove(dupCharSet);
				
	}
	if (val != ' ') {
		charSet.add(new Character(charArray[i]));
	}
	System.out.println(charSet);

	
	}

}
}

	
