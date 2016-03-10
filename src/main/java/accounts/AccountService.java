package accounts;

/**
 * Created by raptor on 09.03.16.
 */
public interface AccountService {
    public void addNewUser(UserProfile userProfile);
    public UserProfile getUserByLogin(String login);
}
