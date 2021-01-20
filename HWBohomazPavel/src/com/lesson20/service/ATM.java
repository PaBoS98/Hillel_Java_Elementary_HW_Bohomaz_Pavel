package com.lesson20.service;

public class ATM {

    private String fullName;
    private int amount;

    private ATM(ATMBuilder ATMBuilder) {
        this.fullName = ATMBuilder.fullName;
        this.amount = ATMBuilder.amount;
    }

    public String withdrawal(int amount) {
        if (amount >= 0) {
            if (this.amount >= amount) {
                int temp = this.amount;
                this.amount -= amount;
                return "На счету: " + temp + " UAH\n" +
                        "|                       Выдача - " + amount + " UAH";
            } else return "Недостаточно денег";
        } else return "некоректная сумма";
    }

    public String put(int amount) {
        if (amount >= 0) {
            int temp = this.amount;
            this.amount += amount;
            return "На счету: " + temp + " UAH\n" +
                    "|                    Пополнение на - " + amount + " UAH";
        } else return "некоректная сумма";
    }

    public void display() {
        System.out.println("-------------------------------------------------------------\n" +
        "|                         FULL NAME:\n" +
        "|                        " + this.fullName + "\n" +
        "|\n" +
        "|                           AMOUNT:\n" +
        "|                          " + this.amount + " UAH\n" +
        "|                         \n" +
        "-------------------------------------------------------------");
    }

    public void display(String worker, String operation) {
        System.out.println("^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^-^\n"+
                "                         " + worker + "\n" +
        "-------------------------------------------------------------\n" +
        "|                         FULL NAME:\n" +
        "|                        " + this.fullName +"\n" +
        "|\n" +
        "|                    " +  operation +"\n" +
        "|\n"+
        "|                           AMOUNT:\n" +
        "|                          " + this.amount + " UAH\n"+
        "|\n"+
        "-------------------------------------------------------------");

    }

    @Override
    public String toString() {
        return "ATM{" +
                "fullName='" + fullName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static class ATMBuilder {

        private String fullName;
        private int amount;

        public ATMBuilder() {

        }

        public ATMBuilder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }
        public ATMBuilder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public ATM build () {
            return new ATM(this);
        }
    }
}


