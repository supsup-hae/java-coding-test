import java.util.*;
class Solution {

    static boolean[] painted; 
    
    public int solution(int n, int m, int[] section) {
        painted = new boolean[n + 1];
        List<Integer> list = new ArrayList<>();
        for(int value : section) {
            list.add(value);
        }
    
        for(int i = 0; i <= n; i++) {
            if(!list.contains(i)) {
                painted[i] = true;
            }
        }
        int answer = 0;
        if(m == 1) {
            answer = section.length;
        } else{
            answer = processing(n, m, section);
        }
        return answer;
    }
    
    
     private static int processing(int wall, int roller, int[] section) {
         int count = 0; 
         for(int i = 0; i < section.length; i++) {
             int wallNumber = section[i];
             if(!painted[wallNumber] && wallNumber >= wall - roller) { // 
                 paintWall(wall - roller, roller + 1);
                 count++;
             } else if(!painted[wallNumber]) {
                paintWall(wallNumber, roller);
                count++; 
             } 
         }
         return count;
     }
    
    private static void paintWall(int wallNumber, int roller) {
        for(int i = 0; i < roller; i++) {
            painted[i + wallNumber] = true;
        }
    }
    
    private static void printResult() {
        for(int i = 0; i < painted.length; i++) {
            System.out.println(i + "|" + painted[i]);
        }
    }
}

// 1미터씩구역 n개 -> 번호를 붙힌다.
//룰러의 길이는 m -> 벽을 벗어나면 안되며, 구역의 일부분만포함되도록 하면 안된다.
// 한구역 여러번 칠해도 O, 아닌곳에 칠해도 O , 다시 칠하기로 결정한 구역은 최소 1번칠하기