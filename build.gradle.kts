plugins {
    this.id("java-library")
    this.id("io.papermc.paperweight.userdev").version("1.5.5")
    this.id("xyz.jpenilla.run-paper").version("2.2.0")
    this.id("com.github.johnrengelman.shadow").version("8.1.1")
    this.id("net.kyori.blossom").version("2.1.0").apply(false)
}
group = "me.conclure"
version = "1.0-SNAPSHOT"

repositories {
    this.maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    this.mavenCentral()
    this.mavenLocal()
}

java {
    this.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
    this.paperweight.paperDevBundle("1.20.2-R0.1-SNAPSHOT")
    this.implementation("redis.clients:jedis:4.2.0")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")

    this.implementation("com.rabbitmq:amqp-client:5.14.2")
    this.testImplementation(this.platform("org.junit:junit-bom:5.9.1"))
    this.testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks {
    // Configure reobfJar to run when invoking the build task
    this.assemble {
        this.dependsOn(this@tasks.reobfJar)
    }

    this.compileJava {
        this.options.encoding = Charsets.UTF_8.name()
        this.options.release.set(17)
    }
    this.javadoc {
        this.options.encoding = Charsets.UTF_8.name()
    }
    this.processResources {
        this.filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
        val props = mapOf(
            "name" to this.project.name,
            "version" to this.project.version,
            "description" to this.project.description,
            "apiVersion" to "1.20"
        )
        this.inputs.properties(props)
        this.filesMatching("plugin.yml") {
            this.expand(props)
        }
    }

    this.test {
        this.useJUnitPlatform()
    }

    /*
    reobfJar {
      // This is an example of how you might change the output location for reobfJar. It's recommended not to do this
      // for a variety of reasons, however it's asked frequently enough that an example of how to do it is included here.
      outputJar.set(layout.buildDirectory.file("libs/PaperweightTestPlugin-${project.version}.jar"))
    }
     */

    this.shadowJar {
        // helper function to relocate a package into our package
        fun reloc(pkg: String) = relocate(pkg, "io.papermc.paperweight.testplugin.dependency.$pkg")

        // relocate cloud and it's transitive dependencies
        reloc("cloud.commandframework")
        reloc("io.leangen.geantyref")
    }
}