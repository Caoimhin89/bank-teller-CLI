
public class DollarAmount {
private long totalAmountInCents;

public DollarAmount(long totalAmountInCents){
	this.totalAmountInCents= totalAmountInCents;
}
public DollarAmount(long dollars, int cents){
	this.totalAmountInCents= dollars * 100 + cents;
}
public int getCents(){
	return (int) (totalAmountInCents % 100);
}
public long getDollars(){
	return totalAmountInCents / 100;
}
public boolean isEqualTo(DollarAmount dollarAmountToCompare){
	if(totalAmountInCents == dollarAmountToCompare.totalAmountInCents){
		return true;
	}else{
		return false;
	}
}

public boolean isLessThan(DollarAmount dollarAmountToCompare){
	if(totalAmountInCents < dollarAmountToCompare.totalAmountInCents){
		return true;
	}else{
		return false;
	}
}
public boolean isGreaterThan(DollarAmount dollarAmountToCompare){
	if(totalAmountInCents > dollarAmountToCompare.totalAmountInCents){
		return true;
	}else{
		return false;
	}
}
public boolean isNegative(){
	if(totalAmountInCents < 0){
	return true;
	}else{
		return false;
	}
}
public DollarAmount plus(DollarAmount dollarAmountToAdd){
	DollarAmount someMoney = new DollarAmount(this.totalAmountInCents + dollarAmountToAdd.totalAmountInCents);
	   return someMoney;
}
public DollarAmount minus(DollarAmount dollarAmountToAdd){
	DollarAmount someMoney = new DollarAmount(this.totalAmountInCents - dollarAmountToAdd.totalAmountInCents);
	   return someMoney;
}
}
