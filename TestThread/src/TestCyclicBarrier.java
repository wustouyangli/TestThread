import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
	//多个线程彼此等待，集合后再运行
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建线程池和CyclicBarrier,同时运行多个线程，调用await
		
		ExecutorService es = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++){
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("线程" + Thread.currentThread().getName() + "到达集合点1");
						System.out.println("当前有" + (cb.getNumberWaiting()+1) + "人在等待");
						cb.await();
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("线程" + Thread.currentThread().getName() + "到达集合点2");
						System.out.println("当前有" + (cb.getNumberWaiting()+1) + "人在等待");
						cb.await();
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("线程" + Thread.currentThread().getName() + "到达集合点3");
						System.out.println("当前有" + (cb.getNumberWaiting()+1) + "人在等待");
						cb.await();
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
			});
		}
		es.shutdown();

	}

}
