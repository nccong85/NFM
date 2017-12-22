package vn.com.nsmv.bean;

public class NFMYGX0400_UserSearchConditionBean {
  private String searchUserId = "";
  private String searchUserName = "";
  private String searchUserKaishaName = "";
  private String searchUserSozoku = "";
  private String searchUserMail = "";
  private String searchUserTel = "";
  private Integer offset = 0;
  private Integer rowPerPage = 0;
  private String sortName = "";
  private String sortOrder = "";

  public String getSearchUserId() {
    return searchUserId;
  }

  public void setSearchUserId(String searchUserId) {
    this.searchUserId = searchUserId;
  }

  public String getSearchUserName() {
    return searchUserName;
  }

  public void setSearchUserName(String searchUserName) {
    this.searchUserName = searchUserName;
  }

  public String getSearchUserKaishaName() {
    return searchUserKaishaName;
  }

  public void setSearchUserKaishaName(String searchUserKaishaName) {
    this.searchUserKaishaName = searchUserKaishaName;
  }

  public String getSearchUserSozoku() {
    return searchUserSozoku;
  }

  public void setSearchUserSozoku(String searchUserSozoku) {
    this.searchUserSozoku = searchUserSozoku;
  }

  public String getSearchUserMail() {
    return searchUserMail;
  }

  public void setSearchUserMail(String searchUserMail) {
    this.searchUserMail = searchUserMail;
  }

  public String getSearchUserTel() {
    return searchUserTel;
  }

  public void setSearchUserTel(String searchUserTel) {
    this.searchUserTel = searchUserTel;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getRowPerPage() {
    return rowPerPage;
  }

  public void setRowPerPage(Integer rowPerPage) {
    this.rowPerPage = rowPerPage;
  }

  public String getSortName() {
    return sortName;
  }

  public void setSortName(String sortName) {
    this.sortName = sortName;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }
}
