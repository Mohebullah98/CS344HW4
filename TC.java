import java.io.IOException;
class TC implements Runnable{
  private int id;
  private int number;
  public TC(int i,int num){
    id=i;
    number=num;
    new Thread(this).start();
  }
  public int getNumber(){
    return number;
  }
  public int getId(){
    return id;
  }
  simulation s = new simulation();
  public void run(){
    try{
    s.TC_out();
    }
    catch(IOException e)
        {
          e.printStackTrace();
        }
    catch(Exception c){
      
    }
  }
}