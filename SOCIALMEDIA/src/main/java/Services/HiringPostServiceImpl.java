package Services;

import Entity.HiringPost;
import Dao.IHiringPostDao;

import java.util.List;

import Dao.HiringPostDaoImpl;

public class HiringPostServiceImpl implements IHiringPostService {
	private IHiringPostDao _hiringPostDao =  new HiringPostDaoImpl();
	
	@Override
	public List<HiringPost> findAll() {
		return _hiringPostDao.findAll();
	}
	
	@Override
	public HiringPost findById(int id) {
		return _hiringPostDao.findById(id);
	}
}
