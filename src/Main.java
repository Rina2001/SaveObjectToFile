import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.jws.WebParam.Mode;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class Main {
	File ff=new File("src/test.txt");
	public static void main(String[] args)throws Exception {
		new Main().writeFile();
		new Main().readFile();
		   
	}
	
	public void readFile()throws Exception {
		boolean cont = true;
		
		if(ff.exists()) {
			ArrayList<Object> objectsList = new ArrayList<Object>();
			try{
				FileInputStream inputStream=new FileInputStream("src/test.txt");
				ObjectInputStream objOut=new ObjectInputStream(inputStream);
			   while(cont){
			      Object obj = objOut.readObject();
			      if(obj != null)
			         objectsList.add(obj);
			      else
			         cont = false;
			   }
			}catch(Exception e){
			  
			}
			
			ArrayList<Model> list=new ArrayList<Model>();
			for(Object obj:objectsList) {
				ArrayList<Model> modellist=(ArrayList<Model>)obj;
				for(Model m:modellist) {
					list.add(m);
				}
				
			}
		     System.out.println("Read Object"+list.size());
			
		}
		else {
			System.out.println("File is not exist!!!");
		}
	}
	
	
	
     public void writeFile()throws Exception {
 		if(ff.exists()) {
			ArrayList<Model> list=new ArrayList<Model>();
 			FileOutputStream file =new FileOutputStream(ff,true);
 			AppendingObjectOutputStream output=new AppendingObjectOutputStream(file);
 			 list.add(new Model("rina "+new Random().nextInt()));
 			    list.add(new Model("jane"+new Random().nextInt()));
 			    output.writeObject(list);	    
 			    file.close();
 			    output.close();
 			   System.out.println("After Append File"+list.size());
 			    
 		}
 		else {
 			ArrayList<Model> list=new ArrayList<Model>();
 			System.out.println("Insert new file");
 			ff.createNewFile();
 			FileOutputStream file =new FileOutputStream(ff);
 			ObjectOutputStream out=new ObjectOutputStream(file);
 			    list.add(new Model("rina"+new Random().nextInt()));
 			    list.add(new Model("jane"+new Random().nextInt()));
 				    out.writeObject(list);
 		    
 		    out.close();
 		    file.close();
 		}
     }
	
}
