package arff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Criminal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String out="";
		String in="";
		String outx="";
		String outy="";
		int count=0;
		int count2=0;
		FileWriter fw = new FileWriter("criminalout.txt");
		FileReader fr = new FileReader("criminal.txt");
		 BufferedReader br = new BufferedReader(fr);
		 
		 while(br.ready()){
			 in=br.readLine();
			 for(int x=0;x<in.length();x++){
				 if(in.charAt(x)==44){
					count++;
				 }
				 if(in.charAt(x)==45 && in.charAt(x+1)==49 && in.charAt(x+2)==50 && in.charAt(x+3)==50){
					 count2++;
				 }
				 if(count==1){
					 if(in.charAt(x)!=44 && in.charAt(x)!=34 && in.charAt(x)!=32){
					 out+=in.charAt(x);
					 }
				 }
				 if(count2==1){
					 if(in.charAt(x)!=44){
						 outx+=in.charAt(x);
						 }else{
							 count2++;
						 }
				 }
				 if(count2==2){
					 if(in.charAt(x)!=44){
						 outy+=in.charAt(x);
						 }
				 }
				 
			 }
			 count=0;
			 count2=0;
			 System.out.println(out+","+outx+","+outy);
			 fw.write(out+","+outx+","+outy+"\r\n");
			 fw.flush();
			 out="";
			 outx="";
			 outy="";
		 }
		 fw.close();
	}

}
