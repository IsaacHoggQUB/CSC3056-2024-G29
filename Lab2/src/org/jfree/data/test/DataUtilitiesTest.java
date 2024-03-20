package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	// testing rowTotal and columnTotal
	private Values2D values2D;
	
	// testing createNumberArray
	private double[] doubleArrayPositive = new double[3];
	private Number[] expectedArrayPositive = new Number[3];
	
	private double[] doubleArrayNegative = new double[3];
	private Number[] expectedArrayNegative = new Number[3];
	
	private double[] doubleArrayZero = new double[3];
	private Number[] expectedArrayZero = new Number[3];
	
	private double[] doubleArrayMixture = new double[3];
	private Number[] expectedArrayMixture = new Number[3];
	
	private double[] doubleArraySingle;
    private Number[] expectedArraySingle;
    
    
    // testing createNumberArray2D
    private double[][] doubleArray2DPositive = new double[2][3];
    private Number[][] expectedArray2DPositive = new Number[2][3];
    
    private double[][] doubleArray2DNegative = new double[2][3];
    private Number[][] expectedArray2DNegative = new Number[2][3];
    
    private double[][] doubleArray2DZero = new double[2][3];
    private Number[][] expectedArray2DZero = new Number[2][3];
    
    private double[][] doubleArray2DMixture = new double[2][3];
    private Number[][] expectedArray2DMixture = new Number[2][3];
    
	private double[][] doubleArray2DSingle;
    private Number[][] expectedArray2DSingle;
    
    
    // testing getCumulativePercentages
    private KeyedValues keyedValuesPositive;
    private KeyedValues expectedKeyedValuesPosAndNeg;

    private KeyedValues keyedValuesNegative;

    
    private KeyedValues singleKeyedValues;
    private KeyedValues expectedSingleKeyedValues;
    
    private KeyedValues emptyKeyedValues;
    private KeyedValues expectedEmptyKeyedValues;
	

	@Before
	public void setUp() throws Exception {
		
		// testing rowTotal and columnTotal
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		// set the 1st column
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		testValues.addValue(7, 2, 0);
		testValues.addValue(-3, 3, 0);
		// set the 2nd column
		testValues.addValue(5, 0, 1);
		testValues.addValue(-10, 1, 1);
		testValues.addValue(0, 2, 1);
		testValues.addValue(10, 3, 1);
		// set the 3rd column
		testValues.addValue(9, 0, 2);
		testValues.addValue(23, 1, 2);
		testValues.addValue(0, 2, 2);
		testValues.addValue(5, 3, 2);
		// set the 4th column
		testValues.addValue(15, 0, 3);
		testValues.addValue(4, 1, 3);
		testValues.addValue(5, 2, 3);
		testValues.addValue(11, 3, 3);
		
		
		// testing createNumberArray
		doubleArrayPositive = new double[] {1.0, 5.0, 9.0};
		expectedArrayPositive = new Number[] {1.0, 5.0, 9.0};
		
		doubleArrayNegative = new double[] {-1.0, -5.0, -9.0};
		expectedArrayNegative = new Number[] {-1.0, -5.0, -9.0};
		
		doubleArrayZero = new double[] {0.0, 0.0, 0.0};
		expectedArrayZero = new Number[] {0.0, 0.0, 0.0};
		
		doubleArrayMixture = new double[] {0.0, -5.0, 9.0};
		expectedArrayMixture = new Number[] {0.0, -5.0, 9.0};
		
		doubleArraySingle = new double[] {5.0};
		expectedArraySingle = new Number[] {5.0};
		
		
		// testing createNumberArray2D
		doubleArray2DPositive = new double[][]{
		    {1.0, 5.0, 9.0},
		    {1.0, 4.0, 7.0}
		};
		expectedArray2DPositive = new Number[][]{
		    {1.0, 5.0, 9.0},
		    {1.0, 4.0, 7.0}
		};
		
		doubleArray2DNegative = new double[][]{
		    {-1.0, -5.0, -9.0},
		    {-1.0, -4.0, -7.0}
		};
		expectedArray2DNegative = new Number[][]{
		    {-1.0, -5.0, -9.0},
		    {-1.0, -4.0, -7.0}
		};
		
		doubleArray2DZero = new double[][]{
		    {0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0}
		};
		expectedArray2DZero = new Number[][]{
		    {0.0, 0.0, 0.0},
		    {0.0, 0.0, 0.0}
		};
		
		doubleArray2DMixture = new double[][]{
		    {0.0, -5.0, 9.0},
		    {-1.0, 0.0, 7.0}
		};
		expectedArray2DMixture = new Number[][]{
		    {0.0, -5.0, 9.0},
		    {-1.0, 0.0, 7.0}
		};
		
		doubleArray2DSingle = new double[][] {{9.0}};
		expectedArray2DSingle = new Number[][] {{9.0}};
		
		
		// testing getCumulativePercentages
		DefaultKeyedValues keyValuesPositive = new DefaultKeyedValues();
		keyedValuesPositive = keyValuesPositive;
		keyValuesPositive.addValue((Comparable) 0.0, 5.0);
		keyValuesPositive.addValue((Comparable) 1.0, 9.0);
		keyValuesPositive.addValue((Comparable) 2.0, 2.0);
		
		DefaultKeyedValues keyValuesNegative = new DefaultKeyedValues();
		keyedValuesNegative = keyValuesNegative;
		keyValuesNegative.addValue((Comparable) 0.0, -5.0);
		keyValuesNegative.addValue((Comparable) 1.0, -9.0);
		keyValuesNegative.addValue((Comparable) 2.0, -2.0);
		
		DefaultKeyedValues expectedKeyValuesPosAndNeg = new DefaultKeyedValues();
		expectedKeyedValuesPosAndNeg = expectedKeyValuesPosAndNeg;
		expectedKeyValuesPosAndNeg.addValue((Comparable) 0.0, 0.3125);
		expectedKeyValuesPosAndNeg.addValue((Comparable) 1.0, 0.875);
		expectedKeyValuesPosAndNeg.addValue((Comparable) 2.0, 1.0);

		
		
		DefaultKeyedValues singleKeyValues = new DefaultKeyedValues();
		singleKeyedValues = singleKeyValues;
		singleKeyValues.addValue((Comparable) 0.0, 5.0);

		DefaultKeyedValues expectedSingleKeyValues = new DefaultKeyedValues();
		expectedSingleKeyedValues = expectedSingleKeyValues;
		expectedSingleKeyValues.addValue((Comparable) 0.0, 1.0);

		
		DefaultKeyedValues emptyKeyValues = new DefaultKeyedValues();
		emptyKeyedValues = emptyKeyValues;
		
		DefaultKeyedValues expectedEmptyKeyValues = new DefaultKeyedValues();
		expectedEmptyKeyedValues = expectedEmptyKeyValues;
		
	}

	@After
	public void tearDown() throws Exception {
		// testing rowTotal and columnTotal
		values2D = null;
		
		// testing createNumberArray
		doubleArrayPositive = null;
		expectedArrayPositive = null;
		doubleArrayNegative = null;
		expectedArrayNegative = null;
		doubleArrayZero = null;
		expectedArrayZero = null;
		doubleArrayMixture = null;
		expectedArrayMixture = null;
		doubleArraySingle = null;
		expectedArraySingle = null;
		
		// testing createNumberArray2D
		doubleArray2DPositive = null;
		expectedArray2DPositive = null;
		
		doubleArray2DNegative = null;
		expectedArray2DNegative = null;
		
		doubleArray2DZero = null;
		expectedArray2DZero = null;
		
		doubleArray2DMixture = null;
		expectedArray2DMixture = null;
		
		doubleArray2DSingle = null;
		expectedArray2DSingle = null;
		
		// testing getCumulativePercentages
		keyedValuesPositive = null;
		keyedValuesNegative = null;
		expectedKeyedValuesPosAndNeg = null;
		
		singleKeyedValues = null;
		expectedSingleKeyedValues = null;
	}
	
	
	
	
			// ----- getCumulativePercentages ----- //
