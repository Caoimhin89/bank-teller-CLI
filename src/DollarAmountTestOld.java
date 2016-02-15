

public class DollarAmountTestOld {

	public static void main(String[] args) {
		DollarAmount myMoney =new DollarAmount(2123);
		DollarAmount yourMoney= new DollarAmount (20);
		System.out.println(myMoney.getCents());
		System.out.println(myMoney.getDollars());
		System.out.println(myMoney.isLessThan(yourMoney));
		System.out.println(myMoney.isGreaterThan(yourMoney));
		System.out.println(myMoney.isNegative());
		DollarAmount ourMoney= myMoney.plus(yourMoney);
		System.out.println(ourMoney.getCents());
		System.out.println(ourMoney.getDollars());
		ourMoney = myMoney.minus(yourMoney);
		System.out.println(ourMoney.getCents());
		System.out.println(ourMoney.getDollars());
		
		System.out.println();
		
		System.out.println(myMoney.toString());
		System.out.println(myMoney.hashCode());
		System.out.println(myMoney.equals(yourMoney));
		
	}

}
