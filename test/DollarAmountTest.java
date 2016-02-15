import org.junit.Test;

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
	}
}
