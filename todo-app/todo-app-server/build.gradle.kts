plugins {
	java
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "io.github.nthduc.springboot"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.data:spring-data-jdbc")
	implementation("org.springframework.data:spring-data-jpa")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.h2database:h2")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper")


	implementation("jakarta.persistence:jakarta.persistence-api")
	implementation("jakarta.transaction:jakarta.transaction-api")
	implementation("jakarta.validation:jakarta.validation-api")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")



	testImplementation("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
