package Week3.day2.assignment;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class CharacterOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String text = "welcome to Selenium automation";
char[] charArray = text.toCharArray();
Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
for (int i = 0; i < charArray.length; i++) {
	if(map.containsKey(charArray[i])) {
		
		int value = map.get(charArray[i]);
		int newValue = value+1;
		map.put(charArray[i],newValue);
		}
		
		else
		{
			
			map.put(charArray[i], 1);
		}
	}	
	
	System.out.println(map);
}


	}


