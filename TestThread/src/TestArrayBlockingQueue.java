import java.util.concurrent.ArrayBlockingQueue;

public class TestArrayBlockingQueue {
    //�������е�����Ϊ��ʱtake����������������ʱput������
	//��������������ģ�������߳̽�������
	//�����������д�С������Ϊ1������һ����һ������
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Business business = new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int j = 1; j <= 10; j++) {
					business.Sub(j);
				}
			}
		}){}.start();
		
		for (int j = 1; j <= 10; j++) {
			business.Main(j);
		}
		
	}
	
	static class Business{
		ArrayBlockingQueue abq1 = new ArrayBlockingQueue(1);
		ArrayBlockingQueue abq2 = new ArrayBlockingQueue(1);
		public Business() 
		{
			try {
				abq2.put(1);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		public void Sub(int j){
			try {
				abq1.put(1);
				for (int i = 1; i <= 10; i++){
					System.out.println("sub thread " + i + " of loop " + j);
				}
				abq2.take();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		public void Main(int j){
			try {
				abq2.put(1);
				for (int i = 1; i <= 10; i++){
					System.out.println("main thread " + i + " of loop " + j);
				}
				abq1.take();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
