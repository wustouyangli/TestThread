import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestThreadMap {
	private static HashMap<Thread, Integer> map = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		//TestThreadMap testThreadMap = new TestThreadMap();
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
			        map.put(Thread.currentThread(), data);
			        new A().Get();
			        new B().Get();
				}
			}){}.start();
			 
			
		}
	}
	static class A{
		public void Get(){
			int data = map.get(Thread.currentThread());
			System.out.println("A from " + Thread.currentThread().getName() + " get data " + data);
		}
	}
	
	static class B{
		public void Get(){
			int data = map.get(Thread.currentThread());
			System.out.println("B from " + Thread.currentThread().getName() + " get data " + data);
		}
	}
}

