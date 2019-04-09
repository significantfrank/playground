package com.alibaba.craftsman.book.chapter3;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * ShortFunction
 *
 * @author Frank Zhang
 * @date 2019-01-10 1:10 PM
 */
public class ShortFunction {

 /*   private static void copyProperties(Object source, Object target, Class<?> editable, String... ignoreProperties)
            throws BeansException {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
                        "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null ? Arrays.asList(ignoreProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null &&
                            ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            Object value = readMethod.invoke(source);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                        catch (Throwable ex) {
                            throw new FatalBeanException(
                                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                        }
                    }
                }
            }
        }
    }

    private static void copyProperties(Object source, Object target, Class<?> editable, String... ignoreProperties){
        checkSourceAndTarget(source, target, editable);
        copyTargetToSource(source, getPropertyDescriptors(actualEditable));
    }

    private static Class<?> checkSourceAndTarget(Object source, Object target, Class<?> editable) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName() +
                        "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        return actualEditable;
    }


    private static void copyTargetToSource(Object source, PropertyDescriptor[] targetPds) {
        for (PropertyDescriptor targetPd : targetPds) {
            copyProperty(source, targetPd);
        }
    }

    private static void copyProperty(Object source, PropertyDescriptor targetPd) {
        Method writeMethod = getWriteMethodFromTarget(targetPd);
        Method readMethod = getReadMethodFromSource(source, targetPd);
        if (canCopy(writeMethod, readMethod)) {
            doRealCopy(source, targetPd, writeMethod, readMethod);
        }
    }

    private static boolean canCopy(Method writeMethod, Method readMethod) {
        return readMethod != null &&
                ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType());
    }

    public static Method getWriteMethodFromTarget(PropertyDescriptor targetPd){
        return targetPd.getWriteMethod();
    }

    private static Method getReadMethodFromSource(Object source, PropertyDescriptor targetPd){
        PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
        if(sourcePd == null){
            return null;
        }
        return sourcePd.getReadMethod();
    }

    private static void doRealCopy(Object source, PropertyDescriptor targetPd, Method writeMethod, Method readMethod) {
        try {
            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                readMethod.setAccessible(true);
            }
            Object value = readMethod.invoke(source);
            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                writeMethod.setAccessible(true);
            }
            writeMethod.invoke(target, value);
        }
        catch (Throwable ex) {
            throw new FatalBeanException(
                    "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
        }
    }
*/

    public static void main(String[] args) {

    }
}
