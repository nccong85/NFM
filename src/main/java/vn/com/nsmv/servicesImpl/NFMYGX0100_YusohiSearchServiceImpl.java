package vn.com.nsmv.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nsmv.bean.NFMYGX0100_SearchBean;
import vn.com.nsmv.bean.NFMYGX0100_SearchResultBean;
import vn.com.nsmv.dao.NFMYGX0100_YusohiSearchDao;
import vn.com.nsmv.services.NFMYGX0100_YusohiSearchService;

@Service
public class NFMYGX0100_YusohiSearchServiceImpl implements NFMYGX0100_YusohiSearchService {

  private static final Logger logger = Logger.getLogger(NFMYCX0010_YusohiKeisanServiceImpl.class);

  @Autowired
  NFMYGX0100_YusohiSearchDao yusohiSearchDao;

  @Override
  public List<NFMYGX0100_SearchResultBean> init(String seizoshoKbn) {
    List<NFMYGX0100_SearchResultBean> searchResultList = new ArrayList<>();
    try {
      searchResultList = yusohiSearchDao.selectForInit(seizoshoKbn);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    return searchResultList;
  }

  @Override
  public List<NFMYGX0100_SearchResultBean> search(NFMYGX0100_SearchBean searchBean) {
    List<NFMYGX0100_SearchResultBean> searchResultList = new ArrayList<>();
    try {
      searchResultList = yusohiSearchDao.selectForSearch(searchBean);
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    return searchResultList;
  }
}
