package com.teiphu;

import org.junit.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        /*String pointTypesParam = "1,2,3,9";
        if (pointTypesParam != null && pointTypesParam.length() > 0) {
            String[] pointTypeArr = pointTypesParam.trim().split(",");
            if (pointTypeArr.length > 0) {
                Set<Integer> pointTypes = Arrays.stream(pointTypeArr)
                        .map(s -> Integer.valueOf(s.trim())).collect(Collectors.toSet());
                System.out.println(pointTypes.contains(1));
                System.out.println(pointTypes.contains(4));
            }
        }*/

        String uuid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uuid.length() && sb.length() < 8; i++) {
            char ch = uuid.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }
        String s = sb.toString();
        System.out.println(s);
    }

    @Test
    public void test1() {
        boolean b = true;
        boolean c = false;
        if (b ^ c) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    @Test
    public void bboxToGeo0() {
        String bbox = "ReferencedEnvelope[113.35556030273439 : 113.39401245117189, 23.303375244140625 : 23.341827392578125]";
        String subBBox = bbox.substring(bbox.indexOf("[") + 1, bbox.lastIndexOf("]"));
        subBBox = subBBox.replace(':', ',');
        subBBox = subBBox.replace(" ", "");
        String[] bboxArray = subBBox.split(",");
        String t = bboxArray[1];
        bboxArray[1] = bboxArray[2];
        bboxArray[2] = t;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[1]);

        sb.append("],[");
        sb.append(bboxArray[2]);
        sb.append(",");
        sb.append(bboxArray[1]);

        sb.append("],[");
        sb.append(bboxArray[2]);
        sb.append(",");
        sb.append(bboxArray[3]);

        sb.append("],[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[3]);

        sb.append("],[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[1]);
        sb.append("]");
        System.out.println(sb);
    }


    @Test
    public void bboxToGeo() {
        String bbox;
        bbox = "113.75254601240158,23.54301653802395,113.75268146395683,23.5431519895792";
        String[] bboxArray = bbox.split(",");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[1]);

        sb.append("],[");
        sb.append(bboxArray[2]);
        sb.append(",");
        sb.append(bboxArray[1]);

        sb.append("],[");
        sb.append(bboxArray[2]);
        sb.append(",");
        sb.append(bboxArray[3]);

        sb.append("],[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[3]);

        sb.append("],[");
        sb.append(bboxArray[0]);
        sb.append(",");
        sb.append(bboxArray[1]);
        sb.append("]");
        System.out.println(sb);

    }

    @Test
    public void testCode() throws UnsupportedEncodingException {
        /*String s = "A地图平台测试部署";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(bytes);*/

        File[] files = File.listRoots();
        for (int i = 0; i < files.length; i++) {

        }
        System.out.println(files);

        /*File file = new File("D:\\");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }*/
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("->zhenglifu");
        list.add("->qiuju");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            s = s.substring(2);
        }
        System.out.println(list);
    }
}
