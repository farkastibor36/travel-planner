plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.42")
    implementation("org.projectlombok:lombok:1.18.42")
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:4.1.0-M3")
    testCompileOnly("org.projectlombok:lombok:1.18.42")
    implementation("com.mysql:mysql-connector-j:9.5.0")
    implementation("org.springframework.boot:spring-boot-starter:4.0.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:4.0.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:4.0.1")
    implementation("org.springframework.boot:spring-boot-starter-data-rest:4.0.1")
    implementation("org.springframework.boot:spring-boot-starter-web:4.1.0-M2")
    implementation("org.flywaydb:flyway-core:12.1.1")
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    implementation("org.springframework.boot:spring-boot-starter-validation:4.1.0-M3")
    implementation("org.slf4j:slf4j-api:2.0.17")
    testImplementation("org.springframework.boot:spring-boot-starter-test:4.0.1")
}

tasks.test {
    useJUnitPlatform()
}