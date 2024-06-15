plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

group = "com.cbsingh"
version = "1.0-SNAPSHOT"
description = "DailyCodingProblems"
java.sourceCompatibility = JavaVersion.VERSION_21

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}


publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
