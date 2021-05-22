import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long fast = 1;
        long slow = (long) times[times.length-1] * n;

        while(fast <= slow) {
            long mid = (fast + slow) /2;
            long sum = 0;
            for(int i=0;i<times.length;i++){
                sum += mid / times[i]; //평균시간을 mid라 했을때 각 심사원 별로 평균시간당 몇명 볼 수 있는지를 더함
            }
            if(sum<n){
                fast = mid + 1; //못함 -> 시간 더 필요해!! 근데 딱 중간 값일떄 실패한거니까 이제 최소가 중간 이후일때 보면 됨
            } else { //시간 너무 많아!! 그럼 중간값보다 작을때 보면 됨
                slow = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}

