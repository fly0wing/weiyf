/**
 * 
 */
package cn.org.rapid_framework.plugins.gen;

import java.io.File;
import java.io.IOException;

import cn.org.rapid_framework.generator.GeneratorProperties;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * 代码生成器插件的主要goal
 * 
 * @author hunhun
 * @goal gen
 */
public class GeneratorByTableMojo extends AbstarctGeneratorMojo {

	/**
	 * -Dtable=* -Dtable=user_info
	 * 
	 * @parameter expression="${table}"
	 * 
	 */
	public String tableParameter;


	private GeneratorFacade g;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.maven.plugin.Mojo#execute()
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {

		Thread currentThread = Thread.currentThread();
		ClassLoader oldClassLoader = currentThread.getContextClassLoader();

		try {
            currentThread.setContextClassLoader(getClassLoader());
            System.out.println("current project to build: "
                    + getProject().getName() + "\n"
                    + getProject().getFile().getParent());
            g = new GeneratorFacade();
            GeneratorProperties.load(absolutePath("./mygenerator.properties"));
            g.getGenerator().setOutRootDir(GeneratorProperties.getProperty("outRoot"));

            if ( g.getGenerator().getOutRootDir().startsWith("./")) {
                g.getGenerator().setOutRootDir(absolutePath(g.getGenerator().getOutRootDir()));
            }
            String[] templateDirs =parseStringArray( GeneratorProperties.getProperty("templateRootDirs" ));
            for (int i = 0; i < templateDirs.length; i++) {
                templateDirs[i] = absolutePath(templateDirs[i]);
            }
            g.getGenerator().setTemplateRootDirs( templateDirs);//("classpath:template");

            String tables = tableParameter==null || tableParameter.trim().length()==0 ? null : tableParameter;
            if( tables==null){
                tables= GeneratorProperties.getProperty("tables");
            }
            genByTable( parseStringArray( tables ));
        }catch(Exception e){
            e.printStackTrace();
		} finally {
			currentThread.setContextClassLoader(oldClassLoader);
		}
	}
    public String absolutePath(  String path){
        String projectBaseDir = getProject().getBasedir().getAbsolutePath();
        if(path==null) return projectBaseDir;
        if( path.startsWith("./") ){
          return  new File(  getProject().getBasedir() , path.substring(2)).getAbsolutePath();
        }
        return path;
    }




	public void genByTable(String... table) {
		try {
			g.generateByTable(table);
			MojoUtil.openFileIfOnWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
