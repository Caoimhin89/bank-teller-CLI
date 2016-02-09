
public class DollarAmount implements Comparable<DollarAmount> {
	private long totalAmountInCents;

	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}

	public DollarAmount(long dollars, int cents) {
		this.totalAmountInCents = dollars * 100 + cents;
	}

	public int getCents() {
		return (int) (totalAmountInCents % 100);
	}

	public long getDollars() {
		return totalAmountInCents / 100;
	}

	public boolean isEqualTo(DollarAmount dollarAmountToCompare) {
		if (totalAmountInCents == dollarAmountToCompare.totalAmountInCents) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isLessThan(DollarAmount dollarAmountToCompare) {
		if (totalAmountInCents < dollarAmountToCompare.totalAmountInCents) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGreaterThan(DollarAmount dollarAmountToCompare) {
		if (totalAmountInCents > dollarAmountToCompare.totalAmountInCents) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNegative() {
		if (totalAmountInCents < 0) {
			return true;
		} else {
			return false;
		}
	}

	public DollarAmount plus(DollarAmount dollarAmountToAdd) {
		DollarAmount someMoney = new DollarAmount(this.totalAmountInCents + dollarAmountToAdd.totalAmountInCents);
		return someMoney;
	}

	public DollarAmount minus(DollarAmount dollarAmountToSubtract) {
		DollarAmount someMoney = new DollarAmount(this.totalAmountInCents - dollarAmountToSubtract.totalAmountInCents);
		return someMoney;
	}

	public int compareTo(DollarAmount o) {
		if (this.totalAmountInCents > o.totalAmountInCents) {
			return 1;
		} else if (this.totalAmountInCents < o.totalAmountInCents) {
			return -1;
		}
		return 0;
	}
}
