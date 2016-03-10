package accounts;

public class AccountServerImpl implements AccountServer
{
//    private final DBService dbService;
    private int usersLimit;

    public AccountServerImpl( int usersLimit ) {
        this.usersLimit = usersLimit;
    }

    @Override
    public int getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit( int usersLimit ) {
        this.usersLimit = usersLimit;
    }


/*
    public AccountServiceImpl( DBService dbService ) {

        this.dbService = dbService;
    }

    public void addNewUser(UserProfile userProfile) {
        dbService.addUser( userProfile.getLogin(), userProfile.getPass() );
    }

    public UserProfile getUserByLogin(String login) {
        UsersDataSet usersDataSet = dbService.getUser( login );
        if (usersDataSet == null) {
            return null;
        }
        return new UserProfile( usersDataSet.getName(), usersDataSet.getPassword(), usersDataSet.getName() );
    }
*/
}
