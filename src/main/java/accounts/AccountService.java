package accounts;

/**
 * Created by raptor on 09.03.16.
 */
public interface AccountService {
    void addNewUser(UserProfile userProfile);

    UserProfile getUserByLogin(String login);
}