//SECT	
	@Test
	public void testCumulativePercentagesWithPositiveData() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedKeyedValuesPosAndNeg, DataUtilities.getCumulativePercentages(keyedValuesPositive));
	}
	
	@Test
	public void testCumulativePercentagesWithNegativeData() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedKeyedValuesPosAndNeg, DataUtilities.getCumulativePercentages(keyedValuesNegative));
	}
	
	@Test
	public void testCumulativePercentagesWithNullData() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

//BVA
	@Test
	public void testCumulativePercentagesWithSingleKeyedValue() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedSingleKeyedValues, DataUtilities.getCumulativePercentages(singleKeyedValues));
	}
	
	@Test
	public void testCumulativePercentagesWithEmptyKeyedValue() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedEmptyKeyedValues, DataUtilities.getCumulativePercentages(emptyKeyedValues));
	}

	
	

			// ----- calculateColumnTotal ----- //
//SECT	
	@Test
	public void testColumnTotalWithValidDataAndNegativeColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, -5), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndValidColumn() {
		assertEquals("Incorrect Output. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);

	}
	
	@Test
	public void testColumnTotalWithValidDataAndTooLargeColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 11), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithNullDataAndNegativeColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, -6);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testColumnTotalWithNullDataAndValidColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testColumnTotalWithNullDataAndTooLargeColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 22);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
