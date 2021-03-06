package vn.com.nsmv.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import vn.com.nsmv.common.BusinessConst;

public class DateUtil {
	private static final String yyyyMMddhhmmss = "yyyy-MM-dd hh:mm:ss";

	private static final String yyyyMMdd_Slash = "yyyy/MM/dd";

	/**
	 * getSqlDate
	 * 
	 * @param str
	 *            文字
	 * @return Date型
	 */
	public static java.sql.Date getSqlDate(final String str) {

		return new java.sql.Date(parseDate(str).getTime());
	}

	/**
	 * 日時文字列をDateに変換します。
	 *
	 * @param value
	 *            日時文字列
	 * @return {@link Date}
	 * @throws BspSystemException
	 *             日時を解析できない
	 */
	public static Date parseDate(final String value) {

		try {
			return DateUtils.parseDate(value, new String[] { BusinessConst.CodeDef.DateFormat.YYYYMMDD });
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 現在の日
	 *
	 * @return java.sql.Date
	 */
	public static java.sql.Date getSqlCurrentDate() {
		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

	/**
	 * 現在の日
	 *
	 * @return Date
	 */
	public static Date getUtilCurrentDate() {

		return Calendar.getInstance().getTime();
	}

	/**
	 * 現在のjava.sql.Timestamp
	 *
	 * @return java.sql.Timestamp
	 */
	public static java.sql.Timestamp getTimestamp() {
		Date today = new Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
		return timestamp;
	}

	public static String convertyyyyMMddhhmmss(String stringDate) {
		SimpleDateFormat dt = new SimpleDateFormat(yyyyMMddhhmmss);
		Date date;
		try {
			date = dt.parse(StringUtil.getStr(stringDate));
			return new SimpleDateFormat(yyyyMMdd_Slash).format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

}
