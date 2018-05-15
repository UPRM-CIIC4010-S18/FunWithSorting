import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

public class SortersGenericTest {

	public Integer[] sorted = { 1, 2, 3, 4, 5, 6 };
	public Integer[] reversed = { 6, 5, 4, 3, 2, 1 };
	public Integer[] sorted2 = { 1, 2, 3, 4, 5, 6 };
	
	SortersGeneric<Integer, Comparator<Integer>> sorters = new SortersGeneric<Integer,Comparator<Integer>>();
	
	public static class LessThan implements Comparator<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i1-i2;
		}
	}

	@Test
	public void testReversedNamedInnerClass() {
		sorters.selectionSort(reversed, new LessThan());
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}
	
	@Test
	public void testReversedAnonymousInnerClass() {	
		sorters.selectionSort(reversed, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1-i2;
			}
		});
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}
	
	@Test
	public void testReversedLambdaExpression() {	
		sorters.selectionSort(reversed, (Integer i1, Integer i2)->(i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}
	
	@Test
	public void testReversed() {	
		sorters.selectionSort(reversed, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1-i2;
			}
		});
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

//	@Test
//	public void testSorted() {	
//		Sorters.selectionSort(sorted);
//		for (int i=0; i<reversed.length; i++) {
//			assertEquals(sorted2[i], sorted[i]);
//		}
//	}

	@Test
	public void testMergeReversed() {	
		sorters.mergeSort(reversed, (Integer i1, Integer i2)->(i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testMergeSorted() {	
		sorters.mergeSort(sorted, (Integer i1, Integer i2)->(i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted2[i], sorted[i]);
		}
	}


}
