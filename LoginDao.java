package in.Coder.bookstore.dao;

public interface LoginDao {
boolean login(String userName,String password,String type);
boolean changePassword(String userName,String newPassword,String type);
}
