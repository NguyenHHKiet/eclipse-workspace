package table.bind;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

/**
 * request parameter 를 특정 Class 의 field 로 값을 주입
 * 
 * @author william
 *
 */
public class ServletRequestDataBinder {
	public static Object bind(ServletRequest request, Class<?> dataType, String dataName) throws Exception {
		if (isPrimitiveType(dataType)) {
			return createValueObject(dataType, request.getParameter(dataName));
		}

		// 객체(Member를 request에서 찾아 객체 생성 후 변수값을 설정해 반환
		Set<String> paramNames = request.getParameterMap().keySet();
		Object dataObject = dataType.getDeclaredConstructor().newInstance();
		Method m = null;

		// Setter 를 호출해서 객체(Member)의 변수값을 설정
		for (String paramName : paramNames) {
			// System.out.println(paramName);
			// setter를 찾음
			// dataType Object의 set함수를 파라미터 값으로 찾는다.
			m = findSetter(dataType, paramName);
			// setter함수라면
			if (m != null) {
				// setter 실행
				// set메소드.invoke(set메소드가 호출되는 객체, set메소드의 매개변수)
				m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], request.getParameter(paramName)));
			}
		}
		return dataObject;
	}

	private static boolean isPrimitiveType(Class<?> type) {
		if (type.getName().equals("int") || type == Integer.class || type.getName().equals("long") || type == Long.class
				|| type.getName().equals("float") || type == Float.class || type.getName().equals("double")
				|| type == Double.class || type.getName().equals("boolean") || type == Boolean.class
				|| type == Date.class || type == String.class) {
			return true;
		}
		return false;
	}

	private static Object createValueObject(Class<?> type, String value) {
		if (type.getName().equals("int") || type == Integer.class) {
			return Integer.valueOf(value);
		} else if (type.getName().equals("float") || type == Float.class) {
			return Float.valueOf(value);
		} else if (type.getName().equals("double") || type == Double.class) {
			return Double.valueOf(value);
		} else if (type.getName().equals("long") || type == Long.class) {
			return Long.valueOf(value);
		} else if (type.getName().equals("boolean") || type == Boolean.class) {
			return Boolean.valueOf(value);
		} else if (type == Date.class) {
			return java.sql.Date.valueOf(value);
		} else {
			return value;
		}
	}

	private static Method findSetter(Class<?> type, String name) {
		Method[] methods = type.getMethods();

		String propName = null;
		for (Method m : methods) {
			if (!m.getName().startsWith("set"))
				continue;

			propName = m.getName().substring(3);
			if (propName.toLowerCase().equals(name.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
