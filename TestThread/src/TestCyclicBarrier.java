import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {
	//����̱߳˴˵ȴ������Ϻ�������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����̳߳غ�CyclicBarrier,ͬʱ���ж���̣߳�����await
		
		ExecutorService es = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++){
			es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("�߳�" + Thread.currentThread().getName() + "���Ｏ�ϵ�1");
						System.out.println("��ǰ��" + (cb.getNumberWaiting()+1) + "���ڵȴ�");
						cb.await();
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("�߳�" + Thread.currentThread().getName() + "���Ｏ�ϵ�2");
						System.out.println("��ǰ��" + (cb.getNumberWaiting()+1) + "���ڵȴ�");
						cb.await();
						Thread.sleep((int)(Math.random() * 1000));
						System.out.println("�߳�" + Thread.currentThread().getName() + "���Ｏ�ϵ�3");
						System.out.println("��ǰ��" + (cb.getNumberWaiting()+1) + "���ڵȴ�");
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
