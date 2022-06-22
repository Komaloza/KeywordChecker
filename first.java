package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class first {
	  public static void main(String[] args) throws IOException {

          String filepath = "C:\\Users\\komoza\\Desktop\\Resume";
          File input = new File(filepath);
          File[] fp = input.listFiles();
          Set <String>  keywords = new HashSet<String>();
          System.out.print("Enter no of skills to be matched :");
          Scanner s = new Scanner(System.in);
          int num_skill = s.nextInt();
          for (File file : fp)
          {
         	 PDDocument pdd = new PDDocument();
         	 PDFTextStripper stripper = new PDFTextStripper();
              String resume = stripper.getText(pdd.load(file));
              String Resume = resume.toLowerCase();
              
              for(int i=0;i< num_skill;i++)
              {
             	 keywords.add(s.next());
              }
              int count = 0;
              for (String ele : keywords)
              {
             	 if (Resume.contains(ele))
                      {
             		 	count++;
                      }
                                     
              } 
              System.out.println(file); 
              if (count < 1) 
              {
             	 System.out.println("0% Match of keywords");
              }
              else if (count == 1)
              {
             	 System.out.println("30% Match of Keywords");
              }        
              else if (count == 2) 
              {
             	 System.out.println("60% Match of Keywords");
              }
              else if(count==3)
              {
             	 System.out.println("80% Match of Keywords");
              }
              else if(count>3)
              {
                  System.out.println("100% Match of Keywords");
              }
              PDDocument.load(file).close();
            
            }
       }
}
