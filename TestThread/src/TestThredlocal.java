import java.util.Random;
import java.util.function.IntToDoubleFunction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestThredlocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					threadLocal.set(data);
				    new A().Get();
				    new B().Get();
				}
			}){}.start();
		}
	}
	static class A{
		public void Get(){
			int data = threadLocal.get();
			System.out.println("A from " + Thread.currentThread().getName() + " get data " + data);
		}
	}
	static class B{
		public void Get(){
			int data = threadLocal.get();
			System.out.println("B from " + Thread.currentThread().getName() + " get data " + data);
		}
	}
}
