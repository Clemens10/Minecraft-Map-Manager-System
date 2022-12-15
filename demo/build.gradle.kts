plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
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
    mavenLocal()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    //implementation("de.clemens.Minecraft-MapManager-System:api:0.0.0-BETA")
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")

    implementation(
        fileTree("libs/") {
            // You can add as many include or exclude calls as you want
            include("Minecraft-Map-Manager-System-0.0.0-BETA.jar")
        }
    )

}
apply(plugin = "com.github.johnrengelman.shadow")

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
