import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    //���Ƶ���ʱ����������������Ϊ0��ʱ�����еȴ��߲ſ�ʼִ��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����������������һ��Ϊ1��һ��Ϊ3������һ������Ա�������˶�Ա������Ա��δ�´�����ǰ�˶�Ա�ȴ����´�������ִ��
		//�������˶�Ա�������յ�󣬲���Ա�Ź����ɼ�
        ExecutorService es = Executors.newCachedThreadPool();
        CountDownLatch cdOrder = new CountDownLatch(1);
        CountDownLatch cdAnswer = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
        	final int id = i;
        	es.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("�˶�Ա" + id + "��׼����������");
						cdOrder.await();
						System.out.println("�˶�Ա"+ id + "���ܵ�����");
						Thread.sleep((int)(Math.random() * 5000));
						System.out.println("�˶�Ա" + id + "�����յ�");
						cdAnswer.countDown();
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					
				}
			});
        }
        
        try {
        	Thread.sleep(1000);
			System.out.println("����Ա����ָ��");
			cdOrder.countDown();
			System.out.println("����Ա�ȴ������˶�Ա�����յ�");
			cdAnswer.await();
			System.out.println("����Ա�����ɼ�");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
