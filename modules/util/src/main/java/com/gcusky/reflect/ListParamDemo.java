package com.gcusky.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by lizhy on 2018/9/4.
 */
public class ListParamDemo {
    class WriteTextVo {
        public WriteTextVo(int x) {
            this.x = x;
        }

        private int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
    class RectangleVo {
        public RectangleVo(int x) {
            this.x = x;
        }

        private int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
    class BarCodeVo {
        public BarCodeVo(int x) {
            this.x = x;
        }

        private int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
    class LineVo {
        public LineVo(int x) {
            this.x = x;
        }

        private int x;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    public static class PdfFactory {
        private List<WriteTextVo> writeTextVos;
        private List<RectangleVo> rectangleVos;
        private List<BarCodeVo> barCodeVos;
        private List<LineVo> lineVos;
    }

    public static void main(String[] args) {
        PdfFactory pdfFactory = new PdfFactory();

        Class clazz = pdfFactory.getClass();

        Field[] fs = clazz.getDeclaredFields();
        for (Field f : fs) {
            // 得到成员变量的类型 --> 那4个声明变量的类型 --> List<E>
            Class fieldType =f.getType();
            String typeName = fieldType.getName();
            System.out.println(typeName);
            String fieldName = f.getName();
            System.out.println(fieldName);
            // 得到List里的通用类型 -> List 里泛型参数E的实际类型
            // getType 只能得到接口类型，而 getGenericType 还能得到泛型的参数类型
            ParameterizedType pt = (ParameterizedType) f.getGenericType();
            Class paramType =  (Class) pt.getActualTypeArguments()[0];
            System.out.println(paramType.getSimpleName());
            System.out.println("++++++++++++");
        }
    }
}
