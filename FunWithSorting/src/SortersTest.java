import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

public class SortersTest {

	public int[] sorted = { 1, 2, 3, 4, 5, 6 };
	public int[] reversed = { 6, 5, 4, 3, 2, 1 };
	public int[] sorted2 = { 1, 2, 3, 4, 5, 6 };

	public static class LessThan implements Comparator<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i1-i2;
		}
	}

	public static class GreaterThan implements Comparator<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i2-i1;
		}
	}

	@Test
	public void testReversedNamedInnerClasses() {
		Sorters.selectionSort(reversed, new LessThan());
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testReversedAnonymousInnerClasses() {
		Sorters.selectionSort(reversed, 
				new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1-i2;
			}
		}
				);
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}
	
	@Test
	public void testReversedLambdaExpression() {
		Sorters.selectionSort(reversed, (Integer i1, Integer i2)-> (i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testSorted() {	
		Sorters.selectionSort(sorted, new LessThan());
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted2[i], sorted[i]);
		}
	}

	@Test
	public void testMergeReversed() {	
		Sorters.mergeSort(reversed);
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testMergeSorted() {	
		Sorters.mergeSort(sorted);
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted2[i], sorted[i]);
		}
	}
}
