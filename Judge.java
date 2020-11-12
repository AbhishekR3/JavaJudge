//Abhishek Ramesh
//Lab Assignment 7 - Find the Judge

import java.util.Arrays;

public class Judge {

	//Create number of people in community and trusting others array
	public static int numberPeople = 4;
	public static int[][] trustArray = {{1,3}, {1,4}, {2,3}, {2,4}, {4,3}}; //3
	
	//Finding the judge function
	public static int findJudge(int N, int[][] trust) {

		//Array to count number of times ith number is in trusted position
		int[] count = new int[N+1];

		//If a number is in the 0th position in the 2number array, the count decreases by 1 (indicates someone doesn't trust them)
		//If a number is in the 1st position in the 2number array, the count increase by 1 (indicates someone trusts them)
		for (int i = 0; i<trust.length; i++) {
			count[trust[i][0]]--;
			count[trust[i][1]]++;
		}

		//Returns judge's number, when the (count of judge == N-1), thus everyone trusts this person
		//N-1 since the judge trusting themselves is not recorded
		for (int judge = 1; judge < N+1; judge++) {
			if (count[judge] == N-1) {
				return judge;
			}
		}

		//If none of the people are trusted by everyone, return -1
		return -1;
	}

	public static void main(String[] args){
		System.out.println(Arrays.deepToString(trustArray));
		System.out.println("Judge is: " + findJudge(numberPeople, trustArray));
	}
}