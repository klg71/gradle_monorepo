import org.gradle.api.Plugin
import org.gradle.api.Project

class DockerBuildPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.tasks.register("dockerBuild") {
            it.doLast {
                project.exec {
                    it.workingDir("src/main/docker")
                    it.commandLine("docker", "build", ".", "-t", project.name)
                }
            }
        }
    }
}
