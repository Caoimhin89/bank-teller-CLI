import org.junit.Test;

import banking.project.DollarAmount;
import junit.framework.Assert;

public class DollarAmountTest {
	@Test
	public void getDollars_returns_the_number_of_old_dollars() {
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfDollars = anAmount.getDollars();
		Assert.assertEquals(12, numberOfDollars);
	}
	@Test
	public void getCents_returns_the_number_of_cents() {
		DollarAmount anAmount = new DollarAmount(1234);
		long numberOfCents = anAmount.getCents();
		Assert.assertEquals(34, numberOfCents);
	}
	
	@Test
	public void isGreaterThan_returns_true_for_lesser_amounts() {
		DollarAmount firstAmount = new DollarAmount(1234);
		DollarAmount secondAmount = new DollarAmount(1233);
		Assert.assertTrue(firstAmount.isGreaterThan(secondAmount));
		Assert.assertFalse(secondAmount.isGreaterThan(firstAmount));
	}
	
	@Test
	public void return_total_amount_in_cents_from_dollar_amount() {
		DollarAmount dollars = new DollarAmount(123456);
		long someCents = dollars.getTotalAmountInCents();
		Assert.assertEquals(123456, someCents);
	}
	
	@Test
	public void isLessThan_returns_true_for_greater_amounts() {
		DollarAmount originalDollars = new DollarAmount(50000);
		DollarAmount comparableDollars = new DollarAmount(60000);
		Assert.assertTrue(originalDollars.isLessThan(comparableDollars));
		Assert.assertFalse(comparableDollars.isLessThan(originalDollars));
	}
	
	@Test
	public void isNegative_returns_true_for_totalAmountInCents_below_zero() {
		DollarAmount negative = new DollarAmount(-1234);
		DollarAmount positive = new DollarAmount(12345);
		boolean isNegative = negative.isNegative();
		Assert.assertTrue(isNegative);
		Assert.assertFalse(positive.isNegative());
	}
	
	@Test
	public void plus_returns_sum_of_two_DollarAmounts() {
		DollarAmount first = new DollarAmount(123);
		DollarAmount second = new DollarAmount(123);
		DollarAmount sum = first.plus(second);
		Assert.assertTrue(sum.equals(new DollarAmount(246)));
	}
	
	@Test 
	public void minus_returns_difference_of_two_DollarAmounts() {
		DollarAmount first = new DollarAmount(246);
		DollarAmount second = new DollarAmount(123);
		DollarAmount difference = first.minus(second);
		Assert.assertEquals(new DollarAmount(123), difference);
	}
	
	@Test
	public void dollar_amounts_sorted_by_quantitative_relationship() {
		DollarAmount original = new DollarAmount(5000);
		DollarAmount larger = new DollarAmount(6000);
		DollarAmount smaller = new DollarAmount(4000);
		DollarAmount equivilant = new DollarAmount(5000);
		Assert.assertTrue(original.compareTo(larger) == -1);
		Assert.assertTrue(original.compareTo(smaller) == 1);
		Assert.assertTrue(original.compareTo(equivilant) == 0);
	}
	
	@Test
	public void equals_returns_true_for_equality() {
		DollarAmount firstAmount = new DollarAmount(123);
		DollarAmount secondAmount = new DollarAmount(123);
		DollarAmount thirdAmount = new DollarAmount(321);
		Assert.assertEquals(firstAmount, secondAmount);
	}
	@Test
	public void equals_returns_false_if_parameter_not_an_instance_of_DollarAmount() {
		DollarAmount firstAmount = new DollarAmount(123);
		String myString = new String("Hello");
		boolean returnsFalse = firstAmount.equals(myString);
		Assert.assertFalse(returnsFalse);
	}
	
	@Test
	public void toString_method_turns_DollarAmount_into_readable_String() {
		DollarAmount myMoney = new DollarAmount(50000);
		String myMoneyString = myMoney.toString();
		Assert.assertEquals("$500.0", myMoneyString);
	}
	
	@Test
	public void hashCode_method_returns_unique_hashCode_equal_to_totalAmountInCents() {
		DollarAmount someMoney = new DollarAmount(50000);
		int hash = someMoney.hashCode();
		long lotsOfPennies = someMoney.getTotalAmountInCents();
		Assert.assertEquals(lotsOfPennies, hash);
	}
}
