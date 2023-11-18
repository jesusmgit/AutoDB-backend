package com.aqua404.autodbbackend.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class Trimmer {

    public static void trimObjectFields(Object obj)  {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try{
            for (Field field : fields) {

                if (field.getType() == String.class){
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(obj);
                    if (fieldValue != null){
                        field.set(obj, fieldValue.trim());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            log.error("Error on accces field" + e);
        }

    }

}
