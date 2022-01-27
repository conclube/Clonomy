plugins {
    java
}

group = "me.conclure"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
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