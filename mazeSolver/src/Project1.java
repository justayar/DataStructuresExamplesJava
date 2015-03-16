
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Project1 {

	private static Stack<Point> searchList=new Stack<Point>();
	 
	
	 private static String maze [][];
	
	  private static String resultCoordinate="";
	  
	 
      
      private static Point up;
	  private static Point down;
	  private static Point left;
	  private static Point right;
	  
	  
	  
	public static void main(String[] args) throws IOException{
		
		 int columnsnumber=0;
		 int rowsnumber=0;
		 
		 
		
		  ArrayList<String> points = new ArrayList<String>();
		
		try {



			BufferedReader buffer = new BufferedReader(new FileReader("pathForMaze.txt"));
			
			int index=0;
			
			while(true){

			 String line=buffer.readLine();
			 
			 if(line==null)break;
			 
			 points.add(index,line);

		     index++;
			}
			
			rowsnumber=index;

			buffer.close();

		} catch (FileNotFoundException e) {

			System.out.println("Cannot read the file.");
		}
		
		  
	       
	       String linesToPoints[]=points.get(0).split("\\s");
			 
		   columnsnumber=linesToPoints.length;  //get the columns number of maze after split by space
		   
	        maze=new String[rowsnumber][columnsnumber]; // defining matrices for adding values of each points to it in calculated row and number columns
	        
	       
	        
	        for(int i=0;i<rowsnumber;i++){
			 
			 String point[]=points.get(i).split("\\s"); //split each line by space
			 
			 for(int j=0;j<columnsnumber;j++){
				 
				 maze[i][j]=point[j];
				
				 
			 }
			 
			
		 }
	       
	        
	      //Search a path for the stack
	       
	        Point p=new Point(0,0,maze[0][0]);

	        searchList.push(p);

	        maze[0][0]="v";
	        
	        
	        findPath(rowsnumber,columnsnumber);
	        
	        
	        for(int i=0;i<maze[0].length;i++){
	        	
	        	for(int j=0;j<maze.length;j++){
	        		
	        		if(maze[i][j].equals("v")){
	        			
	        			maze[i][j]="0";
	        		}
	        	}
	        }
	        
	     
	        if(searchList.isEmpty()){
	        	
	        	System.out.println("The maze is not solvable.");
	        	
	        }else{
           
            while(!searchList.isEmpty()){
            	
            	Point x=searchList.pop();
            	
            	maze[x.getX()][x.getY()]="*";
            }
            
            
            
            PrintWriter wr = null;
            
            try {

            	wr = new PrintWriter(new FileWriter("maze-sol.txt"));
            	for (int i = 0; i < maze[0].length; i++) {

            		for(int j=0;j<maze.length;j++){

            			wr.print(maze[i][j]+" ");

            		}
            		wr.println();
            	}

            	wr.println("The exit found at coordinate : "+resultCoordinate);
            	wr.close();
             } catch (IOException e) {
            	System.out.println("Can't create the output file.");
           }


	    }

    }
	
	
	public static void findPath(int rowsnumber,int columnsnumber){
		
		 
		
		 while(!searchList.isEmpty()){
			 
	        	Point current =searchList.pop();

	        	int x=current.getX();

	        	int y=current.getY();
	        	
	        //	System.out.println("current x:"+x);
	        //	System.out.println("current y:"+y);
	        	
	        //	printMaze(maze);

	        	String value=current.getValue();
	        	
            
		        	if(x==0){  // this means theres is no up neighbours

		        		if(y==0){ //this means that the point is (0,0) , there is no left point.

		        			right=new Point(x,y+1,maze[x][y+1]);

		        			down=new Point(x+1,y,maze[x+1][y]);
		        			
		        			if(maze[x][y+1].equals("9")){
		        				
		        				resultCoordinate="("+right.getX()+","+right.getY()+")";
		        				
		        				searchList.push(current);
		        				
		        				break;
		        				
		        			}else if(maze[x+1][y].equals("9")){
		        				
		        				searchList.push(current);
		        				resultCoordinate="("+down.getX()+","+down.getY()+")";
		        			}
		        			
		        			

		        			if(maze[x][y+1].equals("1") || maze[x][y+1].equals("v")){ // right is not available

		        				if(maze[x+1][y].equals("1") ||maze[x+1][y].equals("v")){ // if down also is right availbla so no solvable

		        					
		        					findPath(rowsnumber,columnsnumber);
		        					

		        				}else if(maze[x+1][y].equals("0")){ // if down is available


		        					maze[x+1][y]="v";

		        					searchList.push(current);

		        					searchList.push(down);

		        				}

		        			}else{ // if right is available

		        				maze[x][y+1]="v";

		        				searchList.push(current);

		        				searchList.push(right);
		        			}

		        		}else if(y==columnsnumber-1){ // this means that the point in upper right,there is no right also

		        			

		        			down=new Point(x+1,y,maze[x+1][y]);

		        			left=new Point(x,y-1,maze[x][y-1]);
		        			
		        			
                         if(maze[x+1][y].equals("9")){
		        				
		        				resultCoordinate="("+down.getX()+","+down.getY()+")";
		        				
		        				searchList.push(current);
		        				break;
		        				
		        				
		        			}else if(maze[x][y-1].equals("9")){
		        				
		        				resultCoordinate="("+left.getX()+","+left.getY()+")";
		        				
		        				searchList.push(current);
		        				
		        				break;
		        				
		        				
		        			}

		        			  if(maze[x+1][y].equals("1") || maze[x+1][y].equals("v")){ // down is not available

		        				    if(maze[x][y-1].equals("1") ||maze[x][y-1].equals("v")){ // if left also is not available so no solvable

		        				    	findPath(rowsnumber,columnsnumber);

		        				    }else{ // if left is available

		        					    maze[x][y-1]="v";

		        					   searchList.push(current);

		        					   searchList.push(left);

		        				    }

		        			   }else{ // if down is available

		        				   maze[x+1][y]="v";

		        				   searchList.push(current);

		        				   searchList.push(down);
		        			   }




		        		}else{  // y is neither 0 nor the last right element

		        			right=new Point(x,y+1,maze[x][y+1]);

		        			down=new Point(x+1,y,maze[x+1][y]);

		        			left=new Point(x,y-1,maze[x][y-1]);
		        			
		        			 if(maze[x+1][y].equals("9")){
			        				
			        				resultCoordinate="("+down.getX()+","+down.getY()+")";
			        				searchList.push(current);
			        				break;
			        				
			        				
			        			}else if(maze[x][y-1].equals("9")){
			        				
			        				resultCoordinate="("+left.getX()+","+left.getY()+")";
			        				searchList.push(current);
			        				break;
			        				
			        				
			        			}else if(maze[x][y+1].equals("9")){
			        				
			        				resultCoordinate="("+right.getX()+","+right.getY()+")";
			        				searchList.push(current);
			        				break;
			        			}
		        			

	                     
		        			if(maze[right.getX()][right.getY()].equals("1") || maze[x][y+1].equals("v")){ // right is not available
	                         
		        				
		        				if(maze[x+1][y].equals("1") || maze[x+1][y].equals("v")){ // if down also is right availbla so no solvable
		        					
		        					   
		        					if(maze[x][y-1].equals("1") || maze[x][y-1].equals("v")){ // none of them is available so no solvable

		        						findPath(rowsnumber,columnsnumber);

		        					     }else{ // left is available, down and right is not available

		        						    maze[x][y-1]="v";

		        					     	searchList.push(current);

		        					     	searchList.push(left);
		        					    }


		        				  }else{  // down is available but right is not available

		        					maze[x+1][y]="v";

		        					searchList.push(current);

		        					searchList.push(down);
		        					
		        					
		        				 }


		        			}else{ // right is available
		        				
		        				

		        				maze[x][y+1]="v";

		        				searchList.push(current);

		        				searchList.push(right);

		        			}
		        		}	
		        		
		        	}else if(x==rowsnumber-1){
		        		
		        		
		        		if(y==0){
		        			
                            up=new Point(x-1,y,maze[x-1][y]);
		        			
		        			right=new Point(x,y+1,maze[x][y+1]);
		        			
		        		  
		        			if(maze[x-1][y].equals("9")){
		        				
		        				resultCoordinate="("+up.getX()+","+up.getY()+")";
		        				searchList.push(current);
		        				break;
		        				
		        				
		        			}else if(maze[x][y+1].equals("9")){
		        				
		        				resultCoordinate="("+right.getX()+","+right.getY()+")";
		        				searchList.push(current);
		        				break;
		        				
		        			}
		        			
		        			
		        			
		        			 if(maze[up.getX()][up.getY()].equals("1") ||maze[up.getX()][up.getY()].equals("v")){
		        				   
		        				   if(maze[right.getX()][right.getY()].equals("1") || maze[right.getX()][right.getY()].equals("v")){
		        					   
		        					   findPath(rowsnumber,columnsnumber);
		        					   
		        				   }else{
		        					   
		        					   maze[right.getX()][right.getY()]="v";

		       	        				searchList.push(current);

		       	        				searchList.push(right);
		        					   
		        				   }
		        				   
		        			 }else{
		        				 
		        				    maze[up.getX()][up.getY()]="v";

	       	        				searchList.push(current);

	       	        				searchList.push(up);
		        				 
		        			 }

		        			
		        		}else if(y==columnsnumber-1){
		        			
		        			
		        			
		        			  up=new Point(x-1,y,maze[x-1][y]);
			        			
			        	      left=new Point(x,y-1,maze[x][y-1]);
			        	      
			        	   
			        	      
			        	      if(maze[x-1][y].equals("9")){
			        				
			        				resultCoordinate="("+up.getX()+","+up.getY()+")";
			        				searchList.push(current);
			        				break;
			        				
			        				
			        			}else if(maze[x][y-1].equals("9")){
			        				
			        				resultCoordinate="("+left.getX()+","+left.getY()+")";
			        				searchList.push(current);
			        				break;
			        				
			        			}
			        	      
			        	      
			        	      
			        	      if(maze[up.getX()][up.getY()].equals("1") ||maze[up.getX()][up.getY()].equals("v")){
		        				   
		        				   if(maze[left.getX()][left.getY()].equals("1") || maze[left.getX()][left.getY()].equals("v")){
		        					   
		        					   
		        					   findPath(rowsnumber,columnsnumber);
		        					   
		        				   }else{
		        					   
		        					   maze[left.getX()][left.getY()]="v";

		       	        				searchList.push(current);

		       	        				searchList.push(left);
		        					   
		        				   }
			        			
		        			
		        	 	 	
		        		     }else{
		        		    	 
		        		    	    maze[up.getX()][up.getY()]="v";

	       	        				searchList.push(current);

	       	        				searchList.push(up);
		        		    	 
		        		     }
		        		      
		        		
		        		}else{
		        			
		        			  up=new Point(x-1,y,maze[x-1][y]);
		        			  
		        			  right=new Point(x,y+1,maze[x][y+1]);
			        			
			        	      left=new Point(x,y-1,maze[x][y+1]);
			        	      
			        	      
			        	      if(maze[x-1][y].equals("9")){
			        				
			        				resultCoordinate="("+up.getX()+","+up.getY()+")";
			        				searchList.push(current);
			        				
			        				break;
			        				
			        				
			        			}else if(maze[x][y+1].equals("9")){
			        				
			        				resultCoordinate="("+right.getX()+","+right.getY()+")";
			        				searchList.push(current);
			        				
			        				break;
			        				
			        			}else if(maze[x][y-1].equals("9")){
			        				
			        				resultCoordinate="("+left.getX()+","+left.getY()+")";
			        				searchList.push(current);
			        				
			        				break;
			        			}
			        	      
			        	      
			        	      if(maze[up.getX()][up.getY()].equals("1") ||maze[up.getX()][up.getY()].equals("v")){
		        				   
		        				   if(maze[right.getX()][right.getY()].equals("1") || maze[right.getX()][right.getY()].equals("v")){
		        					   
		        					   if(maze[left.getX()][left.getY()].equals("1") || maze[left.getX()][left.getY()].equals("v")){
		        						   
		        						   findPath(rowsnumber,columnsnumber);
			        	      
		        					   }else{
		        						   
		        						    maze[left.getX()][left.getY()]="v";

			       	        				searchList.push(current);

			       	        				searchList.push(left);
		        						   
		        					   }
		        					   
		        					   
		        				   }else{
		        					   
		        				   
		        					   maze[right.getX()][right.getY()]="v";

		       	        				searchList.push(current);

		       	        				searchList.push(right);
		        				   }
		        				   
			        	      }else{
			        	    	  
			        	    	   maze[up.getX()][up.getY()]="v";

	       	        				searchList.push(current);

	       	        				searchList.push(up);
			        	      }
		        			
		        			
		        		}
		        		
		        	

		        	}else{ // x is not 0
		        		
		        		
		        		if(y==0){
		        			
		        			up=new Point(x-1,y,maze[x-1][y]);
		        			
		        			right=new Point(x,y+1,maze[x][y+1]);

		        			down=new Point(x+1,y,maze[x+1][y]);
		        			
		        			
		        			if(maze[x-1][y].equals("9")){
		        				
		        				resultCoordinate="("+up.getX()+","+up.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        				
		        			}else if(maze[x][y+1].equals("9")){
		        				
		        				resultCoordinate="("+right.getX()+","+right.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        			}else if(maze[x+1][y].equals("9")){
		        				
		        				resultCoordinate="("+down.getX()+","+down.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        			}

		        			
		        			   if(maze[up.getX()][up.getY()].equals("1") ||maze[up.getX()][up.getY()].equals("v")){
		        				   
		        				   if(maze[right.getX()][right.getY()].equals("1") || maze[right.getX()][right.getY()].equals("v")){
		        					   
		        					   if(maze[down.getX()][down.getY()].equals("1") || maze[down.getX()][down.getY()].equals("v")){
		        						   
		        						   findPath(rowsnumber,columnsnumber);
		        						   
		        					   }else{
		        						   

		       	        				maze[down.getX()][down.getY()]="v";

		       	        				searchList.push(current);

		       	        				searchList.push(down);

		        						   
		        					   }
		        					   
		        				   }else{
		        					   

		   	        				maze[right.getX()][right.getY()]="v";

		   	        				searchList.push(current);

		   	        				searchList.push(right);

		        					   
		        				   }
		        				   
		        			   }else{
		        				   

			        				maze[up.getX()][up.getY()]="v";

			        				searchList.push(current);

			        				searchList.push(up);

		        			   }
		        			

		        		}else if(y==columnsnumber-1){
		        			
	                        up=new Point(x-1,y,maze[x-1][y]);
		        			
		        			down=new Point(x+1,y,maze[x+1][y]);
		        			
		        			left=new Point(x,y-1,maze[x][y-1]);
		        			
		        			
		        			if(maze[x-1][y].equals("9")){
		        				
		        				resultCoordinate="("+up.getX()+","+up.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        				
		        			}else if(maze[x+1][y].equals("9")){
		        				
		        				resultCoordinate="("+down.getX()+","+down.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        			}else if(maze[x][y-1].equals("9")){
		        				
		        				resultCoordinate="("+left.getX()+","+left.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        			}

		        			
		        			   if(maze[up.getX()][up.getY()].equals("1") ||maze[up.getX()][up.getY()].equals("v")){
		        				   
		        				   if(maze[down.getX()][down.getY()].equals("1") || maze[down.getX()][down.getY()].equals("v")){
		        					   
		        					   if(maze[left.getX()][left.getY()].equals("1") || maze[left.getX()][left.getY()].equals("v")){
		        						   
		        						   findPath(rowsnumber,columnsnumber);
		        						   
		        					   }else{
		        						   

		       	        				maze[left.getX()][left.getY()]="v";

		       	        				searchList.push(current);

		       	        				searchList.push(left);

		        						   
		        					   }
		        					   
		        				   }else{
		        					   

		   	        				maze[down.getX()][down.getY()]="v";

		   	        				searchList.push(current);

		   	        				searchList.push(down);

		        					   
		        				   }
		        				   
		        			   }else{
		        				   

			        				maze[up.getX()][up.getY()]="v";

			        				searchList.push(current);

			        				searchList.push(up);

		        			   }
		        			
		        			
		        			
		        		}else{ // y is neither 0 nor lastlement of the right
		        			
		        			 up=new Point(x-1,y,maze[x-1][y]);
		        			 
		        			right=new Point(x,y+1,maze[x][y+1]);

		        			down=new Point(x+1,y,maze[x+1][y]);

		        			left=new Point(x,y-1,maze[x][y-1]);
		        			
		        			
		        			if(maze[x-1][y].equals("9")){
		        				
		        				resultCoordinate="("+up.getX()+","+up.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        				
		        			}else if(maze[x][y+1].equals("9")){
		        				
		        				resultCoordinate="("+right.getX()+","+right.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        			}else if(maze[x][y-1].equals("9")){
		        				
		        				resultCoordinate="("+left.getX()+","+left.getY()+")";
		        				searchList.push(current);
		        				
		        				break;
		        				
		        			}else if(maze[x+1][y].equals("9")){
		        				
                              resultCoordinate="("+down.getX()+","+down.getY()+")";
                              searchList.push(current);
                              
		        				
		        				break;
		        			}
		        			
		        			
		        			
		        			if(maze[x-1][y].equals("1") || maze[x-1][y].equals("v")){ // up is not available


		        				if(maze[x][y+1].equals("1") || maze[x][y+1].equals("v")){ // up and right is not available


		        					if(maze[x+1][y].equals("1") || maze[x+1][y].equals("v")){// up,right and down is not available


		        						if(maze[x][y-1].equals("1") || maze[x][y-1].equals("v")){


		        							findPath(rowsnumber,columnsnumber);
		        							
		        						}else{

		        							maze[left.getX()][left.getY()]="v";

		        							searchList.push(current);

		        							searchList.push(left);

		        						}

		        					}else{

		        						maze[down.getX()][down.getY()]="v";

		        						searchList.push(current);

		        						searchList.push(down);

		        					}


		        				}else{
		        					
		        					maze[right.getX()][right.getY()]="v";

	        						searchList.push(current);

	        						searchList.push(right);
		        				}

		        			}else{
		        				
		        				maze[up.getX()][up.getY()]="v";

     						searchList.push(current);

     						searchList.push(up);
		        			}

		        			
		        			
		        		}

		        	}
		        	
		        }
         
         
         
	}
	 
	public static void printMaze(String arr[][]){  //printing maze
		
		for(int i=0;i<arr.length;i++){
			
			for(int j=0;j<arr[0].length;j++){
				
					System.out.print(arr[i][j]+" ");
				
			}
			
			System.out.println();
		}
	}
	
	

}
