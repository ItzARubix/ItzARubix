import java.util.Arrays;
import java.util.ArrayList;

public class LeetcodeJump {

	public static void main(String[] args) {

		//int[] myArray = {4, 2, 2, 2, 17};
		//int[] myArray = {2, 1, 0, 0};

		int[] myArray = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		//int[] myArray = {3,4,3,1,0,7,0,3,0,2,0,3};
		//int[] myArray = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		System.out.println(jump(myArray));

	}

	public static int jump(int[] nums) {

		if(nums.length == 1) {
			return 0;
		}
		if(nums.length <= nums[0]+1) {
			return 1;
		}
		if(nums[0] == 0) {
			return 10000;
		}

		//Real code starts here ig
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		for(int i = 1; i<=nums[0]; i++) {
			if(nums[i] > nums[0]-i) {
				candidates.add(i);
			}
		}
		
		if(candidates.size()==0) {
			return 10000;
		}
		
		int theOutput = 1+jump(Arrays.copyOfRange(nums, candidates.get(0), nums.length)); //YOU ARE HERE
		for(int i = 1; i<candidates.size(); i++) {
			int temp = 1+jump(Arrays.copyOfRange(nums, candidates.get(i), nums.length));
			if(temp < theOutput) {
				theOutput = temp;
			}
		}
		return theOutput;
	}

}