
plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allure {
    version.set("2.33.0")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.codeborne:selenide:7.14.0")
    compileOnly("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    testCompileOnly("org.projectlombok:lombok:1.18.38")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("org.aeonbits.owner:owner:1.0.12")
    implementation("io.rest-assured:rest-assured:6.0.0")
    implementation("org.apache.logging.log4j:log4j-core:2.25.3")
    implementation("org.slf4j:slf4j-api:2.0.17")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.25.3")
    implementation("org.apache.logging.log4j:log4j-api:2.25.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.21.2")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("commons-dbutils:commons-dbutils:1.8.1")
    implementation("io.github.bonigarcia:webdrivermanager:6.3.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("io.qameta.allure:allure-junit5:2.33.0")
    implementation("io.github.bonigarcia:webdrivermanager:6.3.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Test>("regressionTest") {
    useJUnitPlatform {
        includeTags("RegressionDB")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    outputs.upToDateWhen { false }
}

tasks.register<Test>("e2eTest") {
    useJUnitPlatform {
        includeTags("E2E")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    outputs.upToDateWhen { false }
}

tasks.register<Test>("smokeUIAndApiTest") {
    useJUnitPlatform {
        includeTags("SmokeUI | API")
    }
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    outputs.upToDateWhen { false }
}
