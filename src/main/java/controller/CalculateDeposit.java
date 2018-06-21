package controller;

import model.Deposit;

import java.util.ArrayList;
import java.util.List;

public class CalculateDeposit {
    public ArrayList<Deposit> listDeposit;
    public CalculateDeposit(ArrayList<Deposit> listDeposit) {
        this.listDeposit = listDeposit;
    }

    public void findBest(double startSumm, double monthlyPay, int maxDays) {

        List<Double> resultMoney =  new ArrayList<Double>();
        for (int i=0; i < listDeposit.size(); i++)
        {
            resultMoney.add(listDeposit.get(i).BackMoney(startSumm, monthlyPay, maxDays));
        }

        int indexOfMax = 0;
        for (int i = 1; i < resultMoney.size(); i++)
        {
            if (resultMoney.get(i)> resultMoney.get(indexOfMax))
            {
                indexOfMax = i;
            }
        }
        if(resultMoney.get(indexOfMax) == 0){
            System.out.println("No suitable banks found");
        }else{
            System.out.println("\n****************************************************************"
                    +"\nThe most profitable offer from the Bank: "+listDeposit.get(indexOfMax).getName()
                    +"\nProgram name: "+listDeposit.get(indexOfMax).getDepositName()
                    +"\nExpected profit: "+ resultMoney.get(indexOfMax)
                    +"\n****************************************************************");
        }
    }
}
