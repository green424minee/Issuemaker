package myPage;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class LicenseService {
	private static final LicenseService instance = new LicenseService();
	
	
	public static LicenseService getInstance() {
		return instance;
	}
	private LicenseService() {}
	
	public int insert (LicenseForInsert license) {
		try (SqlSession session = DBUtil.getSqlSession()) {
			LicenseMapper mapper = session.getMapper(LicenseMapper.class);
			
			int row = mapper.insert(license);
			
			session.commit();
			
			return row;
		}
	}
	 public License selectNo(int licenseNo) {
	      try (SqlSession session = DBUtil.getSqlSession()) {
	        LicenseMapper mapper = session.getMapper(LicenseMapper.class);
	         
	         License license = mapper.selectNo(licenseNo);
	         
	         return license;
	      }
	   }
}
