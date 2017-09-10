import java.util.Random;
public class Jar{
  private String name;
  private int maxItemsAllowed;
  
  
  public Jar(){
  }
  //no changes needed
  public Jar(String name,int maxItemsAllowed){
    this.name = name;
    this.maxItemsAllowed = maxItemsAllowed;
  }
  
  public void setTypeOfItems(String name){
     this.name = name;
  }
  
  public void setMaxItemsAllowed(int maxItemsAllowed){
     this.maxItemsAllowed = maxItemsAllowed;
  }
  
  public String getTypeOfItems(){
    return this.name;
  }
  
  public int getMaxItemsAllowed(){
    return this.maxItemsAllowed;
  }
  
  public int fill(){
    Random random = new Random();
    int someNumber = random.nextInt(maxItemsAllowed) + 1;
    return someNumber;
  }
  

}