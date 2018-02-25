import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExchanger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newCachedThreadPool();
		Exchanger<String> exchanger = new Exchanger<String>();
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "x";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "发送出去");
					Thread.sleep((int)(Math.random() * 5000));
					String getData = exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + "接受到的数据为: " + getData);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					String data1 = "y";
					System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "发送出去");
					Thread.sleep((int)(Math.random() * 5000));
					String getData = exchanger.exchange(data1);
					System.out.println("线程" + Thread.currentThread().getName() + "接受到的数据为: " + getData);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}

}
