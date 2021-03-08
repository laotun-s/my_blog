package top.laotun.pojo;


public class BlogUser {

  private long userId;
  private String userLogin;
  private String userPwd;
  private String userName;
  private String userEmail;
  private String userIcon;

  public BlogUser() {
  }

  public BlogUser(long userId, String userLogin, String userPwd, String userName, String userEmail, String userIcon) {
    this.userId = userId;
    this.userLogin = userLogin;
    this.userPwd = userPwd;
    this.userName = userName;
    this.userEmail = userEmail;
    this.userIcon = userIcon;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserIcon() {
    return userIcon;
  }

  public void setUserIcon(String userIcon) {
    this.userIcon = userIcon;
  }

  @Override
  public String toString() {
    return "BlogUser{" +
            "userId=" + userId +
            ", userLogin='" + userLogin + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userName='" + userName + '\'' +
            ", userEmail='" + userEmail + '\'' +
            ", userIcon='" + userIcon + '\'' +
            '}';
  }
}
