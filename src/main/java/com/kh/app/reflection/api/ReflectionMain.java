package com.kh.app.reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * reflect : 투영하다, 반사하다
 * 
 * - 클래스객체를 통해서 클래스 정보를 열람. 객체 생성, 메소드 호출, 필드값 제어 처리 가능
 */
public class ReflectionMain {

	public static void main(String[] args) throws Exception {
		ReflectionMain main = new ReflectionMain();
//		main.test1();
//		main.test2();
		main.test3();
	}

	/**
	 * 필드제어
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchFieldException 
	 */
	private void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, NoSuchFieldException {
		Class<Sample> clz = (Class<Sample>) Class.forName("com.kh.app.reflection.api.Sample");
		Sample sample = clz.getDeclaredConstructor(int.class, String.class).newInstance(123, "Wow");
		Field num = clz.getDeclaredField("num");
		System.out.println(num);
		
		num.setAccessible(true);//private 필드에 접근 가능하도록 설정, 설정하지 않으면 접근불가 예외발생		
		Object value = num.get(sample);
		System.out.println(value);
		
		System.out.println(sample);
	}

	/**
	 * 메소드 제어
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void test2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<Sample> clz = Sample.class;//제네릭 설정 안해주면 37번 줄에서 형변환 해줘야됨
		Method[] methods =  clz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
		//메소드 하나 가져오기
		Sample sample = clz.getDeclaredConstructor(null).newInstance(null);
		Method setNum = clz.getDeclaredMethod("setNum", int.class);//이름, 타입으로 정확히 하나의 메소드를 찾을 수 있음
		Object returnValue = setNum.invoke(sample, 123);
		System.out.println(returnValue);
		
		Method getNum = clz.getDeclaredMethod("getNum");
		Object returnVal = getNum.invoke(sample);//invoke = 호출
		System.out.println(returnVal);

		System.out.println(sample);
	}

	/**
	 * 객체 생성
	 * 
	 * 클래스객체
	 * - 클래스당 하나씩 만들어지는 객체로, 클래스의 모든 정보를 가지고 있다.
	 * - new연산자 호출시에도 이 클래스객체를 베이스로 객체가 생성된다.
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//기존 방법
		Sample s1 = new Sample();
		
		//reflection api 이용
		Class clz1 = Sample.class;
		Class clz2 = s1.getClass();
		Class clz3 = Class.forName("com.kh.app.reflection.api.Sample");//프로그램 실행시에 동적으로 문자열을 받아서 사용할 수 있다 => 무슨 클래스를 사용해야 하는지 모르는 상황에서 활용가능
																	// 동적으로 객체 타입이 결정되어야 하는 상황에서 쓸 수 있는 유일한 방법임.
		System.out.println(clz1 == clz2);
		System.out.println(clz1 == clz3);
		
		Constructor<Sample> const1 = clz1.getDeclaredConstructor(null);//null을 전달하면 기본생성자를 의미
		Sample s2 = const1.newInstance(null);//기본생성자이므로 초기화 인자도 null
		System.out.println(s2);//Sample [num=0, str=null]
		
		Class[] parameterTypes = {int.class, String.class};
		Constructor<Sample> const2 = clz1.getDeclaredConstructor(parameterTypes);//매개변수 있는 생성자 받기
//		Constructor<Sample> const2 = clz1.getDeclaredConstructor(int.class, String.class);//위와 동일
		Object[] initArgs = {100, "helloworld"};
		Sample s3 = const2.newInstance(initArgs);
//		Sample s3 = const2.newInstance(100, "helloworld");//위와 동일
		System.out.println(s3);//Sample [num=100, str=helloworld]
		
	}

}
