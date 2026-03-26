// 295. Find Median from Data Stream

/* 

why PriorityQueue ? - the input is streaming and unordered , sorting every time is inefficient

lets use 2 priority queue 
1.left - maxheap : stores smaller half and top is largest of smaller half
2. right - minheap : stores larger half and top is smallest of larger half

maintain size difference of 2 heap <= 1
why? - if the size difference is 1 , then the median is top of left (maxHeap)
if size difference is 0 , then mean of top of 2 heaps
thereby finding median every time is easy

insertion: 
1. insert to left
2. shift top to right
3. if right size > left size , move right top to left
why ? - here not just the size , order matters too !
 eg : 10, 1, 5, 2


 */
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();

    }

    public void addNum(int x) {

        left.offer(x);                       //step 1 : insert to left
        right.offer(left.poll());            //step2 : shift to right 
        if (right.size() > left.size()) {      //step 3 : if right > left , shift back
            left.offer(right.poll());
        }
    }

    public void display() {
        for (int x : left) {
            System.out.println(x);
        }
    }

    public double findMedian() {
        double ans;
        if (left.size() > right.size()) {

            ans = left.peek();

        } else {
            ans = (left.peek() + right.peek()) / 2.0;

        }
        return ans;
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(3);
        System.out.println("Median is " + obj.findMedian());
        obj.addNum(2);
        System.out.println("Median is " + obj.findMedian());
        obj.addNum(5);
        System.out.println("Median is " + obj.findMedian());

    }
}
