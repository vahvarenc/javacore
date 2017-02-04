package measure;

/**
 * This program tests the DataSet class.
 */
public class DataSetTest {
    public static void main(String[] args) {

        DataSet bankData = new DataSet();

        bankData.add(new BankAccount(10));
        bankData.add(new BankAccount(10000));
        bankData.add(new BankAccount(2000));

        System.out.println("Average balance = "
                + bankData.getAverage());
        Measurable max = bankData.getMaximum();
        System.out.println("Highest balance = "
                + max.getMeasure());
        System.out.println();

        DataSet coinData = new DataSet();
        coinData.add(new Coin(0.25, "quarter"));
        coinData.add(new Coin(0.1, "dime"));
        coinData.add(new Coin(0.05, "nickel"));

        System.out.println("Average coin value = "
                + coinData.getAverage());
        max = coinData.getMaximum();
        System.out.println("Highest coin value = "
                + max.getMeasure());
        System.out.println();
        DataSet data = new DataSet();

        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.25, "quarter"));
        data.add(new Coin(0.1, "dime"));
        data.add(new Coin(0.05, "nickel"));
        data.add(new BankAccount(10));
        data.add(new BankAccount(10000));
        data.add(new BankAccount(2000));
        max = data.getMaximum();
          System.out.println("Highest data value = "
                + max.getMeasure());
        System.out.println("Average data value = "
                + data.getAverage());
        System.out.println("Sum data value = "
                + data.getSum());
    }
}
