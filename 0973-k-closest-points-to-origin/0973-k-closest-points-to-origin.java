class Solution {
    static class Point implements Comparable<Point>{
        int x,y;
        int disSq;
        int idx;
        public Point(int x, int y, int disSq,int idx){
            this.x = x;
            this.y = y;
            this.disSq = disSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.disSq - p2.disSq;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int result[][] = new int[k][points[0].length];
        PriorityQueue<Point>pq = new PriorityQueue<>();
        for(int i=0;i<points.length;i++){
            int disSq = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new Point(points[i][0],points[i][1],disSq,i));
        }

        for(int i=0;i<k;i++){
            int x = pq.peek().x;
            int y = pq.peek().y;
            result[i][0] = x;
            result[i][1] = y;

            pq.remove();
        }

        return result;
    }
}