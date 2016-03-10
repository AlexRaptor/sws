package accounts;

import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class AccountServiceImpl implements AccountService {
    private final DBService dbService;

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
}
