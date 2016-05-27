package arff;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Month2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.csv"));
		
		/*-----------------------------------------------------------*/
		String name = "season";//改此，此為檔案名稱
		BufferedWriter bw = new BufferedWriter(new FileWriter(name + "_test.csv"));
		/*-----------------------------------------------------------*/
		
		//ArrayList用來寫出arff檔的header
		ArrayList<String> ls_dates = new ArrayList<String>();
		ArrayList<String> ls_category = new ArrayList<String>();
		ArrayList<String> ls_dayofweek = new ArrayList<String>();
		ArrayList<String> ls_pddistrict = new ArrayList<String>();
		ArrayList<String> ls_address = new ArrayList<String>();
		
		String line =br.readLine();
		while(br.ready()){
			line = br.readLine();//each instance/row.
			line = line.replaceAll(" ", "_");
			String[] columns = line.split(",");
			
			for(int i = 0; i < columns.length; i++){
				switch(i){
				
				/*---------------------------------------------------*/
				case 0://Dates
					String m = columns[i].split("/")[1];
					if(Integer.valueOf(m)==12 || Integer.valueOf(m)==1 || Integer.valueOf(m)==2){
						bw.write("winter,WARRANTS");
					}
					if(Integer.valueOf(m)==3 || Integer.valueOf(m)==4 || Integer.valueOf(m)==5){
						bw.write("spring,WARRANTS");
					}
					if(Integer.valueOf(m)==6 || Integer.valueOf(m)==7 || Integer.valueOf(m)==8){
						bw.write("summer,WARRANTS");
					}
					if(Integer.valueOf(m)==9 || Integer.valueOf(m)==10 || Integer.valueOf(m)==11){
						bw.write("fall,WARRANTS");
					}
					if(!ls_dates.contains(m))
						ls_dates.add(m);
					break;
				/*---------------------------------------------------*/
					
				/*case 2://Category
					bw.write(columns[i]);
					if(!ls_category.contains(columns[i]))
						ls_category.add(columns[i]);
					break;*/
					
				case 1://DayofWeek
					bw.write(columns[i]);
					if(!ls_dayofweek.contains(columns[i]))
						ls_dayofweek.add(columns[i]);
					break;
					
				case 2://PdDistrict
					bw.write(columns[i]);
					if(!ls_pddistrict.contains(columns[i]))
						ls_pddistrict.add(columns[i]);
					break;
					
				case 3://Address
					bw.write(columns[i]);
					if(!ls_address.contains(columns[i]))
						ls_address.add(columns[i]);
					break;
					
				case 4://X
					bw.write(columns[i]);
					break;
					
				case 5://Y
					bw.write(columns[i]);
					break;
					
				default:					
					System.out.println(i + line + "!!!! Something wrong!");
					break;
				}
				
				if(i != columns.length-1)
					bw.write(",");
			}//for end
			System.out.println(line);
			bw.newLine();
		}//while end
		
		//寫header
		bw.write("\n@relation " + name + "\n\n");
		
		bw.write("@attribute ID numeric\n");
		
		bw.write("@attribute Dates {");
		for(String each : ls_dates)
			bw.write("," + each);
		bw.write("}\n");
		
		bw.write("@attribute Dayofweek {");
		for(String each : ls_dayofweek)
			bw.write("," + each);
		bw.write("}\n");
		
		bw.write("@attribute PdDistrict {");
		for(String each : ls_pddistrict)
			bw.write("," + each);
		bw.write("}\n");
		
		bw.write("@attribute Address {");
		for(String each : ls_address)
			bw.write("," + each);
		bw.write("}\n");
		
		bw.write("@attribute X numeric\n");
		bw.write("@attribute Y numeric\n\n");
		
		/*bw.write("@attribute Category {");
		for(String each : ls_category)
			bw.write("," + each);
		bw.write("}\n");*/
		
		bw.write("@data\n");
		
		br.close();
		bw.close();
	}
}
