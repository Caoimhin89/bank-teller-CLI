

public class DollarAmount implements Comparable<DollarAmount> {
	private long totalAmountInCents;

	public DollarAmount(long totalAmountInCents) {
		this.totalAmountInCents = totalAmountInCents;
	}

	public DollarAmount(long dollars, int cents) {
		this.totalAmountInCents = dollars * 100 + cents;
	}
	
	public long getTotalAmountInCents() {
		return this.totalAmountInCents;
	}

	public int getCents() {
		return (int) (this.totalAmountInCents % 100);
	}

	public long getDollars() {
		return this.totalAmountInCents / 100;
	}

	public boolean isLessThan(DollarAmount dollarAmountToCompare) {
		if (this.totalAmountInCents < dollarAmountToCompare.totalAmountInCents) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isGreaterThan(DollarAmount dollarAmountToCompare) {
		if (this.totalAmountInCents > dollarAmountToCompare.totalAmountInCents) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNegative() {
		if (this.totalAmountInCents < 0) {
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
	
	public boolean equals(Object obj) {
		if(obj instanceof DollarAmount) {
			if(this.getTotalAmountInCents() == ((DollarAmount) obj).getTotalAmountInCents()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "$" + this.getDollars() + "." + this.getCents();
	}
	
	public int hashCode() {
		return (int) this.getTotalAmountInCents();
	}
}
