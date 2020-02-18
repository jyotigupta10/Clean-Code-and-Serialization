package come.homeTask.Clean_Code.Task2_Cost_Estimation;
import java.util.*;

class InterestCalculate
{
	public double calculateSI(double principal, double rate, int time)
	{
		return ((principal * rate * time)/100);
	}
	
	public double calculateCI(double principal, double rate, int time)
	{
		double amount = principal * Math.pow(1 + rate/100,time);
		return (amount - principal);
	}
	
}

class CostEstimation
{
	public double houseConstructionCost(int materialStandard, double areaOfHouse, boolean fullyAutomated)
	{
		double cost;
		if(materialStandard == 0)
			cost = 1200 * areaOfHouse;
		else if(materialStandard == 1)
			cost = 1500 * areaOfHouse;
		else
		{
			if(fullyAutomated)
				cost = 2500 * areaOfHouse;
			else
				cost = 1800 * areaOfHouse;
		}
		return cost;
	}
}

public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("Enter Principal");
        double principal = sc.nextDouble();
        
        System.out.println("Enter Rate");
        double rate = sc.nextDouble();
        
        System.out.println("Enter Time");
        int time = sc.nextInt();
        
        InterestCalculate interestCalculate = new InterestCalculate();
        double SI = interestCalculate.calculateSI(principal, rate, time);
        double CI = interestCalculate.calculateCI(principal, rate, time);
        
        System.out.println("Simple Interest: " + SI);
        System.out.println("Compound Interest: " + CI);
        
        System.out.println();
        System.out.println("Estimation of House Construction Cost");
        
        System.out.println("Choose House Material");
        System.out.println("0 - Standard Material");
        System.out.println("1 - Above Standard Material");
        System.out.println("2 - High Standard Material");
        int materialStandard = sc.nextInt();
        
        System.out.println("Area of House");
        double areaOfHouse = sc.nextDouble();
        
        boolean fullyAutomated = false;
        if(materialStandard == 2)
        {
        	System.out.println("Do you want Fully Automated Home: If Yes then Press Y else N");
            fullyAutomated = (sc.next().equals("Y"));
        }
        
        CostEstimation costEstimate = new CostEstimation();
        double cost = costEstimate.houseConstructionCost(materialStandard, areaOfHouse, fullyAutomated);
        System.out.println("Estimated House Construction Cost: " + cost);
    }
}
