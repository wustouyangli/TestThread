import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.xml.stream.events.StartDocument;

public class TestLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLock test = new TestLock();
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
		Lock lock = new ReentrantLock(); //Ëø
		public void Output(String name){
			int len = name.length();
			
			lock.lock();
			try {
				
				for (int i = 0; i < len; i++){
					
					System.out.print(name.charAt(i));
				}
				System.out.println("");
			} finally{
				// TODO: handle exception
				lock.unlock();

			}
		}
		
	}

}
