package ma.resto.app.IDao;

import java.util.List;

public interface diao<T> {
	public T save(T o);

	public T update(T o);

	public void delete(T o);

	public T findById(int id);

	public List<T> findAll();

	void delete(int id);
}
