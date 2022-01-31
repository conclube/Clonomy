import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    id("java-library")
    id("com.adarshr.test-logger") version "3.1.0" apply false
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
    id("net.kyori.blossom") version "1.3.0" apply false
}
group = "me.conclure"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.adarshr.test-logger")
    apply(plugin = "com.github.johnrengelman.shadow")
    apply(plugin = "net.kyori.blossom")

    repositories {
        maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        mavenCentral()
    }

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
        testImplementation("org.mockito:mockito-core:4.3.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

    tasks.getByName<JavaCompile>("compileJava") {
        options.apply {
            release.set(17)
            encoding = "UTF-8"
        }
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }

    configure<TestLoggerExtension> {
        theme = ThemeType.PLAIN
        showExceptions = true
        showStackTraces = true
        showFullStackTraces = true
        showCauses = true
        slowThreshold = 2000
        showSummary = true
        showSimpleNames = false
        showPassed = true
        showSkipped = true
        showFailed = true
        showStandardStreams = true
        showPassedStandardStreams = true
        showSkippedStandardStreams = true
        showFailedStandardStreams = true
        logLevel = LogLevel.LIFECYCLE
    }
}