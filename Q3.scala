package prac10_22001816

object Q3 {
  class Account(var balance: Double) {

    // Deposit money into the account
    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited $$${amount}. New balance: $$${balance}.")
      } else {
        println("Deposit amount must be positive.")
      }
    }

    // Withdraw money from the account
    def withdraw(amount: Double): Unit = {
      if (amount > 0 && amount <= balance) {
        balance -= amount
        println(s"Withdrew $$${amount}. New balance: $$${balance}.")
      } else {
        println("Invalid withdraw amount or insufficient balance.")
      }
    }

    // Transfer money to another account
    def transfer(amount: Double, toAccount: Account): Unit = {
      if (amount > 0 && amount <= balance) {
        this.withdraw(amount) // Withdraw from this account
        toAccount.deposit(amount) // Deposit into the given account
        println(s"Transferred $$${amount} to another account.")
      } else {
        println("Invalid transfer amount or insufficient balance.")
      }
    }

    // Display the current balance
    def displayBalance(): Unit = {
      println(s"Current balance: $$${balance}")
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    account1.displayBalance()
    account2.displayBalance()

    account1.deposit(200.0)
    account1.withdraw(150.0)
    account1.transfer(300.0, account2)

    account1.displayBalance()
    account2.displayBalance()
  }
}
