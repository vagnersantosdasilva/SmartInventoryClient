package com.SmartInventoryClient.util;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BeanUtilReflection {
    /*O objetivo dessa classe é preencher um objeto com as propriedades vindas
    * de um retorno de um comando do terminal linux.
    */

    /*BUG  : Quando a lista de propriedades tem apenas um objeto sem repetição , a lista de retorno não é preenchida*/
    private BeanUtils beansUtils = new BeanUtils();
    private String separator;

    public Object returnBean(List<String> lines , Class clazz, String separator){
        try{
            this.separator = separator;
            Field[] fields = clazz.getDeclaredFields();
            Object obj = clazz.newInstance();
            for (int i = 0; i <= lines.size() - 1; i++) {
                for (int j = 0; j <= fields.length - 1; j++) {
                    String key = extractKeyLowerCase(lines.get(i));
                    if (key.equals(fields[j].getName().toLowerCase())) {
                        String value = extractValue(lines.get(i)) ;
                        beansUtils.setProperty(obj, fields[j].getName(), value);
                        break;
                    }
                }
            }
            return obj;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Object> returnListBean(List<String> lines,Class clazz,String separator) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        this.separator=separator;
        List<Object> listObjects = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Object obj = clazz.newInstance();
        int start = 0;
        int count =0;
        int end = firstRepeat(lines)-1;
        if (firstRepeat(lines)-1<=0) end = lines.size()-1;
        for (int i = start ; i<=end;i++){
            for (int j = 0 ; j<=fields.length-1;j++){
                if (extractKeyLowerCase(lines.get(i)).equals(fields[j].getName().toLowerCase())){
                    beansUtils.setProperty(obj,fields[j].getName(),extractValue(lines.get(i)));
                    break;
                }
            }
            if (count==end) {
                end  = end+firstRepeat(lines);
                start = start +firstRepeat(lines);
                listObjects.add(obj);
                obj = clazz.newInstance();
            }
            if (end >=lines.size()) break;
            count++;
        }
        return listObjects;
    }

    private int countLoops(List<String> list){
        int a = firstRepeat(list);
        int loop = 0 ;
        if (a>0)  loop = list.size()/a;
        return loop;
    }

    private int firstRepeat(List<String> list){
        String key = extractKeyLowerCase(list.get(0));
        int count = 0;
        int index = 0 ;
        for (int i=0 ; i<=list.size()-1;i++){
            if  (extractKeyLowerCase(list.get(i)).toLowerCase().equals(key)) count++;
            if (count ==2){
                index = i;
                break;
            }
        }
        return index;
    }

    private String extractValue(String line){
        if (line.split(separator).length==1 ) return "null";
        return line.split(separator)[1].trim();
    }

    private String extractKeyLowerCase(String line){

        return line.split(separator)[0]
                .replace(" ","")
                .replace("\t","")
                .replace("\n","")
                .toLowerCase()
                .trim();
    }
}
