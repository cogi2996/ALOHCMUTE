package Dao;

import java.util.List;

import Entity.HiringPost;

public interface IHiringPostDao {
	public List<HiringPost> findAll();
	public HiringPost findById(int id);
}
