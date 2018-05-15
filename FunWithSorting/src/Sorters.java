import java.util.Comparator;

public class Sorters {

	public static void selectionSort(int[] numbers, Comparator<Integer> c) {
		for (int i=0; i<numbers.length; i++) {
			int posMin = i;
			for (int j=i+1; j<numbers.length; j++) {
				if (c.compare(numbers[j], numbers[posMin]) < 0) {
					posMin = j;
				}
			}
			int temp = numbers[posMin];
			numbers[posMin] = numbers[i];
			numbers[i] = temp;
		}
	}
	
	public static void mergeSort(int[] numbers) {
		if (numbers.length <= 1) {
			return;
		}
		else {
			int[] leftHalf = new int[numbers.length / 2];
			int[] rightHalf = new int[numbers.length - leftHalf.length];
			for (int i=0; i<leftHalf.length; i++) {
				leftHalf[i] = numbers[i];
			}
			for (int i=0; i<rightHalf.length; i++) {
				rightHalf[i] = numbers[leftHalf.length + i];
			}
			mergeSort(leftHalf);
			mergeSort(rightHalf);
			merge(leftHalf, rightHalf, numbers);
		}
	}
	
	public static void merge(int[] left, int[] right, int[] result) {

		int leftPos = 0;
		int rightPos = 0;
		int resultPos = 0;
		while (leftPos<left.length && rightPos <right.length) {
			if (left[leftPos] < right[rightPos]) {
				result[resultPos] = left[leftPos];
				leftPos++;
			}
			else {
				result[resultPos] = right[rightPos];
				rightPos++;
			}
			resultPos++;
		}
		
		for (int i=leftPos; i<left.length; i++) {
			result[resultPos] = left[leftPos];
			leftPos++;
			resultPos++;
		}
		for (int i=rightPos; i<right.length; i++) {
			result[resultPos] = right[rightPos];
			rightPos++;
			resultPos++;
		}
	}
	
}
