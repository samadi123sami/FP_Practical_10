package prac10_22001816

object Q4 {

  class Account(val id: Int, var balance: Double) {
    def deposit(amount: Double): Unit = {
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      if (balance >= amount) {
        balance -= amount
      } else {
        println("Insufficient balance")
      }
    }

    def transfer(amount: Double, to: Account): Unit = {
      if (balance >= amount) {
        this.withdraw(amount)
        to.deposit(amount)
      } else {
        println("Insufficient balance to transfer")
      }
    }

    override def toString: String = s"Account($id, $balance)"
  }

  class Bank(val accounts: List[Account]) {

    // 4.1 List of Accounts with negative balances
    def accountsWithNegativeBalance: List[Account] = {
      accounts.filter(_.balance < 0)
    }

    // 4.2 Calculate the sum of all account balances
    def sumOfAllBalances: Double = {
      accounts.map(_.balance).sum
    }

    // 4.3 Calculate the final balances of all accounts after applying interest
    def applyInterest(): Unit = {
      accounts.foreach { account =>
        if (account.balance > 0) {
          account.deposit(account.balance * 0.05)
        } else {
          account.withdraw(account.balance.abs * 0.1)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1, 1000.0)
    val account2 = new Account(2, -500.0)
    val account3 = new Account(3, 200.0)

    val bank = new Bank(List(account1, account2, account3))

    println("Accounts with negative balance:")
    bank.accountsWithNegativeBalance.foreach(println)

    println(s"Sum of all balances: ${bank.sumOfAllBalances}")

    bank.applyInterest()
    println("Balances after applying interest:")
    bank.accounts.foreach(println)
  }
}
