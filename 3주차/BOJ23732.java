import java.util.*; 

public class Main {
    
    public static void main(String args[]) {
      
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); 
        String str = sc.next(); 
        
        long total = (N*(N+1))/2; 
        long unsuccessful = 0; 
        
        ArrayList<String> arr = new ArrayList<>(); 
        int start = 0; 
        
        for(int i=1; i<N; i++){
            
            
            if(str.charAt(i-1) == str.charAt(i)){
                
                String tmp = str.substring(start, i);
                arr.add(tmp);
                start = i; 
                
            }
            
            if(i == N-1){
                String tmp = str.substring(start, N);
                arr.add(tmp);
            }
            
            
        }
        
        
        for(int i=0; i<arr.size(); i++){
            long len = arr.get(i).length();
            
            long cnt = (len*(len+1))/2; 
            
            
            unsuccessful += cnt;
        }
        
        System.out.println(total-unsuccessful); 
        
        
        
        
        
        
        
        
      
      
      
      
      
    }
}
