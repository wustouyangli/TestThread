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
		//�����������
		//��һ�ַ�ʽ���ṩĳ����
		public void Output(String name){
			int len = name.length();
			synchronized (lockKey) {
				for (int i = 0; i < len; i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		//�ڶ��ַ�ʽ����ס�Լ�
		public void Output1(String name){
			int len = name.length();
			synchronized (this) { //Ҳ������Outputer.class
				for (int i = 0; i < len; i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
		//�����ַ�ʽ������ǰ��ӹؼ���synchronized
		public synchronized void Output2(String name){
			int len = name.length();
			for (int i = 0; i < len; i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
				
			
		}
	}

}
