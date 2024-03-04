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
	private double[] doubleArray = new double[3];
	private Number[] expectedArray = new Number[3];
	
	private double[] doubleArraySingle;
    private Number[] expectedArraySingle;
    
    private double[] doubleArrayMinValue;
    private Number[] expectedArrayMinValue;
    
    private double[] doubleArrayMaxValue;
    private Number[] expectedArrayMaxValue;
    
    // testing createNumberArray2D
    private double[][] doubleArray2D = new double[2][3];
    private Number[][] expectedArray2D = new Number[2][3];
    
	private double[][] doubleArray2DSingle;
    private Number[][] expectedArray2DSingle;
    
    private double[][] doubleArray2DMinValue;
    private Number[][] expectedArray2DMinValue;
    
    private double[][] doubleArray2DMaxValue;
    private Number[][] expectedArray2DMaxValue;
    
    
    // testing getCumulativePercentages
    private KeyedValues keyedValues;
    private KeyedValues expectedKeyedValues;
    
    private KeyedValues singleKeyedValues;
    private KeyedValues expectedSingleKeyedValues;
    
    private KeyedValues emptyKeyedValues;
    private KeyedValues expectedEmptyKeyedValues;
 
    private KeyedValues maxKeyedValues;
    private KeyedValues minKeyedValues;
	

	@Before
	public void setUp() throws Exception {
		// testing rowTotal and columnTotal
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		// set the 1st column
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
		testValues.addValue(7, 2, 0);
		// set the 2nd column
		testValues.addValue(5, 0, 1);
		testValues.addValue(-10, 1, 1);
		testValues.addValue(0, 2, 1);
		// set the 3rd column
		testValues.addValue(9, 0, 2);
		testValues.addValue(23, 1, 2);
		testValues.addValue(0, 2, 2);
		
		// testing createNumberArray
		doubleArray = new double[] {1.0, 5.0, 9.0};
		expectedArray = new Number[] {1.0, 5.0, 9.0};
		
		doubleArraySingle = new double[] {5.0};
		expectedArraySingle = new Number[] {5.0};
		
		doubleArrayMinValue = new double[] {Double.MIN_VALUE};
		expectedArrayMinValue = new Number[] {Double.MIN_VALUE};
		
		doubleArrayMaxValue = new double[] {Double.MAX_VALUE};
		expectedArrayMaxValue = new Number[] {Double.MAX_VALUE};
		
		// testing createNumberArray2D
		doubleArray2D = new double[][]{
		    {1.0, 5.0, 9.0},
		    {1.0, 4.0, 7.0}
		};
		expectedArray2D = new Number[][]{
		    {1.0, 5.0, 9.0},
		    {1.0, 4.0, 7.0}
		};
		
		doubleArray2DSingle = new double[][] {{9.0}};
		expectedArray2DSingle = new Number[][] {{9.0}};
		
		doubleArray2DMinValue = new double[][] {{Double.MIN_VALUE}};
		expectedArray2DMinValue = new Number[][] {{Double.MIN_VALUE}};
		
		doubleArray2DMaxValue = new double[][] {{Double.MAX_VALUE}};
		expectedArray2DMaxValue = new Number[][] {{Double.MAX_VALUE}};
		
		// testing getCumulativePercentages
		DefaultKeyedValues keyValues = new DefaultKeyedValues();
		keyedValues = keyValues;
		keyValues.addValue((Comparable) 0.0, 5.0);
		keyValues.addValue((Comparable) 1.0, 9.0);
		keyValues.addValue((Comparable) 2.0, 2.0);

		DefaultKeyedValues expectedKeyValues = new DefaultKeyedValues();
		expectedKeyedValues = expectedKeyValues;
		expectedKeyValues.addValue((Comparable) 0.0, 0.3125);
		expectedKeyValues.addValue((Comparable) 1.0, 0.875);
		expectedKeyValues.addValue((Comparable) 2.0, 1.0);
		
		
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
		
		
		DefaultKeyedValues minKeyValues = new DefaultKeyedValues();
		minKeyedValues = minKeyValues;
		minKeyValues.addValue((Comparable) 0.0, Double.MIN_VALUE);

		DefaultKeyedValues maxKeyValues = new DefaultKeyedValues();
		maxKeyedValues = maxKeyValues;
		maxKeyValues.addValue((Comparable) 0.0, Double.MAX_VALUE);
		
		// testGetCumulativePercentages
		/*
		 * DefaultKeyedValues keyValues = new DefaultKeyedValues();
		 * keyValues.addValue((Comparable) 0.0, 6.0); keyValues.addValue((Comparable)
		 * 1.0, 11.0); keyValues.addValue((Comparable) 2.0, 3.0); object_under_test =
		 * DataUtilities.getCumulativePercentages((KeyedValues) keyValues);
		 */
		
	}

	@After
	public void tearDown() throws Exception {
		// testing rowTotal and columnTotal
		values2D = null;
		
		// testing createNumberArray
		doubleArray = null;
		expectedArray = null;
		doubleArraySingle = null;
		expectedArraySingle = null;
		doubleArrayMinValue = null;
		expectedArrayMinValue = null;
		doubleArrayMaxValue = null;
		expectedArrayMaxValue = null;
		
		// testing createNumberArray2D
		doubleArray2D = null;
		expectedArray2D = null;
		doubleArray2DSingle = null;
		expectedArray2DSingle = null;
		doubleArray2DMinValue = null;
		expectedArray2DMinValue = null;
		doubleArray2DMaxValue = null;
		expectedArray2DMaxValue = null;
		
		// testing getCumulativePercentages
		keyedValues = null;
		expectedKeyedValues = null;
	}
	
			// ----- getCumulativePercentages ----- //
