package vn.com.nsmv.bean;

import java.util.ArrayList;
import java.util.List;

import vn.com.nsmv.entities.Users;

public class NFMYGX0400_Bean {

  private List<Users> userList = new ArrayList<>();

  private long count = 0;

  private Integer offset = 0;

  private Integer rowPerPage = 0;

  private String searchMode = "";

  private String sortName = "";

  private String sortOrder = "";

  public List<Users> getUserList() {
    return userList;
  }

  public void setUserList(List<Users> userList) {
    this.userList = userList;
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
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

  public String getSearchMode() {
    return searchMode;
  }

  public void setSearchMode(String searchMode) {
    this.searchMode = searchMode;
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
