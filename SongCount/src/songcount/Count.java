/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songcount;

/**
 *
 * @author ygt
 */

    
    import java.lang.*;
import java.lang.Object;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.*;
public class Count {
        ArrayList<String> hs = new ArrayList<String>(); //This Set keeps PLAY_ID list
        LinkedHashSet<String> hs2 = new LinkedHashSet<String>(); //This Set keeps CLIENT_ID list
        LinkedHashSet<String> hs3 = new LinkedHashSet<String>(); //This Set keeps SONG_ID list
        List<ItemsData> ItemsList = new ArrayList<>(); //This ArrayList keeps all items of CSV file
        List<ItemsData> newList = new ArrayList<>();  //This ArrayList keeps items at the date of 10.08.2016
		
	ArrayList<String >lastList = new ArrayList<String>();
	public void calculateSongCount() throws IOException
	{
                
		BufferedReader reader = new BufferedReader(new FileReader(
				"exhibitA-input.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		

		while ((line = reader.readLine()) != null) {
			ItemsData list = new ItemsData();
			
			scanner = new Scanner(line);
			while (scanner.hasNext()) {
				String information = scanner.next();
                                if(index == 0){
                                        list.setPLAYID(information);
                                        hs.add(information);
				}		
				else if (index == 1){
                                        list.setSONG(information);
                                        hs3.add(information);
                                }
				else if (index == 2){    
                               
					list.setCLIENT(information);
                                        hs2.add(information);
                                }
				else if (index == 3){
                                   
                                    list.setDATE(information);   
                                }
                                
				else if (index == 4){
                                    list.setTime(information);   
                                }	
                                else 
					System.out.println("Invalid information is on the list ::" + information);
				index++;
			}
			index = 0;
			ItemsList.add(list);
		}
		Set<String> smallSet = new HashSet<String>();
                System.out.println("The size of Original List  is : "+ItemsList.size());
                lastList.addAll(hs2);
                
                for(int indexSecond = 0;indexSecond<ItemsList.size();indexSecond++)
                {
                    if(ItemsList.get(indexSecond).getDate().startsWith("10/08/2016"))
                    {
                        newList.add(ItemsList.get(indexSecond));
                    }
                }
                System.out.println("The size of New List which contain only date of 10/08/2016,  is: "+Integer.toString(newList.size()));
             
                 List<String> list;
                 int []array = new int[lastList.size()];//This ArrayList shows how many song each user listens
                 int []arrays = new int[lastList.size()]; //This ArrayList shows how many copy of number which is in the above array 
                 ArrayList<Integer> list_One = new ArrayList<Integer>();//This ArrayList keeps numbers which shows how many song each user listens but only one copy
                
                 // Calculate ,How many song each user listen 
                 for(long indexThird = 0;lastList.size() >indexThird;indexThird++)
                {
                    smallSet.clear();
                     for(long counter = 0;counter<newList.size();counter++)
                     {
                         if((newList.get((int)counter).getDate().startsWith("10/08/2016"))&&( lastList.get((int)indexThird).equals(newList.get((int)counter).getCLIENTID())))
                         {
                                        smallSet.add(newList.get((int)counter).getSONGID());
                                        
                         }  
                     }
                     array[(int)indexThird]  =smallSet.size();
                            
                 }
                 
                 //Add one copy each number in the array to the ArrayList
                for(long repeat = 0;repeat<array.length;repeat++)
                {
                    if(!list_One.contains(array[(int)repeat]))
                    {
                        list_One.add(array[(int)repeat]);
                                
                    }
                }
            
                int str = 0;
                int []array_Two = new int[list_One.size()];
                
                //Calculate how many copy each  number in the array 
                for(long indexFifth = 0 ;indexFifth<list_One.size();indexFifth++)
                {
                    str=0;
                    for(long indexSeven = 0;indexSeven<array.length;indexSeven++)
                    {
                        if(list_One.get((int)indexFifth) == array[(int)indexSeven])
                        {
                            str++;
                        }
                        
                    }
                    array_Two[(int)indexFifth] =str; 
                }

                int howMany = 0;
                for(int indexNine = 0; indexNine < array.length; indexNine++)
                {
                    if(array[indexNine] == 346)
                    {
                        howMany++;
                    }
                  
                }
		Integer maximum = Collections.max(list_One);
                System.out.println("There is "+Integer.toString(howMany)+" different user listen to 346 songs at the 10.08.2016");
                System.out.println("The maximum value listening to song of one client is : "+maximum);
                FileWriter fileWriter = null;

                 
                final String FILE_TITLE = "DISTINCT_SONG_COUNT    CLIENT_COUNT";
                final String COMMA_OPERATOR = ",";
                final String TAB_DELIMITER = "    ";

                final String NEW_LINE_OPERATOR = "\n";

                try {

                    fileWriter = new FileWriter("Output.csv");

                     //Write the CSV file header

                    fileWriter.append(FILE_TITLE.toString());

                    //Add a new line separator after the header

                    fileWriter.append(NEW_LINE_OPERATOR);

                    //Write a new number  to the CSV file

                    for (int u=1;u<list_One.size();u++) {

                            fileWriter.append(String.valueOf(list_One.get(u)));
                            fileWriter.append(COMMA_OPERATOR);
                            fileWriter.append(TAB_DELIMITER);
                            fileWriter.append(String.valueOf(array_Two[u]));
                            fileWriter.append(NEW_LINE_OPERATOR);

                    }
 
                    System.out.println("CSV file create successfully !");

             

                } 
                catch (Exception e) {

                    System.out.println("Error made in CsvFileWriter !!!");
                    e.printStackTrace();

                }
                finally {

                    try {

                        fileWriter.flush();
                        fileWriter.close();

                    }
                    catch (IOException e) {

                        System.out.println("Error in flushing/closing fileWriter !!!");
                        e.printStackTrace();

                    }

             

                }

    


                
    

  
        }
                
                
}