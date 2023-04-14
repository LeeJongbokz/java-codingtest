import java.util.*; 

public class Main {
    
    
    
    
    
    public static void main(String args[]) {
    
    int maxCnt = Integer.MIN_VALUE;
    
    String[] kor = {"CCC", "BCDF"};
    String[] usa = {"XXXX"};
    String[] incs = {"BCDF CCC", "XXXX"};  
      
    HashMap<String, Integer> korNames = new HashMap<>();
    HashMap<String, Integer> usaNames = new HashMap<>(); 
    
    for(int i=0; i<kor.length; i++){
           String korName = kor[i];
           korNames.put(korName, 0);
    }

    for(int i=0; i<usa.length; i++){
           String usaName = usa[i];
           usaNames.put(usaName, 0);
    }



    for(int i=0; i<incs.length; i++){

      String inc = incs[i]; 
      String[] names = inc.split(" ");
      
	    for(int j=0; j<names.length; j++){
		    String name = names[j];

      	    if(korNames.containsKey(name)){
			    korNames.put(name, korNames.get(name)+1);
			    continue;
            }      

            if(usaNames.containsKey(name)){
                usaNames.put(name, usaNames.get(name)+1);
            }

      }         

    }
    
    for(String korName: korNames.keySet()){
        if(korNames.get(korName) == 0){
            korNames.remove(korName);
        }
    }
    
    for(String usaName: usaNames.keySet()){
        if(usaNames.get(usaName) == 0){
            usaNames.remove(usaName);
        }
    }
    

    
    

    int korSize = korNames.size();   
    int usaSize = usaNames.size(); 
    ArrayList<Integer>[] korDatas = new ArrayList[korSize+10];
    ArrayList<Integer>[] usaDatas = new ArrayList[usaSize+10];
    int korIndex = 0;
    int usaIndex = 0;


    for(int i=0; i<korSize; i++){
         korDatas[i] = new ArrayList<Integer>();
    }
     
    for(int i=0; i<usaSize; i++){
         usaDatas[i] = new ArrayList<Integer>();
    }

    for(String korName: korNames.keySet()){
               
        for(int i=0; i<incs.length; i++){
            String inc = incs[i];
            String[] incNames = inc.split(" ");
             
             for(int j=0; j<incNames.length; j++){
                 if(incNames[j].equals(korName)){
                     korDatas[korIndex].add(i+1);
                     break;
                 }
             }
        }
        korIndex++;
    }
    

    for(String usaName: usaNames.keySet()){
                   
         for(int i=0; i<incs.length; i++){
             String inc= incs[i];
             String[] incNames = inc.split(" ");
             
             for(int j=0; j<incNames.length; j++){
                 if(incNames[j].equals(usaName)){
                     usaDatas[usaIndex].add(i+1);
                     break;
                 }
             }
            
         }
         usaIndex++;
    }
    
    
    System.out.println("korIndex는?" + korIndex);
    System.out.println("usaIndex는?" + usaIndex);
    
    for(int i=0; i<korSize; i++){
    	  ArrayList<Integer> korData = korDatas[i];
          int[] upDays = new int[110];
    
          for(int j=0; j<korData.size(); j++){
                upDays[korData.get(j)]++; 
          }
          
    
          for(int j=0; j<usaSize; j++){
               ArrayList<Integer> usaData = usaDatas[j];
               int cnt = 0; 
    
    	       for(int k=0; k<usaData.size(); k++){
                   upDays[usaData.get(k)]++;
               }
               
                for(int k=1; k<=incs.length; k++){
                     System.out.print(upDays[k]+ " ");
               }
               System.out.println();
    
               for(int k=1; k<=incs.length; k++){
                     if(upDays[k] == 2){
    			        cnt++;
                     }
               }
    
               maxCnt = Math.max(maxCnt, cnt);	
    	     
    	     for(int k=0; k<usaData.size(); k++){
                   upDays[usaData.get(k)]--;
               }
          }
          
    }
      
      
      
    System.out.println(maxCnt);   
      
      
      
      
      
      
    }
}