//BVA
	@Test
	public void testColumnTotalWithValidDataAndLowerBoundaryColumn() {
		assertEquals("Incorrect Output. It should be 9.0", 9.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);

	}
	
	@Test
	public void testColumnTotalWithValidDataAndUpperBoundaryColumn() {
		//assertEquals("Incorrect Output. It should be 32.0", 32.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d);
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 35.0", 35.0, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 37.0 for upper boundary index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndLowerBoundaryColumnPlus1() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for a negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndUpperBoundaryColumnMinus1() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output, It should be 37.0", 37.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	
	
			// ----- calculateRowTotal ----- //
//SECT
	@Test
	public void testRowTotalWithValidDataAndNegativeColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(values2D, -5), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testRowTotalWithValidDataAndValidRow() {
		assertEquals("Incorrect Output. It should be 21.0", 21.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndTooLargeRow() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(values2D, 11), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testRowTotalWithNullDataAndNegativeRow() {
		try {
			DataUtilities.calculateRowTotal(null, -6);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testRowTotalWithNullDataAndValidRow() {
		try {
			DataUtilities.calculateRowTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testRowTotalWithNullDataAndTooLargeRow() {
		try {
			DataUtilities.calculateRowTotal(null, 22);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown. It should be IllegalArgumentException", e.getClass().equals(IllegalArgumentException.class));
		}
	}

//BVA
	@Test
	public void testRowTotalWithValidDataAndLowerBoundaryRow() {
		assertEquals("Incorrect Output. It should be 30.0", 30.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndUpperBoundaryRow() {
		assertEquals("Incorrect Output. It should be 23.0", 23.0, DataUtilities.calculateRowTotal(values2D, 3), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndLowerBoundaryRowPlus1() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 21.0", 21.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for a negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testRowTotalWithValidDataAndUpperBoundaryRowMinus1() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output. It should be 12.0", 12.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}

	
	
	

			// ----- createNumberArray ----- //
//SECT
	@Test
	public void testCreateNumberArrayWithPositiveData() {
		assertArrayEquals("The output array does not match the input array", expectedArrayPositive, DataUtilities.createNumberArray(doubleArrayPositive));
	}
	
	@Test
	public void testCreateNumberArrayWithNegativeData() {
		assertArrayEquals("The output array does not match the input array", expectedArrayNegative, DataUtilities.createNumberArray(doubleArrayNegative));
	}
	
	@Test
	public void testCreateNumberArrayWithZeroData() {
		assertArrayEquals("The output array does not match the input array", expectedArrayZero, DataUtilities.createNumberArray(doubleArrayZero));
	}
	
	@Test
	public void testCreateNumberArrayWithMixtureData() {
		assertArrayEquals("The output array does not match the input array", expectedArrayMixture, DataUtilities.createNumberArray(doubleArrayMixture));
	}
	
	@Test
	public void testCreateNumberArrayWithNullData() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
//BVA
	@Test
	public void testCreateNumberArrayWithEmptyDoubleArray() {
		double[] emptyArray = new double[0];
		Number[] expectedEmpty = new Number[0];
		
		assertArrayEquals("The output array does not match the input array", expectedEmpty, DataUtilities.createNumberArray(emptyArray));
	}
	
	@Test
	public void testCreateNumberArrayWithSingleDoubleElement() {
		assertArrayEquals("The output array does not match the input array", expectedArraySingle, DataUtilities.createNumberArray(doubleArraySingle));
	}
	


	
	
		// ----- createNumberArray2D ----- //
//SECT	
	@Test
	public void testCreateNumberArray2DWithPositiveData() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DPositive, DataUtilities.createNumberArray2D(doubleArray2DPositive));
	}
	
	@Test
	public void testCreateNumberArray2DWithNegativeData() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DNegative, DataUtilities.createNumberArray2D(doubleArray2DNegative));
	}
	
	@Test
	public void testCreateNumberArray2DWithZeroData() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DZero, DataUtilities.createNumberArray2D(doubleArray2DZero));
	}
	
	@Test
	public void testCreateNumberArray2DWithMixtureData() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DMixture, DataUtilities.createNumberArray2D(doubleArray2DMixture));
	}
	
	@Test
	public void testCreateNumberArray2DWithNullData() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
//BVA
	@Test
	public void testCreateNumberArray2DWithEmpty2DDoubleArray() {
		double[][] emptyArray = new double[0][0];
		Number[][] expectedEmpty = new Number[0][0];
		
		assertArrayEquals("The output array does not match the input array", expectedEmpty, DataUtilities.createNumberArray2D(emptyArray));
	}
	
	@Test
	public void testCreateNumberArray2DWithSmallest2DDoubleArray() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DSingle, DataUtilities.createNumberArray2D(doubleArray2DSingle));
	}
	




}
