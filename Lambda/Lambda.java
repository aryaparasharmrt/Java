/*
 * 
 * __________________  DwellSMART CONFIDENTIAL __________________
 * 
 * (C) DwellSMART Pvt. Ltd. [2015] - All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of DwellSMART Pvt. Ltd. 
 * and its partners, if any. The intellectual and technical concepts contained herein are 
 * proprietary to DwellSMART Pvt. Ltd. and its suppliers and may be covered by Patents,
 * patents in process, and are protected by trade secret or copyright law. 
 * Dissemination of this information or reproduction of this material is strictly forbidden 
 * unless prior written permission is obtained from DwellSMART Pvt. Ltd.
 * October 2015
 */
package com.dwellsmart.commonUtils;

/**
 *
 * @author aryap
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//class SortMethod implements Comparator<Integer> {
            
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2) {
//                    return -1;
//                } else if (o1 > o2) {
//                    return +1;
//                } else {
////                    return 0;
////                }
////            }
//            
////            (o1, o2) ->(o1 < o2) ? -1 : (o1 > o2) ? 1 : 0
//}

public class Lambda {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(14);
        l.add(1);
        l.add(5);
        l.add(90);
        l.add(70);
        System.out.println("Before sorting List: "+l.toString());
        Comparator<Integer> c = (o1, o2) ->(o1 < o2) ? -1 : (o1 > o2) ? 1 : 0;
        Collections.sort(l, c);
        System.out.println("After sorting List: "+l.toString());
        l.stream().forEach(System.out::println);
    }
}
