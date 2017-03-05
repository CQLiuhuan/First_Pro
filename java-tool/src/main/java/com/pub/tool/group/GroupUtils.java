package com.pub.tool.group;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multiset;


public class GroupUtils
{
    /**
     * 
     * 避免创建对象
     *
     * @throws Exception
     */
    private GroupUtils() throws Exception
    {
        throw new Exception("GroupUtils can’t new instance !");
    }
    
    /**
     * 
       
     * groupByAttrDeepByObject(分组)
       
     * @param source
     * @param attrs
     * @return    
       
     * Map<String,List<List<Map<String,Object>>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static Map<String, List<List<Map<String, Object>>>> groupByAttrDeepByObject(List<Map<String, Object>> source, List<String> attrs)
    {
        Map<String, List<List<Map<String, Object>>>> result = new HashMap<String, List<List<Map<String, Object>>>>();
        ArrayListMultimap<String, Map<String, Object>> scoreMultimap = null;
        String keyAttr = "";
        String currentString = "";
        Map<String, Object> currentMap = null;
        ArrayList<List<Map<String, Object>>> tempList = null;
        if (source.size() == 1)
        {
            for (int x = 0, size = attrs.size(); x < size; x++)
            {
                for (int k = 0; k <= x; k++)
                {
                    keyAttr = keyAttr + attrs.get(k);
                    tempList = new ArrayList<List<Map<String, Object>>>(1);
                    tempList.add(source);
                    result.put(keyAttr, tempList);
                }
            }
            return result;
        } else
        {
            for (int x = 0, size = attrs.size(); x < size; x++)
            {
                scoreMultimap = ArrayListMultimap.create();
                for (int k = 0; k <= x; k++)
                {
                    keyAttr = keyAttr + attrs.get(k);
                }
                for (int y = 0, size2 = source.size(); y < size2; y++)
                {
                    currentMap = source.get(y);
                    for (int z = 0; z <= x; z++)
                    {
                        currentString = currentString + currentMap.get(attrs.get(z)).toString();
                    }
                    scoreMultimap.put(currentString, currentMap);
                    currentString = "";
                }
                Multiset<String> set = scoreMultimap.keys();
                tempList = new ArrayList<List<Map<String, Object>>>(set.size());
                for (Multiset.Entry<String> key : set.entrySet())
                {
                    tempList.add(scoreMultimap.get(key.getElement()));
                }
                result.put(keyAttr, tempList);
                keyAttr = "";
            }
            return result;
        }
    }
    
    
    /**
     * 
       
     * groupByAttrByObject(分组)      
       
     * @param source
     * @param attrs
     * @return    
       
     * Map<Map<String,Object>,List<Map<String,Object>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static Map<Map<String, Object>, List<Map<String, Object>>> groupByAttrByObject(List<Map<String, Object>> source, List<String> attrs)
    {
        Map<Map<String, Object>, List<Map<String, Object>>> result = new HashMap<Map<String, Object>, List<Map<String, Object>>>();
        ArrayListMultimap<Map<String, Object>, Map<String, Object>> scoreMultimap = ArrayListMultimap.create();
        int attrsSize = attrs.size();
        int sourceSize = source.size();
        for (int x = 0; x < sourceSize; x++)
        {
            Map<String, Object> map = source.get(x);
            Map<String, Object> mapKey = new HashMap<String, Object>();
            for (int y = 0; y < attrsSize; y++)
            {
                mapKey.put(attrs.get(y), map.get(attrs.get(y)));
            }
            scoreMultimap.put(mapKey, map);
        }
        
        Multiset<Map<String, Object>> set = scoreMultimap.keys();
        for (Multiset.Entry<Map<String, Object>> key : set.entrySet())
        {
            result.put(key.getElement(), scoreMultimap.get(key.getElement()));
        }
        return result;
        
    }
    
    /**
     * 
       
     * groupByMapKeyValueByString(分组)      
       
     * @param source
     * @param attrs
     * @return    
       
     * List<List<Map<String,String>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static List<List<Map<String, String>>> groupByMapKeyValueByString(List<Map<String, String>> source,List<String> attrs)
    {
        
        List<List<Map<String, String>>> resultList = null;
        int sourceSize = source.size();
        int attrsSize = attrs.size();
        String keyAttr = "";
        ArrayListMultimap<String, Map<String, String>> scoreMultimap = ArrayListMultimap.create();
        for (int x = 0; x < sourceSize; x++)
        {
            Map<String, String> map = source.get(x);
            for (int y = 0; y < attrsSize; y++)
            {
                keyAttr = keyAttr + map.get(attrs.get(y));
            }
            scoreMultimap.put(keyAttr, map);
            keyAttr = "";
        }
        Multiset<String> set = scoreMultimap.keys();
        int tempSize = set.elementSet().size();
        resultList = new ArrayList<List<Map<String, String>>>(tempSize);
        for (Multiset.Entry<String> key : set.entrySet())
        {
            resultList.add(scoreMultimap.get(key.getElement()));
        }
        return resultList;
        
    }
    
    
    /**
     * 
       
     * groupByMapKeyValueByObject(分组)      
       
     * @param source
     * @param attrs
     * @return    
       
     * List<List<Map<String,Object>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static List<List<Map<String, Object>>> groupByMapKeyValueByObject(List<Map<String, Object>> source,List<String> attrs)
    {
        
        List<List<Map<String, Object>>> resultList = null;
        int sourceSize = source.size();
        int attrsSize = attrs.size();
        if (sourceSize == 1)
        {
            resultList = new ArrayList<List<Map<String, Object>>>(1);
            resultList.add(source);
            return resultList;
        } else
        {
            String keyAttr = "";
            ArrayListMultimap<String, Map<String, Object>> scoreMultimap = ArrayListMultimap.create();
            for (int x = 0; x < sourceSize; x++)
            {
                Map<String, Object> map = source.get(x);
                for (int y = 0; y < attrsSize; y++)
                {
                    keyAttr = keyAttr + map.get(attrs.get(y));
                }
                scoreMultimap.put(keyAttr, map);
                keyAttr = "";
            }
            Multiset<String> set = scoreMultimap.keys();
            int tempSize = set.elementSet().size();
            resultList = new ArrayList<List<Map<String, Object>>>(tempSize);
            for (Multiset.Entry<String> key : set.entrySet())
            {
                resultList.add(scoreMultimap.get(key.getElement()));
            }
            return resultList;
        }
    }
    
    /**
     * 
       
     * groupByAttrByString(分组)      
       
     * @param source
     * @param attrs
     * @return    
       
     * Map<Map<String,String>,List<Map<String,String>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static Map<Map<String, String>, List<Map<String, String>>> groupByAttrByString(List<Map<String, String>> source, List<String> attrs)
    {
        Map<Map<String, String>, List<Map<String, String>>> result = new HashMap<Map<String, String>, List<Map<String, String>>>();
        ArrayListMultimap<Map<String, String>, Map<String, String>> scoreMultimap = ArrayListMultimap.create();
        Map<String, String> returnMap = null;
        Map<String, String> tempMap = null;
        int attrsSize = attrs.size();
        int sourceSize = source.size();
        String tempString = "";
        if (sourceSize == 1)
        {
            tempMap = source.get(0);
            returnMap = new HashMap<String, String>();
            for (int z = 0; z < attrsSize; z++)
            {
                tempString = attrs.get(z);
                returnMap.put(tempString, tempMap.get(tempString));
            }
            result.put(returnMap, source);
            return result;
        } else
        {
            for (int x = 0; x < sourceSize; x++)
            {
                Map<String, String> map = source.get(x);
                Map<String, String> mapKey = new HashMap<String, String>();
                for (int y = 0; y < attrsSize; y++)
                {
                    mapKey.put(attrs.get(y), map.get(attrs.get(y)));
                }
                scoreMultimap.put(mapKey, map);
            }
            
            Multiset<Map<String, String>> set = scoreMultimap.keys();
            for (Multiset.Entry<Map<String, String>> key : set.entrySet())
            {
                result.put(key.getElement(), scoreMultimap.get(key.getElement()));
            }
            return result;
        }
    }
    
    /**
     * 
       
     * groupByAttrDeepByString(分组)      
       
     * @param source
     * @param attrs
     * @return    
       
     * Map<String,List<List<Map<String,String>>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    public static Map<String, List<List<Map<String, String>>>> groupByAttrDeepByString(List<Map<String, String>> source, List<String> attrs)
    {
        Map<String, List<List<Map<String, String>>>> result = new HashMap<String, List<List<Map<String, String>>>>();
        ArrayListMultimap<String, Map<String, String>> scoreMultimap = null;
        String keyAttr = "";
        String currentString = "";
        Map<String, String> currentMap = null;
        ArrayList<List<Map<String, String>>> tempList = null;
        if (source.size() == 1)
        {
            for (int x = 0, size = attrs.size(); x < size; x++)
            {
                for (int k = 0; k <= x; k++)
                {
                    keyAttr = keyAttr + attrs.get(k);
                    tempList = new ArrayList<List<Map<String, String>>>(1);
                    tempList.add(source);
                    result.put(keyAttr, tempList);
                }
            }
            return result;
        } else
        {
            for (int x = 0, size = attrs.size(); x < size; x++)
            {
                scoreMultimap = ArrayListMultimap.create();
                for (int k = 0; k <= x; k++)
                {
                    keyAttr = keyAttr + attrs.get(k);
                }
                for (int y = 0, size2 = source.size(); y < size2; y++)
                {
                    currentMap = source.get(y);
                    for (int z = 0; z <= x; z++)
                    {
                        currentString = currentString + currentMap.get(attrs.get(z)).toString();
                    }
                    scoreMultimap.put(currentString, currentMap);
                    currentString = "";
                }
                Multiset<String> set = scoreMultimap.keys();
                tempList = new ArrayList<List<Map<String, String>>>(set.elementSet().size());
                for (Multiset.Entry<String> key : set.entrySet())
                {
                    tempList.add(scoreMultimap.get(key.getElement()));
                }
                result.put(keyAttr, tempList);
                keyAttr = "";
            }
            return result;
        }
    }
    
    
    /**
     * 
       
     * groupByAttrDeepByString(分组,接受的非集合类型)      
       
     * @param source
     * @param attrs
     * @return    
       
     * Map<String,List<List<Map<String,String>>>>    返回类型 
          
     * @since  CodingExample　Ver(编码范例查看) 1.1
     */
    @SuppressWarnings({ "unchecked"})
    public static <T>  List<List<T>> groupByObjectAttrValue(List<T> source, List<String> attrs)
    {
        ArrayListMultimap<String, T> scoreMultimap = ArrayListMultimap.create();
        String tempString = "";
        T t = null;
        try
        {
            for (int x = 0, sourceSize = source.size(); x < sourceSize; x++)
            {
                t = source.get(x);
                Class<T> clazz = (Class<T>) t.getClass();
                Field field = null ;
                for (int y = 0, attrsSize = attrs.size(); y < attrsSize; y++)
                {
                    field = clazz.getDeclaredField(attrs.get(y));
                    field.setAccessible(true);
                    tempString = tempString + field.get(t).toString();
                }
                scoreMultimap.put(tempString, t);
                tempString = "";
            }
            Multiset<String> set = scoreMultimap.keys();
            ArrayList<List<T>>  tempList = new ArrayList<List<T>>(set.elementSet().size());
            for (Multiset.Entry<String> key : set.entrySet())
            {
                tempList.add(scoreMultimap.get(key.getElement()));
            }
            return tempList;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
