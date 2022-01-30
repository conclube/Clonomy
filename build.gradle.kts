plugins {
    `java-library`
}

group = "me.conclure"
version = "1.0-SNAPSHOT"

repositories {
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    mavenCentral()
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.mockito:mockito-core:4.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks.getByName<JavaCompile>("compileJava") {
    options.apply {
        release.set(17)
        encoding = "UTF-8"
    }
}