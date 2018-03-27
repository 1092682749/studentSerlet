package Script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Dome {
    public static void main(String args[]) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("JavaScript");
        engine.eval("var a = 123;print(a)");
        Invocable invocable = (Invocable)engine;
        engine.eval("function a(b,s){b += 12;print(b);print(\"...\"+s);return b}");
        int b=123;
        String s="abc";
        Double d = new Double(123.2);
        Integer dd = d.intValue();
        Double bb= (Double) invocable.invokeFunction("a",new Object[]{b,s});
//        Integer bbb = Integer.parseInt(bb.toString());
        System.out.println("bb is "+bb.toString()+"dd is "+dd);
    }
}
