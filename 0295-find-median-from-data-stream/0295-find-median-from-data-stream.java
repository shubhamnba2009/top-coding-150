class MedianFinder {
    Queue<Integer> lo;
    Queue<Integer> hi;
    public MedianFinder() {
        lo = new PriorityQueue<>((a,b)-> Integer.compare(b, a));
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if(lo.size()<hi.size()){
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        return lo.size()==hi.size()?(double)(lo.peek()+hi.peek())/2:lo.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */