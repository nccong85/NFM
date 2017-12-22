package vn.com.nsmv.bean;

public class NFMYCX0010_UchiwakeResult {
  private NFMYCX0010_BaseCaculateResult baseResult;
  private NFMYCX0010_KutonCaculateResult kutonResult;
  private NFMYCX0010_ChojakuCaculateResult chojakuResult;
  private NFMYCX0010_JikangaiCaculateResult jikangaiResult;
  private NFMYCX0010_KyujitsuCaculateResult kyujitsuResult;

  public NFMYCX0010_UchiwakeResult() {
    baseResult = new NFMYCX0010_BaseCaculateResult();
    baseResult.setBaseJuryo(0);
    baseResult.setBaseKingaku(0);

    kutonResult = new NFMYCX0010_KutonCaculateResult();
    kutonResult.setKutonJuryo(0);
    kutonResult.setKutonKingaku(0);

    chojakuResult = new NFMYCX0010_ChojakuCaculateResult();
    chojakuResult.setChojakuJuryo(0);
    chojakuResult.setChojakuKingaku(0);

    jikangaiResult = new NFMYCX0010_JikangaiCaculateResult();
    jikangaiResult.setJikangaiJuryo(0);
    jikangaiResult.setJikangaiKingaku(0);

    kyujitsuResult = new NFMYCX0010_KyujitsuCaculateResult();
    kyujitsuResult.setKyujitsuJuryo(0);
    kyujitsuResult.setKyujitsuKingaku(0);
  }

  public NFMYCX0010_BaseCaculateResult getBaseResult() {
    return baseResult;
  }

  public void setBaseResult(NFMYCX0010_BaseCaculateResult baseResult) {
    this.baseResult = baseResult;
  }

  public NFMYCX0010_KutonCaculateResult getKutonResult() {
    return kutonResult;
  }

  public void setKutonResult(NFMYCX0010_KutonCaculateResult kutonResult) {
    this.kutonResult = kutonResult;
  }

  public NFMYCX0010_ChojakuCaculateResult getChojakuResult() {
    return chojakuResult;
  }

  public void setChojakuResult(NFMYCX0010_ChojakuCaculateResult chojakuResult) {
    this.chojakuResult = chojakuResult;
  }

  public NFMYCX0010_JikangaiCaculateResult getJikangaiResult() {
    return jikangaiResult;
  }

  public void setJikangaiResult(NFMYCX0010_JikangaiCaculateResult jikangaiResult) {
    this.jikangaiResult = jikangaiResult;
  }

  public NFMYCX0010_KyujitsuCaculateResult getKyujitsuResult() {
    return kyujitsuResult;
  }

  public void setKyujitsuResult(NFMYCX0010_KyujitsuCaculateResult kyujitsuResult) {
    this.kyujitsuResult = kyujitsuResult;
  }

}
