package com.teiphu;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Zheng Lifu
 */
public class DealBookmark {

    public static void main(String[] args) throws IOException {
        String path = "E:\\Bookmark\\OneTab-0717.txt";
        File file = new File(path);
        String content = FileUtils.readFileToString(file, "UTF-8");
        String[] urlArr = content.split("\r\n");
        Set<String> urls = Arrays.stream(urlArr).filter(url -> !url.startsWith("http://172.28.50.131:8088/geoserver")).sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        File file1 = new File("E:\\Bookmark\\OneTab-0717-01.txt");
        FileUtils.writeLines(file1, urls);
//        System.out.println(urls.size());
    }
}
