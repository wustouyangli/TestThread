import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	public static void main(String[] args){
		//�̶���С���̳߳�
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//�����̳߳أ����̲߳�����ʱ���Զ����ӣ����˻��Զ�����
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//��һ�̳߳أ��߳����˿�����������
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
		threadPool.shutdown(); //�̳߳���û�������ˣ��̳߳زŹرգ���10��������ɺ�Źر�
		//threadPool.shutdownNow(); //һ���߳����֮������رգ���ʱֻ�����3������
		
		/*//��ʱ���̳߳�
		Executors.newScheduledThreadPool(3).schedule(
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("booming");
					}
				}, 
				6,
				TimeUnit.SECONDS); //�೤ʱ���ִ������
*/		
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate( //�Թ̶�Ƶ��ִ������
				new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("booming");
					}
				}, 
				6,  //��ʼʱ��
				2,  //���ʱ��
				TimeUnit.SECONDS);
		
		
	}
}
