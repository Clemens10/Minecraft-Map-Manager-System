plugins {
    id("java")
    id("org.jetbrains.kotlin.plugin.lombok") version "1.7.20"
}

group = "de.clemens"
version = "0.0.0-BETA"

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

    implementation("com.google.code.gson:gson:2.8.6")
    implementation("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

apply(plugin = "org.jetbrains.kotlin.plugin.lombok")