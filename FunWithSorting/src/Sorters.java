import java.util.Comparator;

public class Sorters<T, C extends Comparator<T>> {

	public void selectionSort(T[] elements, C c) {
		for (int i=0; i<elements.length; i++) {
			int posMin = i;
			for (int j=i+1; j<elements.length; j++) {
				if (c.compare(elements[j], elements[posMin]) < 0) {
					posMin = j;
				}
			}
			T temp = elements[posMin];
			elements[posMin] = elements[i];
			elements[i] = temp;
		}
	}
	
	public void mergeSort(T[] elements, C c) {
		if (elements.length <= 1) {
			return;
		}
		else {
			// Change to use ArrayLlist instead of array for type safety
			T[] leftHalf = (T[])(new Object[elements.length / 2]);
			T[] rightHalf = (T[]) (new Object[elements.length - leftHalf.length]);
			for (int i=0; i<leftHalf.length; i++) {
				leftHalf[i] = elements[i];
			}
			for (int i=0; i<rightHalf.length; i++) {
				rightHalf[i] = elements[leftHalf.length + i];
			}
			mergeSort(leftHalf, c);
			mergeSort(rightHalf, c);
			merge(leftHalf, rightHalf, elements, c);
		}
	}
	
	public void merge(T[] left, T[] right, T[] result, C c) {

		int leftPos = 0;
		int rightPos = 0;
		int resultPos = 0;
		while (leftPos<left.length && rightPos <right.length) {
			if (c.compare(left[leftPos], right[rightPos]) < 0) {
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
