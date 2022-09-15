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


class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = BankAccount(int_rate = 0.02,balance = 0)
    def make_deposit(self, amount):
        self.account.deposit(amount)
    def make_withdrawl(self, amount):
        self.account.withdraw(amount)
    def display_user_balance(self):
        print(self.account.display_account_info)
    def transfer_money(self, other_user, amount):
        self.account.balance-=amount
        other_user.account.balance +=amount
        

amin = User("Amin","amin@gmail.com")


amin.account.deposit(400)
amin.account.yield_interest().display_account_info()