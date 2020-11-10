package com.wc.util.ik;

import com.google.common.collect.Maps;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.StringReader;
import java.util.*;

/**
 * 分词工具
 */
public class IKSUtil {
    public static List<String> getStringList(String text) throws Exception {
        //独立Lucene实现
        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex;
        List<String> s = new ArrayList<>();
        while ((lex = ik.next()) != null) {
            s.add(lex.getLexemeText());
        }
        return s;

    }

    /**
     * 数据分词统计
     *
     * @param strings
     * @return
     * @throws Exception
     */
    public static String ikCommit(List<String> strings) throws Exception {
        List<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            strings1.addAll(getStringList(string));
        }
        Set<String> uniqueSet = new HashSet(strings1);
        Map<String, Integer> map = new HashMap();
        for (String temp : uniqueSet) {
            map.put(temp, Collections.frequency(strings1, temp));
        }
        //剔除分词后单个字的
        map.keySet().removeIf(key -> key.length() == 1);
        //根据value降序并取前10条
        Map<String, Integer> stringIntegerMap = sortByValue(map, true, 10);
        return stringIntegerMap.toString();
    }


    /**
     * Sort map by value
     *
     * @param map    map source
     * @param isDesc 是否降序，true：降序，false：升序
     * @param limit  取前几条
     * @return 已排序map
     */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isDesc, int limit) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed()).limit(limit)
                    .forEach(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }

    /**
     * Sort map by key
     *
     * @param map    待排序的map
     * @param isDesc 是否降序，true：降序，false：升序
     * @param limit  取前几条
     * @return 已排序map
     */
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map, boolean isDesc, int limit) {
        Map<K, V> result = Maps.newLinkedHashMap();
        if (isDesc) {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed()).limit(limit)
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        } else {
            map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
                    .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        }
        return result;
    }
}
