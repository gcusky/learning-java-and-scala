package com.gcusky.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lizhy on 2018/9/4.
 */
public class JavaClassOps {

    /**
     * 获取某 Field 上的泛型参数数组类型
     * eg. List 里泛型参数 E 的实际类型
     *
     * @param f Field
     * @return Class[]
     */
    public static Class<?>[] getParameterizedType(Field f) {
        Type fc = f.getGenericType();

        if(fc instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) fc;
            Type[] types = pt.getActualTypeArguments();
            if (types != null && types.length > 0) {
                Class<?>[] classes = new Class<?>[types.length];
                for (int i = 0; i < types.length; i++) {
                    classes[i] = (Class<?>) types[i];
                }
                return classes;
            }
        }
        return null;
    }



    private class ABC{}

    private static class ABCList {

        private List<ABC> lists1;
        private List<ABC> lists2;
        private List<ABC> lists3;
    }

    public static void main(String[] args) {
        ABCList abcList = new ABCList();
        Class clazz = abcList.getClass();
        Field[] fs = clazz.getDeclaredFields();
        for (Field f : fs) {
            for (Class<?> aClass : getParameterizedType(f)) {
                System.out.println(aClass.getSimpleName());
            }
        }
    }
}
