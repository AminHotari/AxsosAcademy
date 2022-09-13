class BankAccount:
    def __init__(self, int_rate, balance):
        self.int_rate = int_rate
        self.balance = balance
        

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        self.balance -= amount
        if self.balance <=amount:
            balance -= 5
            print("Insufficient funds: Charging a $5 fee")
        return self
    
    def display_account_info(self):
        print(self.balance)
        return self    


    def yield_interest(self):
        if self.balance > 1:
            self.balance -= self.balance * self.int_rate
        return self

Amin = BankAccount(0.02,50)
Hotari = BankAccount(0.01,100)


Amin.deposit(20).deposit(100).deposit(50).withdraw(50).yield_interest().display_account_info()

Hotari.deposit(2000).deposit(10).withdraw(100).withdraw(50).withdraw(60).withdraw(90).yield_interest().display_account_info()
