import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriterLock {
	HashMap<String, Object> mp = new HashMap<String, Object>();
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public Object Get(String key){
		rwl.readLock().lock();
		Object value = null;
		try {
			value = mp.get(key);
			if (value == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (value == null){
						value = "aaa";
					}
					
				} finally {
					// TODO: handle finally clause
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally {
			rwl.readLock().unlock();
		}
		return value;
	}
}
