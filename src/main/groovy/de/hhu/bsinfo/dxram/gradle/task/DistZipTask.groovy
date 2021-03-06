package de.hhu.bsinfo.dxram.gradle.task

import org.gradle.api.distribution.plugins.DistributionPlugin
import org.gradle.api.tasks.bundling.Zip

class DistZipTask extends Zip {
    public static final String NAME = "distZip"

    DistZipTask() {
        group = 'distribution'
        description = 'Creates a zip file containing a ready to use distribution'

        dependsOn(DistributionPlugin.TASK_INSTALL_NAME)

        from "${project.outputDir}/${project.name}"
        include '**/*'

        archiveName = "${project.name}.zip"

        destinationDir project.outputDir.startsWith('/') ?
                new File(project.outputDir) : new File(project.projectDir, project.outputDir)
    }
}
