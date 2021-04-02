package ashutest;

import java.util.HashMap;
import java.util.Objects;

public class Account {
    private String name ;
    private long accountNo;
    private static final String names [ ] = {"Ashu","Shweta","Reyaan"};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountNo == account.accountNo &&
                name.equals(account.name);
    }

    public String getName() throws AccountException{
        if(name.equalsIgnoreCase("ashu"))
            throw new AccountException("Account handling exception");
        return name;
    }

    public long getAccountNo() throws AccountException{
        return accountNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, accountNo);
    }

    public Account(String name, long accountNo) {
        this.name = name;
        this.accountNo = accountNo;
    }
    public static void main(String s[])
    {
        HashMap<Account,String> accountMap = new HashMap<>();
        accountMap.put(new Account("Ashu",35000),"platinum");
        accountMap.put(new Account("Shweta",50000),"gold");
        accountMap.put(new Account("Ravin",50000),"gold");
        accountMap.put(null,"gold");
        accountMap.put(null,"silver");

        accountMap.forEach((k,v)-> {
            if(Objects.nonNull(k))
                try {
                    System.out.println("Name:" + k.getName() + " Category:" + v);
                } catch (AccountException e) {
                    e.printStackTrace();
                    int i = 10/0;
                }
        });
        int i =0;
        while(i < 100000)
        {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accountMap.put(new Account(names[i%2],i),"gold");
            i++;

        }
    }
}
