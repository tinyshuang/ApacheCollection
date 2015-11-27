package test;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * @author Administrator
 * @description
 *2015-5-13  下午7:00:02
 */
public class BagUtil {
    public static void main(String[] args) {
	bag();
    }
    
    /**
     * @description 支持复制的集合	
     *2015-5-13  下午7:02:57
     *返回类型:void
     */
    public static void bag(){
	Bag<String> bag = new HashBag<String>();
	bag.add("one",5);
	bag.remove("one", 2);
	System.out.println(bag.getCount("one"));
    }
}
