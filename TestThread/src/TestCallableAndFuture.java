import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestCallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException{
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future future =
				threadPool.submit(new Callable<String>() {
					@Override
					public String call() throws Exception {
						// TODO Auto-generated method stub
						Thread.sleep(2000);
						return "hello";
					}
				});
		
		System.out.println("�õ����: " + future.get()); //callable������񷵻ؽ������futureȥ�ã���Ҫ�ȴ�һ��ʱ��
	    //System.out.println("�õ����: " + future.get(1, TimeUnit.SECONDS)); //Ҫ�ڹ涨��ʱ���ڵõ����������ò������׳��쳣
		
		//CompletionService �����ύһ��callable���񣬲���take�����õ�һ������������future����
		ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool2);
		
		for (int i = 1; i <= 10; i++){
			final int taskid = i;
		completionService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(new Random().nextInt(5000));
				} catch (Exception e) {
					// TODO: handle exception
				}
				return taskid;
			}
		});
		}
		
		for (int i = 1; i <= 10; i++){
			System.out.println(completionService.take().get());
		}
	}

}
