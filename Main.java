import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Main {
  
  public static void main(String[] args) throws InterruptedException {
    simulation s = new simulation();
    new TA(1, 1);
    Thread.sleep(200);
    new TB(1,1);
    Thread.sleep(200);
    new TC(1,1);
    Thread.sleep(200);
    new TD(1,1);
  
  }
}