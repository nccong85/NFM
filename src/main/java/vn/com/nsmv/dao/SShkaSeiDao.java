package vn.com.nsmv.dao;

import vn.com.nsmv.bean.NFMYGX0120_SukkaJissekiBean;

/**
 * Check sojono exist.
 * 
 * @author NSMV
 *
 */
public interface SShkaSeiDao {

    NFMYGX0120_SukkaJissekiBean selectSojoNo(String sojoNo);
}
