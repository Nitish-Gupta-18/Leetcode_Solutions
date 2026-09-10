// Intuition is that , from each position , you can only move in limited number of indices
// 0 at index 0 can move to {1,3}
// 0 at index 1 can move to {0,2,4}
// 0 at index 2 can move to {1,5}
// 0 at index 3 can move to {0,4}
// 0 at index 4 can move to {1,3,5}
// 0 at index 5 can move to {2,4}

class Data{
    String s;
    int m;
    int zInd;
    Data(String s,int m,int zInd){
        this.s = s;
        this.m = m;
        this.zInd = zInd;
    }
}

class Solution {
    
    public int slidingPuzzle(int[][] board) {

        StringBuilder sb = new StringBuilder("");    
        Set<String> visited = new HashSet<>();
        int zInd = 0;
        int nxtDir[][] = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        for(int r=0;r<2;r++){
            for(int c=0;c<3;c++){
                sb.append(board[r][c]);
                if(board[r][c] == 0)
                    zInd = r * 3 + c;
            }
        }

        Queue<Data> heap = new PriorityQueue<>((a,b)->a.m - b.m);
        heap.offer(new Data(sb.toString(),0,zInd));

        while(!heap.isEmpty()){

            Data d = heap.poll();

            if(d.s.equals("123450"))
                return d.m;

            for(int i=0;i<nxtDir[d.zInd].length;i++){
                sb = new StringBuilder(d.s);
                swap(sb,d.zInd,nxtDir[d.zInd][i]);
                String s = sb.toString();
                if(!visited.contains(s)){
                    heap.offer(new Data(s,d.m+1,nxtDir[d.zInd][i]));
                    visited.add(s);
                }
            }
        }

        return -1;
    }

    private void swap(StringBuilder s,int i,int j){
        char c = s.charAt(i);
        s.setCharAt(i,s.charAt(j));
        s.setCharAt(j,c);
    }
}