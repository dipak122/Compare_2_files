import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class index{
    static void outputfile(StringBuilder cbuilder1,StringBuilder cbuilder2,StringBuilder cbuilder3) throws FileNotFoundException{
            PrintWriter p1=new PrintWriter(new File("user_output.txt"));
            PrintWriter p2=new PrintWriter(new File("answer_output.txt"));
            PrintWriter p3=new PrintWriter(new File("compare_output.txt"));

            String s1=new String(cbuilder1);
            String s2=new String(cbuilder2);
            String s3=new String(cbuilder3);

            p1.write(s1);
            p2.write(s2);
            p3.write(s3);



            p1.close();
            p2.close();
            p3.close();

    }
    static String usingStringBuffer(String content1,String content2) throws FileNotFoundException{
        StringBuilder cbuilder1=new StringBuilder();
        StringBuilder cbuilder2=new StringBuilder();
        StringBuilder cbuilder3=new StringBuilder();


        try(BufferedReader b1=new BufferedReader(new FileReader(content1));BufferedReader b2=new BufferedReader(new FileReader(content2))){

                String c1=null,c2=null;
                int i=0;
                while( (c2=b2.readLine())!=null && (c1=b1.readLine())!=null){
                    //cbuilder.append(c1).append("\n");
                    if(c1.equals(c2)){

                        cbuilder1.append(c1).append("\n");
                        cbuilder2.append(c2).append("\n");
                        cbuilder3.append(c1).append("      ").append(c2).append("\n");
                    
                    }
                    else{
                        i++;
                        cbuilder1.append(c1).append("------").append(i).append("\n");
                        cbuilder2.append(c2).append("------").append(i).append("\n");
                        cbuilder3.append(c1).append("------").append(c2).append("\n");
                    }

                }
                    //cbuilder2=cbuilder1;
                if((c2=b2.readLine())!=null && (c1=b1.readLine())==null){
                    //System.out.println("1111");
                    while((c2=b2.readLine())!=null){
                        System.out.println("2222");
                        System.out.println(c2);
                        cbuilder2.append(c2).append("\n");
                        cbuilder3.append("--------").append(c2).append("\n");
                    }
                }

                if((c2=b2.readLine())==null && (c1=b1.readLine())!=null){
                   // System.out.println("2222");
                    while((c1=b1.readLine())!=null){
                        cbuilder1.append(c1).append("\n");
                        cbuilder3.append(c1).append("--------").append("\n");
                    }
                }
        }
        catch(IOException e){
            e.printStackTrace();

    }
    outputfile(cbuilder1,cbuilder2,cbuilder3);  // function to print a output in file 
    return cbuilder3.toString();       //return user output 
    }
    public static void main(String[] args) throws Exception{

        System.out.println("\n USER     ANSWER \n-----------------\n"+usingStringBuffer("user.txt","answer.txt")+"-------------------");

                            //abc1.txt content user output
                            //abc2.txt content Answer output


        // PrintWriter p= new PrintWriter(new File("abc.txt"));

        // p.write("hello file");
        // p.close();
        
    }
}