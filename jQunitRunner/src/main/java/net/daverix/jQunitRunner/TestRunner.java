package net.daverix.jQunitRunner;

import java.io.IOException;

public class TestRunner {
    private IJavascriptRunner mScriptRunner;
    private IFileImporter mFileImporter;

    public static void main(String[] args) {
        if(args == null || args.length > 0) {
            System.err.println("No parameters provided!");
            return;
        }

        FileImporter fileImporter = new FileImporter();
        JavascriptRunner scriptRunner = new JavascriptRunner();
        TestRunner testRunner = new TestRunner(scriptRunner, fileImporter);

        try {
            testRunner.run(args);
        } catch (JavascriptRunnerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestRunner(IJavascriptRunner scriptRunner, IFileImporter fileImporter) {
        mScriptRunner = scriptRunner;
        mFileImporter = fileImporter;
    }

    public void run(String[] filenames) throws JavascriptRunnerException, IOException {
        StringBuilder builder = new StringBuilder();
        for(String filename : filenames) {
            System.out.println("Importing file " + filename);
            String script = mFileImporter.importFile(filename);
            builder.append(script).append("\n");
        }
        String runnableScript = builder.toString();

        mScriptRunner.runScript(runnableScript);
    }
}