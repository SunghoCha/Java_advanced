package thread.sync.bank;

public interface BankAccount {

    boolean withdraw(int amount);

    int getBalance();
}
