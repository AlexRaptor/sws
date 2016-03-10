package accounts;

/**
 * Created by raptor on 09.03.16.
 */
public class AccountServerController implements AccountServerControllerMBean {
    private final AccountServer accountServer;

    public AccountServerController( AccountServer accountServer )
    {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsersLimit()
    {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit( int usersLimit )
    {
        accountServer.setUsersLimit( usersLimit );
    }
}
