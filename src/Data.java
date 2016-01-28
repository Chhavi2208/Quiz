/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yasha123
 */
public class Data {
    static int res=0;
   static String x="";
   static String y="";
  public static int myResult()
  { 
    return res;
}
  
 public static void change(int x)
 {
    res=x;
 }
 public static void zero()
 {
 res=0;
 }
  public static String myResult2()
  { 
    return x;
}
   public static String myResult3()
  { 
    return y;
}
 public static void change2(String a,String b)
 {
    x=a;
    y=b;
 }
 public static void zero2()
 {
 x="";
 y="";
 }
}
