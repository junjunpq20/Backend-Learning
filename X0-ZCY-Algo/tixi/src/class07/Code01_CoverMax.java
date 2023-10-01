package class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_CoverMax {

  public static int maxCover1(int[][] lines) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < lines.length; i++) {
      min = Math.min(min, lines[i][0]);
      max = Math.max(max, lines[i][1]);
    }
    int cover = 0;
    for (double p = min + 0.5; p < max; p += 1) {
      int cur = 0;
      for (int i = 0; i < lines.length; i++) {
        if (lines[i][0] < p && lines[i][1] > p) {
          cur++;
        }
      }
      cover = Math.max(cover, cur);
    }
    return cover;
  }

  public static int maxCover2(int[][] segments) {
    // 首先将原线段数组按 start 排序
    Arrays.sort(segments, Comparator.comparingInt(a -> a[0]));

    // 然后准备一个小根堆，存放线段的 end
    PriorityQueue<Integer> minEndHeap = new PriorityQueue<>();

    int max = 0;

    // 遍历排好序的线段数组
    for (int[] segment : segments) {
      int start = segment[0], end = segment[1];

      // 将 minEndHeap 里小于等于 start 的元素全部弹出
      // minEndHeap 里的元素 (之前线段的 end 值) 小于等于当前线段的 start 代表着这两个线段不可能重合
      while (!minEndHeap.isEmpty() && minEndHeap.peek() <= start) {
        minEndHeap.remove();
      }

      // 然后插入当前的 end
      minEndHeap.add(end);

      // 此时 minEndHeap 的 size 就是当前线段与多少其它线段重合了（一个线段可以与自己重合，所以 size >= 1）
      max = Math.max(max, minEndHeap.size());
    }

    return max;
  }

  // for test
  public static int[][] generateLines(int N, int L, int R) {
    int size = (int) (Math.random() * N) + 1;
    int[][] ans = new int[size][2];
    for (int i = 0; i < size; i++) {
      int a = L + (int) (Math.random() * (R - L + 1));
      int b = L + (int) (Math.random() * (R - L + 1));
      if (a == b) {
        b = a + 1;
      }
      ans[i][0] = Math.min(a, b);
      ans[i][1] = Math.max(a, b);
    }
    return ans;
  }

  public static void main(String[] args) {

    Line l1 = new Line(4, 9);
    Line l2 = new Line(1, 4);
    Line l3 = new Line(7, 15);
    Line l4 = new Line(2, 4);
    Line l5 = new Line(4, 6);
    Line l6 = new Line(3, 7);

    // 底层堆结构，heap
    PriorityQueue<Line> heap = new PriorityQueue<>(new StartComparator());
    heap.add(l1);
    heap.add(l2);
    heap.add(l3);
    heap.add(l4);
    heap.add(l5);
    heap.add(l6);

    while (!heap.isEmpty()) {
      Line cur = heap.poll();
      System.out.println(cur.start + "," + cur.end);
    }

    System.out.println("test begin");
    int N = 100;
    int L = 0;
    int R = 200;
    int testTimes = 200000;
    for (int i = 0; i < testTimes; i++) {
      int[][] lines = generateLines(N, L, R);
      int ans1 = maxCover1(lines);
      int ans2 = maxCover2(lines);
      //      int ans3 = maxCover3(lines);
      if (ans1 != ans2) {
        System.out.println("Oops!");
      }
    }
    System.out.println("test end");
  }

  public static class Line {
    public int start;
    public int end;

    public Line(int s, int e) {
      start = s;
      end = e;
    }
  }

  public static class StartComparator implements Comparator<Line> {

    @Override
    public int compare(Line o1, Line o2) {
      return o1.start - o2.start;
    }
  }
}
