
/*
 * 2)
 * You are required to modify the code to make the function of computing frequent 
 * rental points into a strategy design pattern (That is, you will have strategy 
 * classes to compute frequent rental points).
 * 
 */

interface Points {
	
	int calculate();
	
}

class RenterPoints implements Points {

	@Override
	public int calculate() {
		return 1;
	}
}

class RenterPointsBonus implements Points {

	@Override
	public int calculate() {
		return 2;
	}
}
