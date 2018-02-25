import java.util.Random;


public class TestThreadlocal_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					MyData.getInstance().setName("myData" + data);
					MyData.getInstance().setAge(data);
					new A().Get();
				    new B().Get();
				}
			}){}.start();
		}

	}
	
	static class A{
		public void Get(){
			MyData data = MyData.getInstance();
			System.out.println("A from " + Thread.currentThread().getName() + " get data " + data.getName() + ", " + data.getAge());
		}
	}
	static class B{
		public void Get(){
			MyData data = MyData.getInstance();
			System.out.println("B from " + Thread.currentThread().getName() + " get data " + data.getName() + ", " + data.getAge());
		}
	}

}

class MyData{
	String name;
	int age;
	
	public static /*synchronized*/ MyData getInstance(){
		MyData instance = threadLocal.get();
		if (instance == null){  //不存在就创建一个与本线程有关的实例对象
			instance = new MyData();
			threadLocal.set(instance);
			
		}
		return instance;
	}
	
	//private static MyData instance = null;
	private static ThreadLocal<MyData> threadLocal = new ThreadLocal<MyData>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}