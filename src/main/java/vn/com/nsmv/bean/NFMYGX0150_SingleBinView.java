package vn.com.nsmv.bean;

import java.util.ArrayList;
import java.util.List;

public class NFMYGX0150_SingleBinView {
  private List<NFMYGX0150_YusohiViewHeadBean> headInfoList = new ArrayList<>();
  private List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList = new ArrayList<>();
  public List<NFMYGX0150_YusohiViewHeadBean> getHeadInfoList() {
    return headInfoList;
  }
  public void setHeadInfoList(List<NFMYGX0150_YusohiViewHeadBean> headInfoList) {
    this.headInfoList = headInfoList;
  }
  public List<NFMYGX0150_YusohiViewBodyBean> getBodyInfoList() {
    return bodyInfoList;
  }
  public void setBodyInfoList(List<NFMYGX0150_YusohiViewBodyBean> bodyInfoList) {
    this.bodyInfoList = bodyInfoList;
  }

  

}
