package parser;

import com.opencsv.bean.CsvBindByName;

public class CSVBanks {

    @CsvBindByName
    private String name;

    @CsvBindByName(column = "interestRate")
    private Double interestRate;

    @CsvBindByName(column = "depositName")
    private String depositName;

    @CsvBindByName(column = "minDepTime")
    private Integer minDepTime;

    @CsvBindByName(column = "maxDepTime")
    private Integer maxDepTime;

    @CsvBindByName(column = "entryBonus")
    private Double entryBonus;

    @CsvBindByName(column = "capitalationType")
    private String capitalationType;

    @CsvBindByName(column = "minAmnt")
    private Double minAmnt;

    public String getName() {
        return name;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public String getDepositName() {
        return depositName;
    }

    public Integer getMinDepTime() {
        return minDepTime;
    }

    public Integer getMaxDepTime() {
        return maxDepTime;
    }

    public Double getEntryBonus() {
        return entryBonus;
    }

    public String getCapitalationType() {
        return capitalationType;
    }

    public Double getMinAmnt() {
        return minAmnt;
    }
}
