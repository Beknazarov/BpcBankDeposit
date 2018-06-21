package model;

public class Deposit {

    private String name;
    private double interestRate;
    private double entryBonus;
    private String depositName;
    private double minAmnt;
    private int maxDepTime;
    private int minDepTime;
    private CapitulationType capitalationType;

    public Deposit(double minAmnt, CapitulationType capitalationType, double interestRate, int maxTime,
                   String name, double entryBonus, int minTime, String depositName) {
        this.minAmnt = minAmnt;
        this.capitalationType = capitalationType;
        this.interestRate = interestRate;
        this.maxDepTime = maxTime;
        this.name = name;
        this.entryBonus = entryBonus;
        this.minDepTime = minTime;
        this.depositName = depositName;
    }

    public double BackMoney(double startSumm, double monthlyPay, int maxDays) {
        double returnMoney = 0;
        if (maxDays <= this.getMaxDepTime() && startSumm >= this.getMinAmnt()) {
            startSumm += startSumm * this.entryBonus / 100;
            if (this.capitalationType == CapitulationType.MONTH) {
                for (int i = 0; i < maxDays / 30; i++) {
                    startSumm += monthlyPay;
                    returnMoney += startSumm * this.interestRate / (100 * 12);
                }
            }
            if (this.capitalationType == CapitulationType.YEAR) {
                for (int i = 0; i < maxDays / 366; i++) {
                    startSumm += monthlyPay * 12;
                    returnMoney += startSumm * this.interestRate / 100;
                }
            }
            if (this.capitalationType == CapitulationType.QARTAL) {
                for (int i = 0; i < maxDays / 90; i++) {
                    startSumm += monthlyPay * 4;
                    returnMoney += this.minAmnt * this.interestRate / (100 * 4);
                }
            }
            if (this.capitalationType == CapitulationType.ALL) {

                for (int i = 0; i < maxDays / 366; i++) {
                    startSumm += monthlyPay * 12;
                }
                returnMoney += startSumm * this.interestRate / 100 * (maxDays / 366);

            }
        }
        return returnMoney;
    }

    public double getMinAmnt() {
        return minAmnt;
    }

    public CapitulationType getCapitalationType() {
        return capitalationType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMaxDepTime() {
        return maxDepTime;
    }

    public String getName() {
        return name;
    }

    public double getEntryBonus() {
        return entryBonus;
    }

    public int getMinDepTime() {
        return minDepTime;
    }

    public String getDepositName() {
        return depositName;
    }

}
