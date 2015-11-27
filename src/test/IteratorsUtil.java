package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/**
 * @author Administrator
 * @description
 *2015-5-12  下午12:27:22
 */
public class IteratorsUtil {
    public static void main(String[] args) {
	loopIterators();
    }
    
    
    /**
     * @description 循环迭代..
     *2015-5-12  下午12:40:17
     *返回类型:void
     */
    public static void loopIterators(){
	String[] arrays={"a","b","c"};
	List<String> list = Arrays.asList(arrays);
	LoopingIterator<String> li = new LoopingIterator<String>(list);
	for (int i = 0; i < 5; i++) {
	    System.out.println(li.next());
	}
	
    }
    
    
    /**
     * @description 截取数组一部分的迭代器	 
     *2015-5-12  下午12:29:22
     *返回类型:void
     */
    public static void subIterators(){
	String[] arrays=new String[]{"a","b","c","d","f"};
        //遍历下标为1到4的元素
        Iterator<String> iterator=new ArrayListIterator<String>(arrays,1,4);
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"; ");
        }
    }
    
    /**
     * @description 筛选的迭代器	
     *2015-5-12  下午12:45:03
     *返回类型:void
     */
    public static void filterIterators(){
	List<Integer> list=new ArrayList<Integer>(Arrays.asList(new Integer[]{7,9,35,67,88}));
	//过滤出大于30的元素
        Predicate<Integer> predicate=new Predicate<Integer>(){           
            public boolean evaluate(Integer value){
                int num=value.intValue();
                return num>30;
            }
        };
        Iterator<Integer> iterator=new FilterIterator<Integer>(list.iterator(),predicate);
        while(iterator.hasNext()){
            System.out.print(iterator.next()+"; ");
        }
    }
    
    
    /**
     * @description 过滤重复元素的迭代器	
     *2015-5-12  下午2:26:42
     *返回类型:void
     */
    public static void uniqueIterators(){
	String[] arrays=new String[]{"a","b","c","a","c"};
	List<String> list = Arrays.asList(arrays);
	//去除重复元素最简单的方式就是直接放进set里面
	Set<String> set = new HashSet<String>(list);
	System.out.println(set);
	Iterator<String> iterator = new UniqueFilterIterator<String>(list.iterator());
	while(iterator.hasNext()){
	    System.out.println(iterator.next());
	}
    }
    
}
