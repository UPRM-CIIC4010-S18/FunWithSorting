import java.util.Comparator;

public class SortersGeneric<T, C extends Comparator<T>> {

	public void selectionSort(T[] numbers, C c) {
		for (int i=0; i<numbers.length; i++) {
			int posMin = i;
			for (int j=i+1; j<numbers.length; j++) {
				if (c.compare(numbers[j], numbers[posMin]) < 0) {
					posMin = j;
				}
			}
			T temp = numbers[posMin];
			numbers[posMin] = numbers[i];
			numbers[i] = temp;
		}
	}
	
	public void mergeSort(T[] numbers, C c) {
		if (numbers.length <= 1) {
			return;
		}
		else {
			T[] leftHalf = (T[]) (new Object[numbers.length / 2]);
			T[] rightHalf = (T[]) (new Object[numbers.length - leftHalf.length]);
			for (int i=0; i<leftHalf.length; i++) {
				leftHalf[i] = numbers[i];
			}
			for (int i=0; i<rightHalf.length; i++) {
				rightHalf[i] = numbers[leftHalf.length + i];
			}
			mergeSort(leftHalf, c);
			mergeSort(rightHalf, c);
			merge(leftHalf, rightHalf, numbers, c);
		}
	}
	
	public void merge(T[] left, T[] right, T[] result, C c) {

		int leftPos = 0;
		int rightPos = 0;
		int resultPos = 0;
		while (leftPos<left.length && rightPos <right.length) {
			if (c.compare(left[leftPos], right[rightPos])<0) {
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
