package matching;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.Company;
import member.CompanyMapper;
import util.DBUtil;

public class ComLicenseService {
	private static final ComLicenseService instance = new ComLicenseService();
	private ComLicenseService() {}
	
	public static ComLicenseService getInstance() {
		return instance;
	}
	
	public int insert (ComLicense comLicense) {
		try (SqlSession session = DBUtil.getSqlSession()){
			ComLicenseMapper mapper = session.getMapper(ComLicenseMapper.class);
			
			int row = mapper.insert(comLicense);
			
			session.commit();
			
			return row;
		}
	}
	
    public List<String> getComLicenseById(String comId) {
        try (SqlSession session = DBUtil.getSqlSession()) {
            ComLicenseMapper mapper = session.getMapper(ComLicenseMapper.class);
            return mapper.getComLicenseById(comId);
        }
    }
}
