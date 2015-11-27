package test;

import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.apache.commons.collections4.map.LRUMap;
import org.apache.commons.collections4.map.LinkedMap;
import org.apache.commons.collections4.map.MultiValueMap;

/**
 * @author Administrator
 * @description
 *2015-5-12  下午2:33:26
 */
public class MapUtil {
    public static void main(String[] args) {
	
    }
    
    
    /**
     * @description 使用MultiValueMap一键存储多值的map 	
     *2015-5-12  下午2:36:17
     *返回类型:void
     */
    public static void multi(){
	MultiMap<String, String> map = new MultiValueMap<String, String>();
	map.put("key", "one");
	map.put("key", "two");
	map.put("key", "three");
	System.out.println(map.get("key"));
    } 
    
    /**
     * @description 使用DualHashBidiMap构建双向的map来实现通过值找到键	
     *2015-5-12  下午2:41:10
     *返回类型:void
     */
    public static void duplex(){
	BidiMap<String, String> map = new DualHashBidiMap<String, String>();
	map.put("first", "one");
	System.out.println("根据键来寻找值 : " + map.get("first"));
	System.out.println("使用map.inverseBidiMap()来用值来寻找键 : " + map.inverseBidiMap().get("one"));
    }
    
    
    /**
     * @description 使用CaseInsensitiveMap构造一个key值忽略大小写的Map 	
     *2015-5-12  下午2:50:04
     *返回类型:void
     */
    public static void caseIngnore(){
	CaseInsensitiveMap<String, String>  map = new CaseInsensitiveMap<String, String>();
	map.put("key", "value");
	map.put("KEY", "value2");
	System.out.println(map.get("key"));
    }
    
    /**
     * @description 最近最少使用的map	
     *2015-5-13  上午11:32:13
     *返回类型:void
     */
    public static void lru(){
   	LRUMap<String, String> map = new LRUMap<String, String>(3);
   	map.put("first", "1");
   	map.put("second", "2");
   	//如果这里调用了"first",那么结果就是1,3,4
   	//如果没调用"first",那么结果就是2,3,4
   	System.out.println(map.get("first"));
   	map.put("third", "3");
   	map.put("fourth", "4");
   	for(Iterator<Entry<String, String>> it = map.entrySet().iterator();it.hasNext();){
   	     System.out.println(it.next());       
   	}
    }
    
    /**
     * @description 键是顺序的Map..
     * 可以使用firstKey()和nextKey(key)的map	
     *2015-5-13  上午11:34:29
     *返回类型:void
     */
    public static void order(){
	OrderedMap<String, String> map = new LinkedMap<String, String>();
	map.put("first", "1");
	map.put("second", "2");
	map.put("third", "3");
	System.out.println("输出map的第一个键 : " + map.firstKey());
	System.out.println("输出first键的下一个键 : " + map.nextKey("first"));
	System.out.println("输出second键的下一个键  : " + map.nextKey("second"));
    }
    
    
}