//SECT	
	@Test
	public void testCumulativePercentagesWithValidData() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedKeyedValues, DataUtilities.getCumulativePercentages(keyedValues));
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
	
	@Test
	public void testCumulativePercentagesWithMinimumKeyedValue() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedSingleKeyedValues, DataUtilities.getCumulativePercentages(minKeyedValues));
	}
	
	@Test
	public void testCumulativePercentagesWithMaximumKeyedValue() {
		assertEquals("The output KeyedValues object does not match the expected KeyedValues object", expectedSingleKeyedValues, DataUtilities.getCumulativePercentages(maxKeyedValues));
	}
	

			// ----- calculateColumnTotal ----- //
//SECT	
	@Test
	public void testColumnTotalWithValidDataAndNegativeColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateColumnTotal(values2D, -5), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndValidColumn() {
		assertEquals("Incorrect Output. It should be -5.0", -5.0, DataUtilities.calculateColumnTotal(values2D, 1), 0.0000001d);

	}
	
	@Test
	public void testColumnTotalWithValidDataAndTooLargeColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateColumnTotal(values2D, 11), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithInvalidDataAndNegativeColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, -6);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testColumnTotalWithInvalidDataAndValidColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testColumnTotalWithInvalidDataAndTooLargeColumn() {
		try {
			DataUtilities.calculateColumnTotal(null, 22);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
//BVA
	@Test
	public void testColumnTotalWithValidDataAndLowerBoundaryColumn() {
		assertEquals("Incorrect Output. It should be 12.0", 12.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);

	}
	
	@Test
	public void testColumnTotalWithValidDataAndUpperBoundaryColumn() {
		//assertEquals("Incorrect Output. It should be 32.0", 32.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d);
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 32.0, DataUtilities.calculateColumnTotal(values2D, 2), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 32.0 for upper boundary index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndJustBelowLowerBoundaryColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateColumnTotal(values2D, -1), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for a negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testColumnTotalWithValidDataAndJustAboveUpperBoundaryColumn() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateColumnTotal(values2D, 3), 0.0000001d);
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
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateRowTotal(values2D, -5), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testRowTotalWithValidDataAndValidRow() {
		assertEquals("Incorrect Output. It should be 17.0", 17.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndTooLargeRow() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateRowTotal(values2D, 11), 0.0000001d);
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
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testRowTotalWithNullDataAndValidRow() {
		try {
			DataUtilities.calculateRowTotal(null, 1);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testRowTotalWithInvalidDataAndNegativeRow() {
		try {
			DataUtilities.calculateRowTotal(null, 22);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
			
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}

//BVA
	@Test
	public void testRowTotalWithValidDataAndLowerBoundaryRow() {
		assertEquals("Incorrect Output. It should be 15.0", 15.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndUpperBoundaryRow() {
		assertEquals("Incorrect Output. It should be 7.0", 7.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
	}
	
	@Test
	public void testRowTotalWithValidDataAndJustBelowLowerBoundaryRow() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for a negative index, but it threw an IndexOutOfBoundsException");
	    }
	}
	
	@Test
	public void testRowTotalWithValidDataAndJustAboveUpperBoundaryRow() {
	    try {
	        // Check if the result is as expected
	        assertEquals("Incorrect output", 0.0, DataUtilities.calculateRowTotal(values2D, 3), 0.0000001d);
	    } catch (IndexOutOfBoundsException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return 0.0 for too large of an index, but it threw an IndexOutOfBoundsException");
	    }
	}


			// ----- createNumberArray ----- //
//SECT
	@Test
	public void testCreateNumberArrayWithValidData() {
		assertArrayEquals("The output array does not match the input array", expectedArray, DataUtilities.createNumberArray(doubleArray));
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
	
	@Test
	public void testCreateNumberArrayWithMinimumDoubleElement() {
		assertArrayEquals("The output array does not match the input array", expectedArrayMinValue, DataUtilities.createNumberArray(doubleArrayMinValue));
	}
	
	@Test
	public void testCreateNumberArrayWithMaximumDoubleElement() {
		assertArrayEquals("The output array does not match the input array", expectedArrayMaxValue, DataUtilities.createNumberArray(doubleArrayMaxValue));
	}

	
		// ----- createNumberArray2D ----- //
//SECT	
	@Test
	public void testCreateNumberArray2DWithValidData() {
		assertArrayEquals("The output array does not match the input array", expectedArray2D, DataUtilities.createNumberArray2D(doubleArray2D));
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
	
	@Test
	public void testCreateNumberArray2DWithMinimumDoubleElement() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DMinValue, DataUtilities.createNumberArray2D(doubleArray2DMinValue));
	}
	
	@Test
	public void testCreateNumberArray2DWithMaximumDoubleElement() {
		assertArrayEquals("The output array does not match the input array", expectedArray2DMaxValue, DataUtilities.createNumberArray2D(doubleArray2DMaxValue));
	}

}
