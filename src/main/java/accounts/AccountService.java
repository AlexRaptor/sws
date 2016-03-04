package accounts;

import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class AccountService {
    private final DBService dbService;

    public AccountService( DBService dbService ) {

        this.dbService = dbService;
    }

    public void addNewUser(UserProfile userProfile) {
        dbService.addUser( userProfile.getLogin(), userProfile.getPass() );
    }

    public UserProfile getUserByLogin(String login) {
        UsersDataSet usersDataSet = dbService.getUser( login );
        return new UserProfile( usersDataSet.getName(), usersDataSet.getPassword(), usersDataSet.getName() );
    }
}
