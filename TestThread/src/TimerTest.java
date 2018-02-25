import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
	public static void main(String[] args){
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("boom");
			}
			
		}, 3000);
	}
}
