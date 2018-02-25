
public class prictice_1 {
    //子线程运行10次，主线程运行20次
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
	

}
class Business{
	private boolean isSub = true;
	public synchronized void Sub(int j){
        while (!isSub) {
        	try {
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        }
		for (int i = 1; i <= 10; i++){
			System.out.println("sub thread " + i + " of loop " + j);
		}
		isSub = false;
		this.notify();
	}
	
	public synchronized void Main(int j){
		while (isSub){
			try {
				this.wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		for (int i = 1; i <= 20; i++){
			System.out.println("main thread " + i + " of loop " + j);
		}
		isSub = true;
		this.notify();
	}
}
