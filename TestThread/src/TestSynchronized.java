import javax.xml.stream.events.StartDocument;

public class TestSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSynchronized test = new TestSynchronized();
		test.init();
	}
	
	void init() {
		final Outputer outputer = new Outputer();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					outputer.Output("wangyuyuyuyuyuyuyuyu");
				}
			    
			}
		}){
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					outputer.Output("zhouzhanzhaozhaozhaozhao");
				}
			}
		}){
		}.start();
	}
	
    
	class Outputer{
		final static String lockKey = "lock";
		//定义输出函数
		//第一种方式，提供某个锁
		public void Output(String name){
			int len = name.length();
			synchronized (lockKey) {
				for (int i = 0; i < len; i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		//第二种方式，锁住自己
		public void Output1(String name){
			int len = name.length();
			synchronized (this) { //也可以用Outputer.class
				for (int i = 0; i < len; i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		//第三种方式，函数前面加关键字synchronized
		public synchronized void Output2(String name){
			int len = name.length();
			for (int i = 0; i < len; i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
				
			
		}
	}

}
