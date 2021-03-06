package com.terapico.utils;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

import com.terapico.caf.DateTime;
import com.terapico.caf.Image;
import com.terapico.caf.Images;
import com.terapico.caf.form.ImageInfo;


public class DataTypeUtil {
	protected static Map<String, Function<Object, Object>> dimensionalHandler = new HashMap<>();
	static {
		dimensionalHandler.put("百分比", DataTypeUtil::getBigDecimal);
		dimensionalHandler.put("天", DataTypeUtil::getBigDecimal);
		dimensionalHandler.put("小时", DataTypeUtil::getBigDecimal);
		dimensionalHandler.put("分钟", DataTypeUtil::getBigDecimal);
		dimensionalHandler.put("秒", DataTypeUtil::getInt);
		dimensionalHandler.put("元", DataTypeUtil::getBigDecimal);
	}

	public static <T> T getValueWithUnit(String unit, Object value) {
		Function<Object, Object> func = dimensionalHandler.get(unit);
		if (func == null){
			System.out.println("[  DataTypeUtil]:不支持的计量单位\"" + unit+"\"");
			return (T)value;
		}
		return (T) func.apply(value);
	}
	public static boolean isMonoType(Object value) {
		if (value == null) {
			return false;
		}
		if  (value instanceof Collection) {
			return false;
		}
		if (value instanceof Map) {
			return false;
		}
		if (value.getClass().isArray()) {
			return false;
		}
		return true;
	}
	// string
	public static String getString(Object value) {
		return getString(value, null);
	}
	public static String getString(Object value, String defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof String) {
				return (String) value;
			}
			return value.toString();
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// string list
	public static List<String> getStringList(Object value) {
		return getStringList(value, null);
	}
	public static List<String> getStringList(Object value, List<String> defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof List) {
				List list = (List) value;
				if (list.isEmpty()){
					return (List<String>) list;
				}
				if (list.stream().anyMatch(it->!(it instanceof String))) {
					return defaultValue;
				}
				return (List<String>) list;
			}
			if (value instanceof String){
				if (TextUtil.isBlank((String)value)){
					return new ArrayList<>();
				}
				String strVal = ((String) value).trim();
				if (strVal.startsWith("[") && strVal.endsWith("]")) {
					List list = DebugUtil.getObjectMapper().readValue((String) value, List.class);
					if (list.isEmpty()) {
						return (List<String>) list;
					}
					if (list.stream().anyMatch(it -> !(it instanceof String))) {
						return defaultValue;
					}
					return (List<String>) list;
				}
				return new ArrayList<>(Arrays.asList(strVal.split("\\s*,\\s*")));
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// int
	public static Integer getInt(Object value) {
		return getInt(value, null);
	}
	public static Integer getInt(Object value, Integer defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof Number) {
				return ((Number) value).intValue();
			}
			if (value instanceof String) {
				return Integer.parseInt((String) value);
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// long
	public static Long getLong(Object value) {
		return getLong(value, null);
	}
	public static Long getLong(Object value, Long defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof Number) {
				return ((Number) value).longValue();
			}
			if (value instanceof String) {
				return Long.parseLong((String) value);
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// boolean
	public static Boolean getBoolean(Object value) {
		return getBoolean(value, null);
	}

	protected static final Set<String> TRUE_WORDS = new HashSet<>(
			Arrays.asList("yes", "true", "ok", "o.k.", "correct", "enable", "enabled", "agree", "right", "agreed"));

	public static Boolean getBoolean(Object value, Boolean defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof Boolean) {
				return (Boolean) value;
			}
			if (value instanceof String) {
				String lowStr = ((String)value).toLowerCase().trim();
				if (TRUE_WORDS.contains(lowStr)) {
					return true;
				}
				return Boolean.parseBoolean(lowStr);
			}
			if (value instanceof Number) {
				return ((Number) value).intValue() != 0;
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// BigDecimal
	public static BigDecimal getBigDecimal(Object value) {
		return getBigDecimal(value, (BigDecimal) null);
	}
	public static BigDecimal getBigDecimal(Object value, String defaultValue) {
		return getBigDecimal(value, string2BigDecimal(defaultValue));
	}
	public static BigDecimal getBigDecimal(Object value, BigDecimal defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof BigDecimal) {
				return (BigDecimal) value;
			}
			if (value instanceof String) {
				if (TextUtil.isBlank((String) value)) {
					return defaultValue;
				}
				return new BigDecimal((String)value);
			}
			if (value instanceof Number) {
				return new BigDecimal(String.valueOf(value));
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	private static BigDecimal string2BigDecimal(String valueStr) {
		if (TextUtil.isBlank(valueStr)) {
			return null;
		}
		return new BigDecimal(valueStr.trim());
	}
	// Date
	public static Date getDate(Object value) {
		return getDate(value, null);
	}
	public static Date getDate(Object value, Date defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof String) {
				return DateTimeUtil.parseInputDateTime((String)value);
			}
			if (value instanceof Number) {
				return new Date(((Number) value).longValue());
			}
			if (value instanceof Date) {
				return (Date) value;
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	public static DateTime getDateTime(Object value) {
		return getDateTime(value, null);
	}
	public static DateTime getDateTime(Object value, Date defaultValue) {
		Date d = getDate(value, defaultValue);
		return d == null ? null : DateTime.fromDate(d);
	}
	// Time
	public static Date getTime(Object value) {
		return getTime(value, null);
	}
	public static Date getTime(Object value, Date defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof String) {
				return DateTimeUtil.parseInputTime((String)value);
			}
			if (value instanceof Number) {
				return new Date(((Number) value).longValue());
			}
			if (value instanceof Date) {
				return (Date) value;
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// string
	public static Images getImages(Object value) {
		return getImages(value, null);
	}
	public static Images getImages(Object value, Images defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof Images) {
				return (Images) value;
			}
			if (value instanceof String) {
				return Images.fromString((String) value);
			}
			if (value instanceof List) {
				return Images.fromString(DebugUtil.dumpAsJson(value, false));
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}
	// ImageInfo
	public static ImageInfo getImageInfo(Object value) {
		return getImageInfo(value, null);
	}
	public static ImageInfo getImageInfo(Object value, ImageInfo defaultValue) {
		try {
			if (value == null) {
				return defaultValue;
			}
			if (value instanceof ImageInfo) {
				return (ImageInfo) value;
			}
			if (value instanceof String) {
				return DebugUtil.getObjectMapper().readValue((String)value, ImageInfo.class);
			}
			if (value instanceof List) {
				Images images = Images.fromString(DebugUtil.dumpAsJson(value, false));
				if (images != null && images.size() > 0){
					Image image = images.get(0);
					ImageInfo rst = new ImageInfo();
					rst.setImageUrl(image.getImageUrl());
					rst.setId(image.getId());
					rst.setContent(image.getTitle());
					return rst;
				}
			}
			return defaultValue;
		}catch (Throwable t) {
			return defaultValue;
		}
	}

	public static boolean isSameClass(Class clazz1, Class clazz2){
		if (clazz1 == clazz2){
			return true;
		}
		if (clazz1 == null || clazz2 == null){
			return false;
		}
		if (clazz1.equals(clazz2)){
			return true;
		}
		if (clazz1.isPrimitive()){
			return comparePrimitiveClass(clazz1, clazz2);
		}
		if (clazz2.isPrimitive()){
			return comparePrimitiveClass(clazz2, clazz1);
		}
		return false;
	}

	private static boolean comparePrimitiveClass(Class clazz1, Class clazz2) {
		if (clazz1.equals(int.class)) {
			return clazz2.equals(Integer.TYPE) || clazz2.equals(Integer.class);
		}
		if (clazz1.equals(float.class)) {
			return clazz2.equals(Float.TYPE) || clazz2.equals(Float.class);
		}
		if (clazz1.equals(double.class)) {
			return clazz2.equals(Double.TYPE) || clazz2.equals(Double.class);
		}
		if (clazz1.equals(char.class)) {
			return clazz2.equals(Character.TYPE) || clazz2.equals(Character.class);
		}
		if (clazz1.equals(short.class)) {
			return clazz2.equals(Short.TYPE) || clazz2.equals(Short.class);
		}
		if (clazz1.equals(boolean.class)) {
			return clazz2.equals(Boolean.TYPE) || clazz2.equals(Boolean.class);
		}
		if (clazz1.equals(byte.class)) {
			return clazz2.equals(Byte.TYPE) || clazz2.equals(Byte.class);
		}
		return false;
	}
}
