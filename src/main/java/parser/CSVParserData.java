package parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.CapitulationType;
import model.Deposit;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParserData {
    private String path;

    public CSVParserData(String path) {
        this.path = path;
    }
    public ArrayList<Deposit> scanFile() throws IOException {
        ArrayList<Deposit> listDeposits = new ArrayList<>();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
        ) {
            CsvToBean<CSVBanks> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVBanks.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CSVBanks> csvBanks = csvToBean.parse();

            System.out.println("List of banks:");
            for (CSVBanks csvBank : csvBanks) {
                CapitulationType capitalationType;
                if (csvBank.getCapitalationType().equals("monthly")) {
                    capitalationType = CapitulationType.MONTH;
                } else if (csvBank.getCapitalationType().equals("maturity")) { //в конце срока at maturity
                    capitalationType = CapitulationType.ALL;
                } else if (csvBank.getCapitalationType().equals("quarter")) {
                    capitalationType = CapitulationType.QARTAL;
                } else {
                    capitalationType = CapitulationType.YEAR;
                }
                Deposit deposit = new Deposit(csvBank.getMinAmnt(),
                        capitalationType,
                        csvBank.getInterestRate(),
                        csvBank.getMaxDepTime(),
                        csvBank.getName(),
                        csvBank.getEntryBonus(),
                        csvBank.getMinDepTime(),
                        csvBank.getDepositName());
                System.out.println(deposit.getName()
                        + ", " + deposit.getDepositName()
                        + ", " + deposit.getInterestRate()
                        + ", " + deposit.getMinAmnt()
                        + ", " + csvBank.getCapitalationType()
                        + ", " + deposit.getMinDepTime()
                        + ", " + deposit.getMaxDepTime()
                        + ", " + deposit.getEntryBonus());
                listDeposits.add(deposit);
            }
        }
        return listDeposits;
    }
}
