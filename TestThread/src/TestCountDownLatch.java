import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    //类似倒计时计数器，当计数减为0的时候，所有等待者才开始执行
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建两个计数器，一个为1，一个为3，代表一个裁判员，三个运动员，裁判员在未下达命令前运动员等待，下达命令后才执行
		//等三个运动员都到达终点后，裁判员才公布成绩
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
						System.out.println("运动员" + id + "正准备接受命令");
						cdOrder.await();
						System.out.println("运动员"+ id + "接受到命令");
						Thread.sleep((int)(Math.random() * 5000));
						System.out.println("运动员" + id + "到达终点");
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
			System.out.println("裁判员发出指令");
			cdOrder.countDown();
			System.out.println("裁判员等待所有运动员到达终点");
			cdAnswer.await();
			System.out.println("裁判员公布成绩");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
