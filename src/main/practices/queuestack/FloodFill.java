package main.practices.queuestack;

import java.util.LinkedList;

/**
 * @Description:
 * 
 *               An image is represented by a 2-D array of integers, each
 *               integer representing the pixel value of the image (from 0
 *               to 65535).
 *
 *               Given a coordinate (sr, sc) representing the starting
 *               pixel (row and column) of the flood fill, and a pixel
 *               value newColor, "flood fill" the image.
 *
 *               To perform a "flood fill", consider the starting pixel,
 *               plus any pixels connected 4-directionally to the starting
 *               pixel of the same color as the starting pixel, plus any
 *               pixels connected 4-directionally to those pixels (also
 *               with the same color as the starting pixel), and so on.
 *               Replace the color of all of the aforementioned pixels with
 *               the newColor.
 *
 *               At the end, return the modified image.
 *
 *               Example 1:
 *               Input:
 *               image = [[1,1,1],[1,1,0],[1,0,1]]
 *               sr = 1, sc = 1, newColor = 2
 *               Output: [[2,2,2],[2,2,0],[2,0,1]]
 *               Explanation:
 *               From the center of the image (with position (sr, sc) = (1,
 *               1)), all pixels connected
 *               by a path of the same color as the starting pixel are
 *               colored with the new color.
 *               Note the bottom corner is not colored 2, because it is not
 *               4-directionally connected
 *               to the starting pixel.
 *               Note:
 *
 *               The length of image and image[0] will be in the range [1,
 *               50].
 *               The given starting pixel will satisfy 0 <= sr <
 *               image.length and 0 <= sc < image[0].length.
 *               The value of each color in image[i][j] and newColor will
 *               be an integer in [0, 65535].
 * 
 * 
 *               思路:
 *               一开始用mark方法，深度优先遍历，利用系统栈递归调用mark方法染色，但是最后会造成StackOverflowError，原因栈太深了
 *               之后改成用一个显式的栈递归调用
 * @Author: shenpeng
 * @Date: 2020-02-01
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int l1 = image.length;
        int l2 = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        LinkedList<Integer> toBeMarkedPoses = new LinkedList<>();
        // int mark = 65536;
        image[sr][sc] = newColor;
        toBeMarkedPoses.push(sr * 100 + sc);
        while (!toBeMarkedPoses.isEmpty()) {
            int pos = toBeMarkedPoses.poll();
            int x = pos / 100;
            int y = pos % 100;
            //            System.out.println(pos + "  " + x + y);
            //   image[x][y] = newColor;
            if (x > 0 && image[x - 1][y] == oldColor) {
                image[x - 1][y] = newColor;
                toBeMarkedPoses.push((x - 1) * 100 + y);
            }
            if (y > 0 && image[x][y - 1] == oldColor) {
                image[x][y - 1] = newColor;
                toBeMarkedPoses.push(x * 100 + (y - 1));
            }
            if (x < (l1 - 1) && image[x + 1][y] == oldColor) {
                image[x + 1][y] = newColor;
                toBeMarkedPoses.push((x + 1) * 100 + y);
            }
            if (y < (l2 - 1) && image[x][y + 1] == oldColor) {
                image[x][y + 1] = newColor;
                toBeMarkedPoses.push(x * 100 + (y + 1));
            }
        }
        //mark(image, sr, sc);

        //        for (int i = 0; i < l1; i++) {
        //            for (int j = 0; j < l2; j++) {
        //                if (image[i][j] == mark) {
        //                    image[i][j] = newColor;
        //                }
        //            }
        //        }
        return image;
    }

    //    public static void main(String[] args) {
    //        int[][] a = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    //        floodFill(a, 1, 1, 2);
    //    }

    //    private void mark(int[][] image, int sr, int sc) {

    //            image[sr][sc] = mark;
    //            if (sc > 0 && image[sr][sc - 1] == oldColor) {
    //                mark(image, sr, sc - 1);
    //            }
    //            if (sc < (l1 - 1) && image[sr][sc + 1] == oldColor) {
    //                mark(image, sr, sc + 1);
    //            }
    //            if (sr > 0 && image[sr - 1][sc] == oldColor) {
    //                mark(image, sr - 1, sc);
    //            }
    //            if (sr < (l2 - 1) && image[sr + 1][sc] == oldColor) {
    //                mark(image, sr + 1, sc);
    //            }
    //        
    //    }
}
