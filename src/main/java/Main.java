import controller.CalculateDeposit;
import parser.CSVParserData;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CSVParserData parserData = new CSVParserData("banks.csv");
        try {
            CalculateDeposit banks = new CalculateDeposit(parserData.scanFile());
            banks.findBest(3701000, 6, 650);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
