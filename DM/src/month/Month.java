package month;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Month {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.csv"));
		
		/*-----------------------------------------------------------*/
		String name = "month";//改此，此為檔案名稱
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
			
			for(int i = 1; i < columns.length; i++){
				switch(i){
				
				/*---------------------------------------------------*/
				case 1://Dates
					String m = columns[i].split("/")[1];
					bw.write(m + ",WARRANTS");//為了符合test data用
					if(!ls_dates.contains(m))
						ls_dates.add(m);
					break;
				/*---------------------------------------------------*/
					
				/*case 2://Category
					bw.write(columns[i]);
					if(!ls_category.contains(columns[i]))
						ls_category.add(columns[i]);
					break;*/
					
				case 2://DayofWeek
					bw.write(columns[i]);
					if(!ls_dayofweek.contains(columns[i]))
						ls_dayofweek.add(columns[i]);
					break;
					
				case 3://PdDistrict
					bw.write(columns[i]);
					if(!ls_pddistrict.contains(columns[i]))
						ls_pddistrict.add(columns[i]);
					break;
					
				case 4://Address
					bw.write(columns[i]);
					if(!ls_address.contains(columns[i]))
						ls_address.add(columns[i]);
					break;
					
				case 5://X
					bw.write(columns[i]);
					break;
					
				case 6://Y
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
