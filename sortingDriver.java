//Kana Kihara
//Sorting IDs

import java.util.*;
import java.io.*;

/* Get index and add values into array */

public class sortingDriver{
	public static void main (String[] args){
		List<String> listToSort = new ArrayList<String>(); // Create arraylist. Each array element represents an element from the input file
		String filename = "sampleInput.txt";
		String outputFile = "output.csv";

		/* Open txt file */
		File fp = new File(filename);

		try{
			Scanner input = new Scanner(fp);

			/* Read from text file */
			/* Add the elements to arraylist */
			while (input.hasNext()){	
				String info = input.next();
				listToSort.add(info);
			}
			/* Close file */
			input.close();
		}catch (FileNotFoundException e){
            e.printStackTrace();
        }

        /* listToSort = sorted array */
        System.out.println(listToSort);
        listToSort = compareArray(listToSort);

        /* Write to CSV file: output.csv */
        try{
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			for (String element : listToSort){
				writer.printf(element + "\n");
			}
			writer.close();
		}
		catch (IOException e){
			System.out.println (e.toString());
       		System.out.println("Could not find file " + outputFile);
		}
	}

	/* Sort numerically and alphabetically.. No sort method. Do manually */
	public static List<String> compareArray(List<String> list){
		int i = 0, j = 0, k = 0;
		int strLen = 0;

		/* i points to first index of array. j points to i+1 index of array. */
		for (i = 0; i < list.size(); i++){
  			for (j = i + 1; j < list.size(); j++){
    			/* If one of elements are not numeric (a string).. */
    			if (isAlpha(list.get(j)) || isAlpha(list.get(i))){
    				if (list.get(j).length() == list.get(i).length()){
    					strLen = list.get(j).length();
    				}
    				else if (list.get(j).length() > list.get(i).length()){
    					strLen = list.get(i).length();
    				}
    				else{
    					strLen = list.get(j).length();
    				}
    				
    				for (k = 0; k < strLen; k++){
    					if (list.get(j).charAt(k) == list.get(i).charAt(k)){
    						//Want to keep iterating.. No break
    					}
    					else if (list.get(j).charAt(k) < list.get(i).charAt(k)){
    						Collections.swap(list, i, j);
    						break;
    					}
    					else{
    						break;
    					}
    				}
    			}

    			/* If comparing numbers... */
    			else if (Integer.valueOf(list.get(j)).compareTo(Integer.valueOf(list.get(i))) < 0){
    				Collections.swap(list, i, j);
    			}
  			}
		}
		return list;
	}

	/* Converts String to character array and checks if the character is a letter or not. If it is not, returns false. */
	public static boolean isAlpha(String name) {
    	char[] chars = name.toCharArray();

    	for (char c : chars) {
        	if(!Character.isLetter(c)){
            	return false;
        	}
    	}
    	return true;
	}
}















