plugins {
    id("java")
    id("org.jetbrains.kotlin.plugin.lombok") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {

    compileOnly("com.google.code.gson:gson:2.10")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

apply(plugin = "org.jetbrains.kotlin.plugin.lombok")