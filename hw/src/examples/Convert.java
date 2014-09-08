// Convert.java
class Convert
{
   public static void main (String [] args) throws java.io.IOException
   {
      System.out.print ("Please enter a number: ");
      int num = 0;
      int ch;
      while ((ch = System.in.read ()) != '\n')
         if (ch >= '0' && ch <= '9')
         {
             num *= 10;
             num += ch - '0';
         }
         else
             break;
      System.out.println ("num = " + num);
      System.out.println ("num squared = " + num * num);
   }
}
