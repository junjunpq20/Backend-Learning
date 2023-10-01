package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code01_CoverMax_Judge {

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
    // TODO
    return -1;
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
