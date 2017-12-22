package vn.com.nsmv.bean;

import java.util.ArrayList;
import java.util.List;

public class NFMYCX0010_TsumiawaseListBean {

  private boolean hasBetto = false;

  private List<NFMYCX0010_YusoTranBean> tsumiawaseList = new ArrayList<>();

  public boolean isHasBetto() {
    return hasBetto;
  }

  public void setHasBetto(boolean hasBetto) {
    this.hasBetto = hasBetto;
  }

  public List<NFMYCX0010_YusoTranBean> getTsumiawaseList() {
    return tsumiawaseList;
  }

  public void setTsumiawaseList(List<NFMYCX0010_YusoTranBean> tsumiawaseList) {
    this.tsumiawaseList = tsumiawaseList;
  }
}
