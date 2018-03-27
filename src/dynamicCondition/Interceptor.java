package dynamicCondition;

import javassist.compiler.MemberResolver;

import java.lang.reflect.Method;

public interface Interceptor {
    public boolean before(Object proxy,Object target,Method method,Object[] objects);
    public void around(Object proxy, Object target, Method method,Object[] objects);
    public void after(Object proxy,Object target,Method method,Object[] objects);
}
