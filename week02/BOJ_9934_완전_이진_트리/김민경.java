package week02.BOJ_9934_완전_이진_트리;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void inorder(int[] inputArr, ArrayList<Integer>[] outputArr, int start, int end, int level) {   
        if(start > end) 
            return;
        int mid = (start + end) / 2;

        outputArr[level].add(inputArr[mid]);
        inorder(inputArr, outputArr, start, mid - 1, level + 1);
        inorder(inputArr, outputArr, mid + 1, end, level + 1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int level = (int) (Math.pow(2, K) - 1);
        int[] inputArr = new int[level];

        ArrayList<Integer>[] outputArr = new ArrayList[K];

        for(int i = 0; i < K; i++) {
            outputArr[i] = new ArrayList<Integer>();
        }
    
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int index = 0;
        while(st.hasMoreTokens()) {
            inputArr[index++] = Integer.parseInt(st.nextToken());
        }

        inorder(inputArr, outputArr, 0, inputArr.length - 1, 0);

        for(int i = 0; i < K; i++) {
            for(int j = 0; j < outputArr[i].size(); j++) {
                System.out.print(outputArr[i].get(j) + " ");
            }
            System.out.println();
        }
    }

}
