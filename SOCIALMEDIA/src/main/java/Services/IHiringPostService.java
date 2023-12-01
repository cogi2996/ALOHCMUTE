package Services;
import java.util.List;

import Entity.HiringPost;

public interface IHiringPostService {
	public List<HiringPost> findAll();
	public HiringPost findById(int id);
}
