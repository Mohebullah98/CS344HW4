import java.util.*;
import java.io.*;
import java.math.BigInteger;
class simulation{
  PipedInputStream TA_input = new PipedInputStream();
    PipedOutputStream TA_Output =new PipedOutputStream();
    PipedInputStream TB_input = new PipedInputStream();
    PipedOutputStream TB_Output =new PipedOutputStream();
    PipedOutputStream TC_Output1 = new PipedOutputStream();
    PipedOutputStream TC_Output2 =new PipedOutputStream();
    PipedOutputStream TD_Output1 = new PipedOutputStream();
    PipedOutputStream TD_Output2 =new PipedOutputStream();
    PipedInputStream TD_in = new PipedInputStream();

    public void Ta_to_TB()throws IOException,InterruptedException{
      TB_input.connect(TA_Output);
      char a ='A';
      System.out.println("TA writes primitive char 'A' to TB");
      TA_Output.write((byte)a);
      System.out.println("TB receives "+ (char)TB_input.read()+" From TA");
    }
    public void TB_to_TA()throws IOException,ClassNotFoundException{
      TA_input.connect(TB_Output);
      id id1 = new id(12345);
      ByteArrayOutputStream idee = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(idee);
      out.writeObject(id1);
      out.flush();
      byte data[] = idee.toByteArray();
       System.out.println("TB writes id object with id number "+id1.getId()+ " to TA");
      TB_Output.write(data,0,data.length);
      byte[] myData = TA_input.readNBytes(data.length);
      ByteArrayInputStream in = new ByteArrayInputStream(myData);
      ObjectInputStream is = new ObjectInputStream(in);
      id myid = (id) is.readObject();
      System.out.println("TA receives id object with id number "+myid.getId()+" From TB");

    }
    public void TC_out()throws IOException,ClassNotFoundException{
      TB_input.connect(TC_Output1);
      char c ='H';
      System.out.println("TC sends primitive char 'H' to TB");
      TC_Output1.write((byte)c);
      System.out.println("TB receives " +(char)TB_input.read()+" From TC");
      TD_in.connect(TC_Output2);
      id id2 = new id(99999);
      ByteArrayOutputStream by = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(by);
      out.writeObject(id2);
      out.flush();
      byte data[] = by.toByteArray();
      System.out.println("TC sends id object with id number "+id2.getId()+" to TD ");
      TC_Output2.write(data,0,data.length);
      byte[] b = TD_in.readNBytes(data.length);
      ByteArrayInputStream in = new ByteArrayInputStream(b);
      ObjectInputStream is = new ObjectInputStream(in);
      id myid = (id)is.readObject();
      System.out.println("TD receives id object with id number "+myid.getId()+" From TC");
      

    }
    public void TD_out()throws IOException,ClassNotFoundException{
      TA_input.connect(TD_Output1);
      TB_input.connect(TD_Output2);
      id id1 = new id(91911);
      id id2 = new id(20100);
      ByteArrayOutputStream by1 = new ByteArrayOutputStream();
      ObjectOutputStream out1 = new ObjectOutputStream(by1);
      out1.writeObject(id1);
      out1.flush();
      ByteArrayOutputStream by2 = new ByteArrayOutputStream();
      ObjectOutputStream out2 = new ObjectOutputStream(by2);
      out2.writeObject(id2);
      out2.flush();
      byte data1[] = by1.toByteArray();
      byte data2[] = by2.toByteArray();
      System.out.println("TD sends id object with id number "+id1.getId()+" to TA ");
       System.out.println("TD sends id object with id number "+id2.getId()+" to TB ");
      TD_Output1.write(data1,0,data1.length);
      TD_Output2.write(data2,0,data2.length);
      byte[] b1 = TA_input.readNBytes(data1.length);
      ByteArrayInputStream in1 = new ByteArrayInputStream(b1);
      ObjectInputStream is1 = new ObjectInputStream(in1);
      id myid1 = (id)is1.readObject();
      System.out.println("TA receives id object with id number "+myid1.getId()+" From TD");
      byte[] b2 = TB_input.readNBytes(data2.length);
      ByteArrayInputStream in2 = new ByteArrayInputStream(b2);
      ObjectInputStream is2 = new ObjectInputStream(in2);
      id myid2 = (id)is2.readObject();
      System.out.println("TB receives id object with id number "+myid2.getId()+" From TD");

    }
  
}