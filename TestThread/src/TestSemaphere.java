import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntToDoubleFunction;

public class TestSemaphere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1.创建线程池
		 *2.创建信号灯，大小为3 
		 *3.循环10次，Runnable里设置信号灯acqure
		 */
		
		ExecutorService es = Executors.newCachedThreadPool();
		Semaphore semaphore = new Semaphore(3);
		for(int i = 0; i < 10; i++){
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					System.out.println("线程" + Thread.currentThread().getName() + "进入");
					try {
						Thread.sleep((int)Math.random() * 10000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("线程" + Thread.currentThread().getName() + "即将结束");
					semaphore.release();
					System.out.println("线程" + Thread.currentThread().getName() + "已结束");
					es.shutdown();
					
				}
			});
		}
	}

}
