plugins {
    id("java")
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation ("org.mockito:mockito-core:5.12.0")
    testImplementation ("org.mockito:mockito-junit-jupiter:5.12.0")
}

the<JacocoPluginExtension>().toolVersion = "0.8.10"

tasks.test {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport") // Genera el reporte después del test
}

// Configura el reporte de cobertura
tasks.named<JacocoReport>("jacocoTestReport") {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}