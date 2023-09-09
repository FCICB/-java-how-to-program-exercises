import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Transaction {
    private int accountNumber;
    private double amount;

    public Transaction(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void combine(Transaction transaction) {
        balance += transaction.getAmount();
    }
}

class FileMatch {
    public void matchFiles(String masterFile, String transactionFile) {
        try (BufferedReader masterReader = new BufferedReader(new FileReader(masterFile));
             BufferedReader transactionReader = new BufferedReader(new FileReader(transactionFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter("newmast.txt"));
             BufferedWriter logWriter = new BufferedWriter(new FileWriter("log.txt"))) {

            String masterLine = masterReader.readLine();
            String transactionLine = transactionReader.readLine();

            while (masterLine != null && transactionLine != null) {
                int masterAccountNumber = Integer.parseInt(masterLine.substring(0, 4));
                int transactionAccountNumber = Integer.parseInt(transactionLine.substring(0, 4));

                if (masterAccountNumber == transactionAccountNumber) {
                    double transactionAmount = Double.parseDouble(transactionLine.substring(5));
                    Account account = new Account(masterAccountNumber, Double.parseDouble(masterLine.substring(5)));
                    account.combine(new Transaction(transactionAccountNumber, transactionAmount));

                    writer.write(String.format("%04d %.2f%n", account.getAccountNumber(), account.getBalance()));

                    masterLine = masterReader.readLine();
                    transactionLine = transactionReader.readLine();
                } else if (masterAccountNumber < transactionAccountNumber) {
                    writer.write(masterLine + System.lineSeparator());
                    masterLine = masterReader.readLine();
                } else {
                    logWriter.write("Unmatched transaction record for account number " + transactionAccountNumber + System.lineSeparator());
                    transactionLine = transactionReader.readLine();
                }
            }

            while (masterLine != null) {
                writer.write(masterLine + System.lineSeparator());
                masterLine = masterReader.readLine();
            }

            while (transactionLine != null) {
                int transactionAccountNumber = Integer.parseInt(transactionLine.substring(0, 4));
                logWriter.write("Unmatched transaction record for account number " + transactionAccountNumber + System.lineSeparator());
                transactionLine = transactionReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        FileMatch fileMatch = new FileMatch();
        fileMatch.matchFiles("oldmast.txt", "trans.txt");
    }
}
