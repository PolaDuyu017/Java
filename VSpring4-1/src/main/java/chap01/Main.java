package chap01;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args){
		MavenBuildRunner buildRunner = new MavenBuildRunner();
		buildRunner.setMavenPath("C:\\Program Files\\Java\\apache-maven-3.3.9");
		
		Project sampleProject = new Project();
		List<String> srcDirs = new ArrayList();
		
		srcDirs.add("src");
		srcDirs.add("srcRexources");
		
		sampleProject.setSrcDirs(srcDirs);
		sampleProject.setBinDir("bin");
		sampleProject.setBuildRunner(buildRunner);
		
		sampleProject.build();
	}
}
