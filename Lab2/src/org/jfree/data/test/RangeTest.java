package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class RangeTest {
	
	//testing combine 
	private Range range1;
	private Range range2;
	private Range expectedRange;
	
	private Range expectedRangeNullRange1;
	
	private Range expectedRangeNullRange2;
	
	private Range doubleMinRange;
	private Range doubleMinExpectedRange;
	
	private Range doubleMaxRange;
	private Range doubleMaxExpectedRange;
	
	private Range doubleMaxMinRange;
	private Range expectedDoubleMaxMinRange;
	
	
	//testing constrain 
	private Range constrainRange;
	double 	delta;

	
	//testing expandToInclude
	private Range rangeToExpand1;	
	private Range expectedExpandToIncludeOutsideRangeLeft;
	
	private Range rangeToExpand2;
	private Range expectedExpandToIncludeLowerBoundRange;
	
	private Range rangeToExpand3;
	private Range expectedExpandToIncludeInsideRange;
	
	private Range rangeToExpand4;
	private Range expectedExpandToIncludeUpperBoundRange;
	
	private Range rangeToExpand5;
	private Range expectedExpandToIncludeOutsideRangeRight;
	
	private Range rangeToExpand6;
	private Range expectedExpandToIncludeLowerBoundMinus1;
	
	private Range rangeToExpand7;
	private Range expectedExpandToIncludeLowerBoundPlus1;
	
	private Range rangeToExpand8;
	private Range expectedExpandToIncludeUpperBoundMinus1;
	
	private Range rangeToExpand9;
	private Range expectedExpandToIncludeUpperBoundPlus1;

	
	//testing getLowerBound and getUpperBound
	private Range samePositiveRange;
	
	private Range bothPositiveRange;
	
	private Range sameNegativeRange;
	
	private Range bothNegativeRange;
	
	private Range mixedRange;
	
	
	@Before
	public void setUp() throws Exception {
		
		//testing combine
		range1 = new Range(30,100);
		range2 = new Range(-18, 20);
		
		expectedRange = new Range(-18, 100);
		
		
		expectedRangeNullRange1 = new Range(-18, 20);
		
		expectedRangeNullRange2 = new Range(30,100);
		
		doubleMinRange = new Range(Double.MIN_VALUE, 40);
		doubleMinExpectedRange = new Range(-18, 40);
		
		doubleMaxRange = new Range(35, Double.MAX_VALUE);
		doubleMaxExpectedRange = new Range(30, Double.MAX_VALUE);
		
		doubleMaxMinRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		expectedDoubleMaxMinRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		
		//testing constrain
		constrainRange = new Range(30,100);
		delta = 0.000000001d;
		
		//testing expandToInclude
		rangeToExpand1 = new Range(-15.02, 20);
		expectedExpandToIncludeOutsideRangeLeft = new Range(-20, 20);
		
		rangeToExpand2 = new Range(-15.02, 20);
		expectedExpandToIncludeLowerBoundRange = new Range(-15.02, 20);
		
		rangeToExpand3 = new Range(-15.02, 20);
		expectedExpandToIncludeInsideRange = new Range(-15.02, 20);
		
		rangeToExpand4 = new Range(-15.02, 20);
		expectedExpandToIncludeUpperBoundRange = new Range(-15.02, 20);
		
		rangeToExpand5 = new Range(-15.02, 20);
		expectedExpandToIncludeOutsideRangeRight = new Range(-15.02, 29.9);
		
		rangeToExpand6 = new Range(-15.02, 20);
		expectedExpandToIncludeLowerBoundMinus1 = new Range(-16.02, 20);
		
		rangeToExpand7 = new Range(-15.02, 20);
		expectedExpandToIncludeLowerBoundPlus1 = new Range(-15.02, 20);
		
		rangeToExpand8 = new Range(-15.02, 20);
		expectedExpandToIncludeUpperBoundMinus1 = new Range(-15.02, 20);
		
		rangeToExpand9 = new Range(-15.02, 20);
		expectedExpandToIncludeUpperBoundPlus1 = new Range(-15.02, 21);
		
		//testing getLowerBound and getUpperBound
		samePositiveRange = new Range(12, 12);
		
		bothPositiveRange = new Range(12, 20);
		
		sameNegativeRange = new Range(-23,-23);
		
		bothNegativeRange = new Range(-23, -4);
		
		mixedRange = new Range(-2, 30);

	}

	@After
	public void tearDown() throws Exception {
		
		//testing combine
		range1 = null;
		range2 = null;
		expectedRange = null;
		
		expectedRangeNullRange1 = null;
		
		expectedRangeNullRange2 = null;
		
		doubleMinRange = null;
		doubleMinExpectedRange = null;
		
		doubleMaxRange = null;
		doubleMaxExpectedRange = null;
		
		doubleMaxMinRange = null;
		expectedDoubleMaxMinRange = null;
		
		//testing constrain
		constrainRange = null;
		
		//testing expandToInclude	
		rangeToExpand1 = null;		
		expectedExpandToIncludeOutsideRangeLeft = null;
		
		expectedExpandToIncludeLowerBoundRange = null;
		
		expectedExpandToIncludeInsideRange = null;
		
		expectedExpandToIncludeUpperBoundRange = null;
		
		expectedExpandToIncludeOutsideRangeRight = null;
		
		expectedExpandToIncludeLowerBoundMinus1 = null;
		
		expectedExpandToIncludeLowerBoundPlus1 = null;
		
		expectedExpandToIncludeUpperBoundMinus1 = null;
		
		expectedExpandToIncludeUpperBoundPlus1 = null;
		
		//testing getLowerBound and getUpperBound
		samePositiveRange = null;
		
		bothPositiveRange = null;
		
		sameNegativeRange = null;
		
		bothNegativeRange = null;
		
		mixedRange = null;		
		
	}
	
	//---------------combine-----------------//
	
	//SECT	
	@Test
	public void testCombineValidRanges() {
		assertEquals("New range doesnot match expected range", expectedRange, Range.combine(range1, range2));
	}
	
	@Test
	public void testCombineRange1Null() {
		assertEquals("New range does not match expected range", expectedRangeNullRange1, Range.combine(null, range2));
	}
	
	@Test
	public void testCombineRange2Null() {
		assertEquals("New range does not match expected range", expectedRangeNullRange2, Range.combine(range1, null));
	}
	
	@Test
	public void testCombineRangesNull() {
		assertEquals("New range does not match expected range", null, Range.combine(null, null));
	}
	
	//BVA
	@Test
	public void testCombineRangeDoubleMinValue() {
		assertEquals("New range does not match expected range", doubleMinExpectedRange, Range.combine(doubleMinRange, range2));
	}
	
	@Test
	public void testCombineRangeDoubleMaxValue() {
		assertEquals("New range does not match expected range", doubleMaxExpectedRange, Range.combine(doubleMaxRange, range1));
	}
	
	@Test
	public void testCombineRangeDoubleMinMaxValue() {
		assertEquals("New range does not match expected range", expectedDoubleMaxMinRange, Range.combine(range1, doubleMaxMinRange));
	}
	
	
	
	//----------constrain--------------------//
	//SECT
	@Test
	public void testConstrainOutsideRangeLeft() {
		assertEquals("double does not match expected double", 30.0, constrainRange.constrain(18), delta );
	}
	
	@Test
	public void testConstrainLowerBoundRange() {
		assertEquals("double does not match expected double", 30.0, constrainRange.constrain(30), delta );
	}
	
	@Test
	public void testConstrainInsideRange() {
		assertEquals("double does not match expected double", 69.9, constrainRange.constrain(69.9), delta );
	}
	
	@Test
	public void testConstrainUpperBoundRange() {
		assertEquals("double does not match expected double", 100.0, constrainRange.constrain(100), delta );
	}
	
	@Test
	public void testConstrainOutsideRangeRight() {
		assertEquals("double does not match expected double", 100.0, constrainRange.constrain(103.2), delta );
	}
	
	//BVA
	@Test
	public void testConstrainOutsideLowerBound() {
		assertEquals("double does not match expected double", 30.0, constrainRange.constrain(29), delta );
	}
	
	@Test
	public void testConstrainInsideLowerBound() {
		assertEquals("double does not match expected double", 31.0, constrainRange.constrain(31), delta );
	}
	
	@Test
	public void testConstrainOutsideUpperBound() {
		assertEquals("double does not match expected double", 100.0, constrainRange.constrain(101), delta );
	}
	
	@Test
	public void testConstrainInsideUpperBound() {
		assertEquals("double does not match expected double", 99.0, constrainRange.constrain(99), delta );
	}
	
	
	
	//-------------expandToInclude---------------//
	//SECT
	@Test
	public void testExpandToIncludeOutsideRangeLeft() {
		assertEquals("range does not match expected range", expectedExpandToIncludeOutsideRangeLeft, Range.expandToInclude(rangeToExpand1, -20));
	}
	
	@Test
	public void testExpandToIncludeLowerBoundRange() {
		//assertEquals("range does not match expected range", expectedExpandToIncludeLowerBoundRange, Range.expandToInclude(rangeToExpand, -15.02));
		try {
	        // Check if the result is as expected
			assertEquals("range does not match expected range", expectedExpandToIncludeLowerBoundRange, Range.expandToInclude(rangeToExpand2, -15.02));
	    } catch (IllegalArgumentException e) {
	        // Fail the test with a custom message if an IndexOutOfBoundsException is caught
	        fail("Incorrect output - Expected method to return (-15.02, 20) for the range, but it threw an IllegalArgumentException");
	    }
	}
	
	@Test
	public void testExpandToIncludeInsideRange() {
		assertEquals("range does not match expected range", expectedExpandToIncludeInsideRange, Range.expandToInclude(rangeToExpand3, 0));
	}
	
	@Test
	public void testExpandToIncludeUpperBoundRange() {
		assertEquals("range does not match expected range", expectedExpandToIncludeUpperBoundRange, Range.expandToInclude(rangeToExpand4, 20));
	}
	
	@Test
	public void testExpandToIncludeOutsideRangeRight() {
		assertEquals("range does not match expected range", expectedExpandToIncludeOutsideRangeRight, Range.expandToInclude(rangeToExpand5, 29.9));
	}
	
	@Test
	public void testExpandToIncludeOutsideNullRangeLeft() {
		assertEquals("range does not match expected range", null, Range.expandToInclude(null, -20));
	}
	
	@Test
	public void testExpandToIncludeLowerBoundNullRange() {
		assertEquals("range does not match expected range", null, Range.expandToInclude(null, -15.02));
	}
	
	@Test
	public void testExpandToIncludeInsideNullRange() {
		assertEquals("range does not match expected range", null, Range.expandToInclude(null, 0));
	}
	
	@Test
	public void testExpandToIncludeUpperBoundNullRange() {
		assertEquals("range does not match expected range", null, Range.expandToInclude(null, 20));
	}
	
	@Test
	public void testExpandToIncludeOutsideNullRangeRight() {
		assertEquals("range does not match expected range", null, Range.expandToInclude(null, 29.9));
	}
	
	//BVA
	
	@Test
	public void testExpandToIncludeLowerBoundMinus1() {
		assertEquals("range does not match expected range", expectedExpandToIncludeLowerBoundMinus1, Range.expandToInclude(rangeToExpand6, -16.02));
	}
	
	@Test
	public void testExpandToIncludeLowerBoundPlus1() {
		assertEquals("range does not match expected range", expectedExpandToIncludeLowerBoundPlus1, Range.expandToInclude(rangeToExpand7, -14.02));
	}
	
	@Test
	public void testExpandToIncludeUpperBoundMinus1() {
		assertEquals("range does not match expected range", expectedExpandToIncludeUpperBoundMinus1, Range.expandToInclude(rangeToExpand8, 19));
	}
	
	@Test
	public void testExpandToIncludeUpperBoundPlus1() {
		assertEquals("range does not match expected range", expectedExpandToIncludeUpperBoundPlus1, Range.expandToInclude(rangeToExpand9, 21));
	}
	
	
	
	//----------getLowerBound-----------------//
	//SECT
	@Test
	public void testGetLowerBoundSamePositiveRange() {
		assertEquals("double does not match expected double", 12.0, samePositiveRange.getLowerBound(), delta );
	}
	
	@Test
	public void testGetLowerBoundBothPositiveRange() {
		assertEquals("double does not match expected double", 12.0, bothPositiveRange.getLowerBound(), delta );
	}
	
	@Test
	public void testGetLowerBoundSameNegativeRange() {
		assertEquals("double does not match expected double", -23.0, sameNegativeRange.getLowerBound(), delta );
	}
	
	@Test
	public void testGetLowerBoundBothNegativeRange() {
		assertEquals("double does not match expected double", -23.0, bothNegativeRange.getLowerBound(), delta );
	}
	
	@Test
	public void testGetLowerBoundMixedRange() {
		assertEquals("double does not match expected double", -2.0, mixedRange.getLowerBound(), delta );
	}
	
	
	//----------getUpperBound-----------------//
	//SECT
	@Test
	public void testGetUpperBoundSamePositiveRange() {
		assertEquals("double does not match expected double", 12, samePositiveRange.getUpperBound(), delta );
	}
	
	@Test
	public void testGetUpperBoundBothPositiveRange() {
		assertEquals("double does not match expected double", 20.0, bothPositiveRange.getUpperBound(), delta );
	}
	
	@Test
	public void testGetUpperBoundSameNegativeRange() {
		assertEquals("double does not match expected double", -23.0, sameNegativeRange.getUpperBound(), delta );
	}
	
	@Test
	public void testGetUpperBoundBothNegativeRange() {
		assertEquals("double does not match expected double", -4.0, bothNegativeRange.getUpperBound(), delta );
	}
	
	@Test
	public void testGetUpperBoundMixedRange() {
		assertEquals("double does not match expected double", 30.0, mixedRange.getUpperBound(), delta );
	}





}
