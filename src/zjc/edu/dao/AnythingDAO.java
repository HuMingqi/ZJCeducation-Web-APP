package zjc.edu.dao;

import java.util.List;

public interface AnythingDAO {
	public Integer insert(Object obj);
	public List query(String sql);
	public boolean update(String sql);
}
