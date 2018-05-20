import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class SortersTest {

	public Integer[] sorted = { 1, 2, 3, 4, 5, 6 };
	public Integer[] reversed = { 6, 5, 4, 3, 2, 1 };
	public Integer[] sorted2 = { 1, 2, 3, 4, 5, 6 };
	

	public interface LessThanI<T> extends Comparator<T>{};
	
	public static class LessThan implements LessThanI<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i1-i2;
		}
	}
	
	public Sorters<Integer, LessThanI<Integer>> sorters;
	//public Sorters<Rectangle> sorters2;
	
	@Before
	public void setUp() {
		sorters = new Sorters<Integer, LessThanI<Integer>>();
	}


	public static class GreaterThan implements Comparator<Integer> {
		public int compare(Integer i1, Integer i2) {
			return i2-i1;
		}
	}

	@Test
	public void testReversedNamedInnerClasses() {
		sorters.selectionSort(reversed, new LessThan());
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testReversedAnonymousInnerClasses() {
		sorters.selectionSort(reversed, 
				new LessThan() {
			@Override
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
		sorters.selectionSort(reversed, (Integer i1, Integer i2)-> (i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testSorted() {	
		sorters.selectionSort(sorted, new LessThan());
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted2[i], sorted[i]);
		}
	}

	@Test
	public void testMergeReversed() {	
		sorters.mergeSort(reversed,(Integer i1, Integer i2)-> (i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted[i], reversed[i]);
		}
	}

	@Test
	public void testMergeSorted() {	
		sorters.mergeSort(sorted, (Integer i1, Integer i2)-> (i1-i2));
		for (int i=0; i<reversed.length; i++) {
			assertEquals(sorted2[i], sorted[i]);
		}
	}
}
