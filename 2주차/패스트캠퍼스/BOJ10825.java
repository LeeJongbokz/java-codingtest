// 제목: 국영수  

// 1sol

// 왜 맞았는가?
// 1) 객체들을 비교할때는, Comparable 인터페이스를 구현해서 사용할 수 있습니다.
// 2) compareTo 메소드를 구현할 때는, this 객체가 앞에 있을 때는, 작은 순으로 정렬되고, 반대인 경우에는 큰 순으로 정렬됩니다.
// 3) 케이스를 if(==)와 아닌 것으로 나눌 수 있습니다. 
// 4) 생성자에 값을 넣을 때, 순서를 잘 지키는 것이 중요합니다. 

import java.util.*; 

class Student implements Comparable<Student>{
    
    String name; 
    int korean;
    int math;
    int english;
    
    
    public Student(String name, int korean, int english, int math){
        this.name = name; 
        this.korean = korean;
        this.english = english; 
        this.math = math;
    }
    
    @Override
    public int compareTo(Student t){
        
        if(this.korean == t.korean){
            
            if(this.english == t.english){
                
                if(this.math == t.math){
                    return this.name.compareTo(t.name);
                }else{
                    return t.math-this.math; 
                }
                
                
            }else{
                return this.english-t.english;
            }
            
        }else{
            return t.korean-this.korean; 
        }
    
        
    }
    
    
}


public class Main {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      
      ArrayList<Student> students = new ArrayList<>(); 
      
      for(int i=0; i<N; i++){
          
          String name = sc.next();
          int korean = sc.nextInt();
          int english = sc.nextInt();
          int math = sc.nextInt(); 
          
          Student t = new Student(name, korean, english, math);
          students.add(t); 
      }
      
      Collections.sort(students);
      
      
      for(int i=0; i<N; i++){
          System.out.println(students.get(i).name);
      }
      
      
      
    }
}
