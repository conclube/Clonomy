import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    this.id("java-library")
    this.id("com.adarshr.test-logger") version "3.1.0" apply false
    this.id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    this.id("net.kyori.blossom") version "1.3.0" apply false
}
group = "me.conclure"
version = "1.0-SNAPSHOT"

subprojects {
    this.apply(plugin = "java-library")
    this.apply(plugin = "com.adarshr.test-logger")
    this.apply(plugin = "com.github.johnrengelman.shadow")
    this.apply(plugin = "net.kyori.blossom")

    this.repositories {
        this.maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        this.mavenCentral()
    }

    this.dependencies {
        this.testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        this.testImplementation("org.mockito:mockito-core:4.3.1")
        this.testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    this.java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    this.tasks.getByName<JavaCompile>("compileJava") {
        this.options.apply {
            this.release.set(17)
            this.encoding = "UTF-8"
        }
    }

    this.tasks.getByName<Test>("test") {
        this.useJUnitPlatform()
    }

    this.configure<TestLoggerExtension> {
        this.theme = ThemeType.PLAIN
        this.showExceptions = true
        this.showStackTraces = true
        this.showFullStackTraces = true
        this.showCauses = true
        this.slowThreshold = 2000
        this.showSummary = true
        this.showSimpleNames = false
        this.showPassed = true
        this.showSkipped = true
        this.showFailed = true
        this.showStandardStreams = true
        this.showPassedStandardStreams = true
        this.showSkippedStandardStreams = true
        this.showFailedStandardStreams = true
        this.logLevel = LogLevel.LIFECYCLE
    }
}