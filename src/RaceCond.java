import java.lang.*; 

class  RaceCon implements Runnable {
			
			public void RaceCon() {
				return;
			}
			public  void run() {
				synchronized(RaceCond.lock) {
					int count=10000;
					for(int i=0;i<count;i++)
						RaceCond. value++;
					int count2=1000;
					for(int i=0;i<count2;i++)
						RaceCond.value++;
				}
			}
		}
public class RaceCond {
		public  static int value;
		public static Object lock = new Object();
		public void RaceCond() {
			value=0;
			return ;
		}
	
		
		public static void main(String[] args) {
			
			Thread a = new Thread(new RaceCon());
			Thread b = new Thread(new RaceCon());
			
			a.start();
			b.start();
			try {
				a.join();
				b.join();
			}  catch ( Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(value);
			
			
		}
}
