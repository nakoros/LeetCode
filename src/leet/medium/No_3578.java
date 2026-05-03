package leet.medium;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No_3578 {
    public static void main(String[] args) {
        No_3578 main = new No_3578();
        System.out.println(main.countPartitions2(new int[]{9,4,1,3,7}, 4));
        System.out.println(main.countPartitions2(new int[]{3,3,4}, 0));
        System.out.println(main.countPartitions2(new int[]{910560734,510575920,896549371,494067039,469723815,754469834,967022166,503878429,55583908,961034258,65652363,830803605,895825019,914597296,699146738,841526053,535692317,229433289,599036118,167589015,159283360,920427706,305060297,72233085,736640642,774759484,533579082,532730152,242943275,192115790,78598722,816853818,158576548,667988859,80422662,121078442,826872277,741048480,932017216,681319679,338711750,688632861,163690035,675084341,584296510,141045338,338277679,329043572,253863918,486914970,802620406,431415710,246951255,299137094,241729361,70232788,171750163,550757212,310841839,824974985,307401708,618218931,721660005,695174479,531682683,857396415,833062448,829825127,703653317,694085693,176868493,126366306,534071482,714329401,80812477,897906848,791963101,185974805,871801946,161464006,217244520,836179166,579109693,227757082,970580317,91244564,58717404,186560799,330267367,514556207,699396691,497877613,653163818,562076003,241400752,887295788,904685240,150535386,511985596,37241934,196479931,344249299,382520386,647628389,743803899,473051373,814144398,808430098,723206606,561861319,476181094,258630317,733367284,746257225,254879312,617127792,379097667,950119301,514984681,253189292,396951879,497067254,253275787,559748607,851366329,835597150,204451754,104831237,722476440,213825522,104678847,682988470,483939459,666056708,908573170,872457627,668703507,9382042,294006645,108415069,420504497,672024261,590678594,976560676,575171842,192016288,928265226,130835209,66548380,165341273,123477831,768491934,895371270,541057348,568452461,596787616,210537161,974268565,908302806,551852893,198828961,578481431,240001876,144878220,829733953,512045532,520741764,778674508,573908935,241970512,137023346,540545826,133827013,864609278,867808147,552323444,952832369,122508334,703771210,436807191,919842264,805523703,512540705,318125706,284709591,577583573,255153106,505120805,819427231,196767842,909582547,338107380,115927760,632166376,664633827,366542,358543814,477291997,967619135,202500053,672155040,177810295,255234500,445990948,940167405,168523044,417538042,325864559,910660425,75724726,241481382,915217456,687591383,55454047,362567639,880952723,629110346,374180428,580021789,477373636,35478790,52883305,345076164,38326842,448658718,7508667,342816636,920051344,681626784,849869575,396931274,999862508,247092076,7494147,198278948,132871958,518033607,580518818,112974415,70325463,787807635,247390836,87096278,429555475}, 71928030));
        //79214383

        int[] nums = new int[50000];
        try(BufferedReader br=new BufferedReader(new FileReader("src/leet/medium/3578.txt"))){
            char[] cbuf=new char[1];
            int idx=0;
            StringBuilder sb=new StringBuilder();
            while(br.read(cbuf)!=-1){
                if(cbuf[0]==','){
                    int num = Integer.parseInt(sb.toString());
                    nums[idx++]=num;
                    sb.setLength(0);
                }else{
                    sb.append(cbuf[0]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println(main.countPartitions2(nums, 20000000));
//
//        System.out.println(main.callCount);
    }
    public int countPartitions2(int[] nums, int k) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] dp = new int[n + 2];
        int[] preSum = new int[n + 2];

        dp[n - 1] = 1;
        preSum[n - 1] = 1;

        // 단조 덱: min/max를 O(1)로 유지
        Deque<Integer> maxDq = new ArrayDeque<>(); // 내림차순
        Deque<Integer> minDq = new ArrayDeque<>(); // 오름차순
        maxDq.addLast(n - 1);
        minDq.addLast(n - 1);

        int right = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            // i를 덱에 추가 (윈도우 왼쪽 확장)
            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] <= nums[i]) maxDq.pollLast();
            while (!minDq.isEmpty() && nums[minDq.peekLast()] >= nums[i]) minDq.pollLast();
            maxDq.addLast(i);
            minDq.addLast(i);

            // right를 왼쪽으로 당기기: 조건 위반 시 축소
            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > k) {
                right--;
                if (maxDq.peekFirst() > right) maxDq.pollFirst();
                if (minDq.peekFirst() > right) minDq.pollFirst();
            }

            // [i, right] 구간이 유효한 파티션 시작점
            if (right == n - 1) dp[i]++;  // 끝까지 파티션 가능

            dp[i] = (dp[i] + preSum[i + 1] - preSum[right + 2] + MOD) % MOD;
            preSum[i] = (dp[i] + preSum[i + 1]) % MOD;
        }

        return dp[0];
    }
    public int countPartitions(int[] nums, int k) {
        int[] dp = new int[nums.length+1];
        int[] preSum = new int[nums.length+1];
        dp[nums.length-1]=1;
        preSum[nums.length-1]=1;

        for (int i = nums.length-2; i >=0; i--) {
            int right=i;
            int min=nums[i];
            int max=nums[i];
            while(true){
                if(right+1==nums.length){
                    dp[i]++;
                    break;
                }
                if(min>nums[right+1]){
                    min = nums[right+1];
                }
                if(max<nums[right+1]){
                    max = nums[right+1];
                }
                if(max-min<=k){
                    right++;
                }else{
                    break;
                }
            }

                for (int j = i ; j <= right; j++) {
                    dp[i] += dp[j+1];
                    dp[i] %= 1000000007;
                }
                preSum[i] = dp[i]+preSum[i+1];
        }

        return dp[0];
    }

    public int countPartitionsRecursive(int[] nums, int k, int idx,int[] dp) {
        int count=0;
        if(idx==nums.length){
            return 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int min = nums[idx];
        int max = nums[idx];
        for (int i = idx; i < nums.length; i++) {
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
            if(max-min<=k){
                count+=countPartitionsRecursive(nums,k,i+1,dp);
                count%=1000000007;
            }else{
                break;
            }
        }

        dp[idx]=count%(1000000007);
        return count;
    }

}
