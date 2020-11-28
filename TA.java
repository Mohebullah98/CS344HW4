import java.io.IOException;
class TA implements Runnable{
  private int id;
  private int number;
  public TA(int i,int num){
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
    s.Ta_to_TB();
    }
    catch(IOException e)
        {
          e.printStackTrace();
        }
    catch(InterruptedException e){

    }    
  }
}