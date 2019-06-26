package com.topica.annotation.bai1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Target(value = { ElementType.FIELD, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface getNameFieldMethod {
	String value() default "";
}

public class Annotation {
	public static void getNameFieldMethod(Object obj) {
		Class<?> newClass = obj.getClass();
		Field[] fields = newClass.getDeclaredFields();
		Method[] methods = newClass.getDeclaredMethods();

		// get Name of Field
		for (Field fid : fields) {
			getNameFieldMethod field = fid.getAnnotation(getNameFieldMethod.class);
			if (field != null) {
				fid.setAccessible(true);
				System.out.println("Field placed Annotation: " + fid.getName());
			}
		}

		// get Name of Method
		for (Method mt : methods) {
			getNameFieldMethod method = mt.getAnnotation(getNameFieldMethod.class);
			if (method != null) {
				mt.setAccessible(true);
				System.out.println("Method placed Annotation: " + mt.getName());
			}
		}

		// get value of field STATIC FINAL
		for (Field fid : fields) {
			int getModifier = fid.getModifiers();
			if (Modifier.isStatic(getModifier) && Modifier.isFinal(getModifier)) {
				getNameFieldMethod staticFinal = fid.getAnnotation(getNameFieldMethod.class);
				if (staticFinal != null) {
					try {
						System.out.println("Value of Field Static Final " + fid.getName() + " : " + fid.get(obj));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}
}
