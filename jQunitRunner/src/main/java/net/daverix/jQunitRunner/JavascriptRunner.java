package net.daverix.jQunitRunner;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by david.laurell on 2013-09-04.
 *
 * This code is copied from MWL's source code: https://bitbucket.org/pocketmobile/mwl/src/ada018e8d3270087fa37ee5f78ec97a230938bb7/src/Android/BusinessRule/src/se/pocketmobile/mwl/businessrule/RhinoBusinessRuleEngine.java?at=develop
 */
public class JavascriptRunner implements IJavascriptRunner {
    private static final String JAVA_SCRIPT = "javaScript";

    public void runScript(String script) throws JavascriptRunnerException {
        try {
            final Context context = Context.enter();
            context.setOptimizationLevel(-1);
            final ScriptableObject scriptableObject = context.initStandardObjects();
            context.evaluateString(scriptableObject, script, JAVA_SCRIPT, 1, null);
        } catch (Exception e) {
            throw new JavascriptRunnerException("Error calling javascript " + script, e);
        }
    }
}
