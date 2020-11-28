import java.io.*;
class id implements Serializable{
  private int idNumber;

  public id(int i){
    idNumber = i;
  }
  public int getId(){
    return idNumber;
  }
}