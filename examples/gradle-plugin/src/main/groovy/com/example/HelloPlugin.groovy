package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A simple variation of the example plugin from the <a href="https://docs.gradle.org/current/userguide/custom_plugins.html">gradle docs</a>
 * that writes {@code hello-world.txt} as well as outputting to the console.
 */
class HelloPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('hello') << {
            def file = new File("${project.getProperty('buildDir')}/hello-world.txt")
            if (file.exists()) {
                file.delete()
            }
            file.parentFile.mkdirs();
            file.createNewFile()
            file.write("Hello, plugins!\n")
            file.readLines().each { println(it) }
        }
    }
}
