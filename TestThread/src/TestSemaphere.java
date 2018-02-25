import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntToDoubleFunction;

public class TestSemaphere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1.�����̳߳�
		 *2.�����źŵƣ���СΪ3 
		 *3.ѭ��10�Σ�Runnable�������źŵ�acqure
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
					
					System.out.println("�߳�" + Thread.currentThread().getName() + "����");
					try {
						Thread.sleep((int)Math.random() * 10000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("�߳�" + Thread.currentThread().getName() + "��������");
					semaphore.release();
					System.out.println("�߳�" + Thread.currentThread().getName() + "�ѽ���");
					es.shutdown();
					
				}
			});
		}
	}

}
