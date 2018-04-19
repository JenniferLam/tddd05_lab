package tddd05_lab2;

import java.util.*;
import java.lang.reflect.Constructor;
import java.lang.Object;
import java.lang.reflect.*;
import static java.lang.System.out;
import static java.lang.System.err;

public class Context {

	// *****************************************
	// The roles
	// *****************************************

	private Account SecurityAC;
	private Account SavingsAC;
	private Stock Stock;
	Hashtable<String, Object> roleMap;

	// *****************************************
	// The system operation
	// *****************************************

	public void placeBuyOrder (){
		
		
	}
	
	// *****************************************
	// The execution engine
	// *****************************************

	private Object call(String toRole, String methodname) {
		Object[] args = {};
		return (call(toRole, methodname, args));
	}

	private Object call(String toRole, String methodname, Object[] args) {
		String roleClassName = "Context$" + toRole + "class";
		Class roleClass = null;
		Object roleInstance = null;
		Method roleMethod = null;
		Object dataObject = null;
		Class dataClass = null;
		Method dataMethod = null;
		try {
			// Try to execute role method.
			roleClass = Class.forName(roleClassName);
			Method[] roleMethods = roleClass.getDeclaredMethods();
			for (Method m : roleMethods) {
				if (m.getName() == methodname) {
					roleMethod = m;
				}
			}
			;
			if (roleMethod != null) {
				roleMethod.setAccessible(true);
				Constructor roleConstructor = roleClass.getDeclaredConstructor(Context.class);
				roleConstructor.setAccessible(true);
				roleInstance = roleConstructor.newInstance(this);
				Object result = roleMethod.invoke(roleInstance, new Object[] {});
				return result;
			}
			// No role method. Try to execute instance method.
			dataObject = roleMap.get(toRole);
			dataClass = dataObject.getClass();
			Method[] dataMethods = dataClass.getDeclaredMethods();
			for (Method m : dataMethods) {
				if (m.getName() == methodname) {
					dataMethod = m;
				}
			}
			if (dataMethod == null) {
				System.out.println("call04c " + methodname + " method not found ");
				return (null);
			}
			Object result = dataMethod.invoke(dataObject, args);
			return result;
		} catch (NoSuchMethodException ex4) {
			ex4.printStackTrace();
		} catch (ClassNotFoundException ex5) {
			ex5.printStackTrace();
		} catch (InstantiationException ex6) {
			ex6.printStackTrace();
		} catch (IllegalAccessException ex7) {
			ex7.printStackTrace();
		} catch (InvocationTargetException ex8) {
			ex8.printStackTrace();
		} catch (IllegalArgumentException ex13) {
			ex13.printStackTrace();
		}
		return (null);
	}

}
