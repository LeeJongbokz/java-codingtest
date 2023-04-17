// 기존에 제가 풀이를 한 것에서 시간 초과가 떠서,
// 강의의 풀이를 참고해서 정리했습니다. 

// 제가 했던 풀이는 2차원 배열을 써서, 지정한 점을 고른 후, 그 점을 check 처리하고, 
// 다시 고르는 식으로 했습니다.
// 이러한 접근 방식의 단점은, 이중 for문을 써야 한다는 점과, check 처리를 그때그때 해야 한다는 점입니다.

// 반면 강의의 풀이는, row를 기준으로 한 행씩 재귀적으로 탐색하면서, 칼럼을 하나씩 선택하는 식으로 구성되어 있습니다.
// 이렇게 하면 장점은 1) 1차원 for문으로 처리할 수 있음 2)따로 check 배열 없이, attackable만 검사하면 됨
// 입니다. 

// 이 때, 중요한 포인트는 2가지입니다.
// 첫째는, attackable이라는 메소드를 구현하는 것입니다. 어떤 조건에서 attackable한지 이해해야 합니다.
// 행은 무조건 다른데, 열이 같은 경우, 그리고 대각선인 경우가 어떻게 attackable한지 이해해야 합니다. 

// 둘째는, 각 재귀 단계에서 attackable을 적용하는 것을 이해하는 것입니다.
// 각 재귀 단계에서 attackable을 적용해야 하는 이유는 그렇게 함으로써, 아닌 케이스는 탐색하지 않음으로써,
// 시간 복잡도를 낮출 수 있기 때문입니다. 

// 내가 현재 row에서 선택하려는 columne이 이전 단계에서 선택했던 점들과 충돌하는지 확인하고,
// 만약에 충돌한다면, 더 이상 탐색을 할 필요가 없고, 그렇지 않다면, 탐색을 계속해서 진행해줍니다.  




import java.util.*; 

public class Main {
    
    
    public static int[] col;
    public static int ans; 
    public static int N; 
    
    
    
    public static boolean attackable(int r1, int c1, int r2, int c2){
        
        if(c1 == c2) return true;
        if(r1+c1 == r2+c2) return true;
        if(r1-c1 == r2-c2) return true;
        
        return false; 
        
    }
    
    
    
    public static boolean validity_check(){
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(attackable(i, col[i], j, col[j])){
                    return false;
                }
            }
        }
        
        return true; 
        
    }
    
    
    
    public static void recursive(int row){
        
        if(row == N+1){
            ans++;
            return; 
        }
        
        for(int c=1; c<=N; c++){
            
            boolean possible = true; 
            
            for(int i=1; i<=row-1; i++){
                if(attackable(row, c, i, col[i])){
                    possible = false;
                    break;
                }
                
            }
            
            if(possible){
                col[row] = c;
                recursive(row+1);
                col[row] = 0;
            }
            
        }
        
        
        
        
        
    }
    
    
    
    
    public static void main(String args[]) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in); 
        
        col = new int[20];
        ans = 0;
        N = sc.nextInt();
        
        
        recursive(1);
        
        
        System.out.println(ans); 
        
    }
}
