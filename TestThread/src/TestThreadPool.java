import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	public static void main(String[] args){
		//固定大小的线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//缓存线程池，当线程不够用时会自动增加，多了会自动减少
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//单一线程池，线程死了可以重新启动
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++){
			final int taskid = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 1; j <= 10; j++) {
						System.out.println(Thread.currentThread().getName() + " is loop of " + j + " for task of " + taskid);
					}
				}
			});
		}
		System.out.println("all have finished");
		threadPool.shutdown(); //线程池里没有任务了，线程池才关闭，等10个任务都完成后才关闭
		//threadPool.shutdownNow(); //一个线程完成之后立马关闭，此时只完成了3个任务
		
		/*//定时器线程池
		Executors.newScheduledThreadPool(3).schedule(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("booming");
					}
				}, 
				6,
				TimeUnit.SECONDS); //多长时间后执行任务
*/		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate( //以固定频率执行任务
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("booming");
					}
				}, 
				6,  //初始时间
				2,  //间隔时间
				TimeUnit.SECONDS);
		
		
	}
}
