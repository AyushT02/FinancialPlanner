import java.util.*;

public class Budget {
    double moneySaved;
    double checkingAccount = 0.0;
    double invAmount = 0.0;
    int i = 0;
    double sum = 0;
    boolean run = true;
    boolean r = true;
    double s = 0;
    double costOfLiving = 0.0;
    ArrayList<Double> monthlyExp = new ArrayList<Double>();
    ArrayList<Double> bankAccount = new ArrayList<Double>();
    public void taxes() {
        System.out.println("Enter your income: ");
        Scanner in = new Scanner(System.in);
        double income = in.nextDouble();
        if(income <= 40000) {
            income = income * 1.0;
        }
        if(income > 40000 && income <= 80000) {
            income = income * 0.9;
        }
        if(income > 80000) {
            income = income * 0.85;
        }
        moneySaved = moneySaved + income;
        System.out.println(moneySaved);
    }
    public void expenses() {
        System.out.println("Enter your monthly expenses");
        while(run) {
            Scanner exp = new Scanner(System.in);
            double expense = exp.nextDouble();
            monthlyExp.add(expense);
            if(expense == 0) {
                run = false;
            }
        }
        for(int i = 0; i < monthlyExp.size(); i++) {
            sum += monthlyExp.get(i);
        }
        moneySaved = moneySaved - (sum * 12);
        System.out.println(moneySaved);
    }
    public void deposit() {
        System.out.println("How much do you want to deposit");
        while(r) {
            Scanner dep = new Scanner(System.in);
            double deposit = dep.nextDouble();
            bankAccount.add(deposit);
            if(deposit == 0) {
                r = false;
            }
        }
        for(int j = 0; j < bankAccount.size(); j++) {
            s += bankAccount.get(j);
        }
        System.out.println(s);
    }
    public void withdraw() {
        System.out.println("How much do you want to withdraw?");
        Scanner wit = new Scanner(System.in);
        double withdraw = wit.nextDouble();
        while(withdraw > checkingAccount) {
            System.out.println("You don't have enough funds to make the withdrawal. Please enter a different amount");
            Scanner w = new Scanner(System.in);
            double wd = w.nextDouble();
            if(wd <= checkingAccount) {
                checkingAccount = checkingAccount - wd;
                break;
            }
        }
        checkingAccount = checkingAccount - withdraw;
    }
    public void investment() {
        System.out.println("How much do you want to invest?");
        Scanner inv = new Scanner(System.in);
        double invest = inv.nextDouble();
        System.out.println("How long is the investment period?");
        Scanner t = new Scanner(System.in);
        double time = t.nextDouble();
        System.out.println("What is the annual growth rate?");
        Scanner g = new Scanner(System.in);
        double growthRate = g.nextDouble();
        invAmount = invest * Math.pow(1.0 + growthRate, time);
        System.out.println(invAmount);
    }
    public double balance() {
        return checkingAccount;
    }
}
