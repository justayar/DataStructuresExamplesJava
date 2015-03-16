package myHash;

import java.util.*;
import java.io.*;

public class TestUse 
{
	public static void main(String [ ] args)
	{

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		CuckooHash ch = new CuckooHash();

		try{

			BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));

			try{
				BufferedReader rd=new BufferedReader(new FileReader("intput.txt"));


				long startTime = System.currentTimeMillis();
				while(true){

					String line=rd.readLine();
					if(line==null)break;


					String line_parts[]=line.split("\t");
					HashNode node=new HashNode(Integer.parseInt(line_parts[0]), line_parts[1]);


					if(!map.containsKey(node.key)){
						map.put(Integer.parseInt(line_parts[0]), line_parts[1]);

					}

				}





				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;	
				System.out.println("The total add time for hashmap: "+elapsedTime);
				bw.write("The total add time to HashMap is: "+elapsedTime);
				bw.newLine();





				rd.close();


			}catch(Exception e) {
				e.printStackTrace();
			}


			try{

				BufferedReader rd3=new BufferedReader(new FileReader("Remove10.txt"));

				long startTime3 = System.currentTimeMillis();
				while(true){

					String line3=rd3.readLine();
					if(line3==null)break;


					String line_parts2[]=line3.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);

					if(map.containsKey(node.key)){

						map.remove(node.key);


					}

				}
				long stopTime3 = System.currentTimeMillis();
				long elapsedTime3 = stopTime3 - startTime3;	
				System.out.println("The total 10-remove time to HashMap is:"+elapsedTime3);
				bw.write("The total 10-remove time to HashMap is:"+elapsedTime3);
				bw.newLine();


				rd3.close();



			}catch(Exception e) {
				e.printStackTrace();

			}

			try{

				BufferedReader rd5=new BufferedReader(new FileReader("Remove100.txt"));

				long startTime5 = System.currentTimeMillis();
				while(true){

					String line5=rd5.readLine();
					if(line5==null)break;


					String line_parts2[]=line5.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);

					if(map.containsKey(node.key)){

						map.remove(node.key);


					}



				}
				long stopTime5 = System.currentTimeMillis();
				long elapsedTime5 = stopTime5 - startTime5;	
				System.out.println("The total 100-remove time to HashMap is:"+elapsedTime5);
				bw.write("The total 100-remove time to HashMap is:"+elapsedTime5);
				bw.newLine();


				rd5.close();



			}catch(Exception e) {
				e.printStackTrace();

			}




			try{

				BufferedReader rd2=new BufferedReader(new FileReader("intput.txt"));

				long startTime2 = System.currentTimeMillis();
				while(true){

					String line2=rd2.readLine();
					if(line2==null)break;


					String line_parts2[]=line2.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);

					ch.insert(node);

				}

				long stopTime2 = System.currentTimeMillis();
				long elapsedTime2 = stopTime2 - startTime2;	
				bw.newLine();
				System.out.println("The total add time to CuckooHash is: "+elapsedTime2);
				bw.write("The total add time to CuckooHash is: "+elapsedTime2);
				bw.newLine();

				rd2.close();


			}catch(Exception e) {
				e.printStackTrace();
			}



			// Remove the given 10 and 100 values in each hash structure
			// and measure the time for each one.




			try{

				BufferedReader rd4=new BufferedReader(new FileReader("Remove10.txt"));

				long startTime4 = System.currentTimeMillis();
				while(true){

					String line4=rd4.readLine();
					if(line4==null)break;


					String line_parts2[]=line4.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);




					ch.remove(node);


				}




				long stopTime4 = System.currentTimeMillis();
				long elapsedTime4 = stopTime4 - startTime4;	
				System.out.println("The total 10-remove time to CuckooHash is: "+elapsedTime4);
				bw.write("The total 10-remove time to CuckooHash is: "+elapsedTime4);
				bw.newLine();

				rd4.close();



			}catch(Exception e) {
				e.printStackTrace();
			}




			try{

				BufferedReader rd6=new BufferedReader(new FileReader("Remove100.txt"));

				long startTime6 = System.currentTimeMillis();
				while(true){

					String line6=rd6.readLine();
					if(line6==null)break;


					String line_parts2[]=line6.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);


					ch.remove(node);


				}

				long stopTime6 = System.currentTimeMillis();
				long elapsedTime6 = stopTime6 - startTime6;	
				System.out.println("The total 100-remove time to CuckooHash is: "+elapsedTime6);
				bw.write("The total 100-remove time to CuckooHash is: "+elapsedTime6);
				bw.newLine();
				bw.newLine();


				rd6.close();

			}catch(Exception e) {
				e.printStackTrace();
			}




			try{

				BufferedReader br7=new BufferedReader(new FileReader("Search.txt"));

				long startTime7 = System.currentTimeMillis();

				while(true){

					String line=br7.readLine();

					if(line==null)break;

					String line_parts2[]=line.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);



					if((map.get(node.key)!=null)){
						System.out.println("The key "+node.key+" is found.");



					}else{

						System.out.println("The key "+node.key+" is not found.");
					}

				}

				long stopTime7 = System.currentTimeMillis();
				long elapsedTime7 = stopTime7 - startTime7;	
				System.out.println("The search time to HashMap is: "+elapsedTime7);

				br7.close();



			}catch(Exception e) {
				e.printStackTrace();
			}


			try{

				BufferedReader br8=new BufferedReader(new FileReader("Search.txt"));

				long startTime8 = System.currentTimeMillis();

				while(true){

					String line=br8.readLine();

					if(line==null)break;

					String line_parts2[]=line.split("\t");

					HashNode node=new HashNode(Integer.parseInt(line_parts2[0]), line_parts2[1]);



					if(ch.find(node)==true){

						System.out.println("The key "+node.key+" is found.");
						bw.write("The key "+node.key+" is found.");
						bw.newLine();

					}else{

						System.out.println("The key "+node.key+" is not found.");
						bw.write("The key "+node.key+" is not found.");
						bw.newLine();
					}

				}

				long stopTime8 = System.currentTimeMillis();
				long elapsedTime8 = stopTime8 - startTime8;	
				System.out.println("The search time to CuckooHash is: "+elapsedTime8);


				br8.close();




			}catch(Exception e) {
				e.printStackTrace();
			}






			// Now open the search.txt file and look for the keys given in the file.
			// Again, you need to search for all keys once in the HashMap, and measure the
			// total time it took, and repeat with the CuckooHash and measure the time.

			// For each key you are looking for in the CuckooHash,
			// if  found, write 'the key --- is found', and otherwise,
			// write 'the key --- is not found' in the output file.

			// The key --- is found.
			// ...
			// The key --- is found.
			// ...
			// The key --- is not found.
			// ...

			bw.close();

		}catch(Exception e) {
			e.printStackTrace();
		}



	}
}
