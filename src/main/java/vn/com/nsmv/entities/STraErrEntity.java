package vn.com.nsmv.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_tra_err")
public class STraErrEntity {
	
	@Column(name = "seizosho_kbn")
	private String seizoshoKbn;

	@Id
	@Column(name = "shori_start_date", nullable = true)
	private java.sql.Timestamp shoriStartDate;

	@Column(name = "yuso_keisan_shubetsu")
	private String yusoKeisanShubetsu;

	@Column(name = "err_shubetsu")
	private String errShubetsu;

	@Column(name = "sojono_shukko_basho")
	private String sojonoShukkoBasho;

	@Column(name = "sojono_torihiki_shubetsu")
	private String sojonoTorihikiShubetsu;

	@Column(name = "sojono_oban")
	private String sojonoOban;

	@Column(name = "sojono_renban")
	private int sojonoRenban;

	@Column(name = "seikyu_nengetsu")
	private String seikyuNengetsu;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "table_access_info")
	private String tableAccessInfo;

	@Column(name = "toroku_date", nullable = true)
	private Date torokuDate;

	@Column(name = "koshinsha")
	private String koshinsha;

	@Column(name = "koshin_date", nullable = true)
	private Date koshinDate;

	@Column(name = "time_stamp", nullable = true)
	private Date timeStamp;

	public String getSeizoshoKbn() {
		return seizoshoKbn;
	}

	public void setSeizoshoKbn(String seizoshoKbn) {
		this.seizoshoKbn = seizoshoKbn;
	}

	public java.sql.Timestamp getShoriStartDate() {
		return shoriStartDate;
	}

	public void setShoriStartDate(java.sql.Timestamp shoriStartDate) {
		this.shoriStartDate = shoriStartDate;
	}

	public String getYusoKeisanShubetsu() {
		return yusoKeisanShubetsu;
	}

	public void setYusoKeisanShubetsu(String yusoKeisanShubetsu) {
		this.yusoKeisanShubetsu = yusoKeisanShubetsu;
	}

	public String getErrShubetsu() {
		return errShubetsu;
	}

	public void setErrShubetsu(String errShubetsu) {
		this.errShubetsu = errShubetsu;
	}

	public String getSojonoShukkoBasho() {
		return sojonoShukkoBasho;
	}

	public void setSojonoShukkoBasho(String sojonoShukkoBasho) {
		this.sojonoShukkoBasho = sojonoShukkoBasho;
	}

	public String getSojonoTorihikiShubetsu() {
		return sojonoTorihikiShubetsu;
	}

	public void setSojonoTorihikiShubetsu(String sojonoTorihikiShubetsu) {
		this.sojonoTorihikiShubetsu = sojonoTorihikiShubetsu;
	}

	public String getSojonoOban() {
		return sojonoOban;
	}

	public void setSojonoOban(String sojonoOban) {
		this.sojonoOban = sojonoOban;
	}

	public int getSojonoRenban() {
		return sojonoRenban;
	}

	public void setSojonoRenban(int sojonoRenban) {
		this.sojonoRenban = sojonoRenban;
	}

	public String getSeikyuNengetsu() {
		return seikyuNengetsu;
	}

	public void setSeikyuNengetsu(String seikyuNengetsu) {
		this.seikyuNengetsu = seikyuNengetsu;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableAccessInfo() {
		return tableAccessInfo;
	}

	public void setTableAccessInfo(String tableAccessInfo) {
		this.tableAccessInfo = tableAccessInfo;
	}

	public Date getTorokuDate() {
		return torokuDate;
	}

	public void setTorokuDate(Date torokuDate) {
		this.torokuDate = torokuDate;
	}

	public String getKoshinsha() {
		return koshinsha;
	}

	public void setKoshinsha(String koshinsha) {
		this.koshinsha = koshinsha;
	}

	public Date getKoshinDate() {
		return koshinDate;
	}

	public void setKoshinDate(Date koshinDate) {
		this.koshinDate = koshinDate;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
