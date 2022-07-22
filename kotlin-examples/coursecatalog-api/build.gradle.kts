import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"

	jacoco
}

group = "com.liuwha"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

// Unit testing configuration
tasks.withType<Test> {
	useJUnitPlatform()
}

// Code Coverage and Report
tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = "0.01".toBigDecimal()
			}
		}
	}
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
	dependsOn(tasks.test)
}

// Integration Test Configuration
val integration by sourceSets.creating
configurations[integration.implementationConfigurationName].extendsFrom(configurations.testImplementation.get())
configurations[integration.runtimeOnlyConfigurationName].extendsFrom(configurations.testRuntimeOnly.get())

val integrationTask = tasks.register<Test>("integration") {
	description = "Runs integration tests."
	group = "verification"
	useJUnitPlatform()

	testClassesDirs = integration.output.classesDirs
	classpath = configurations[integration.runtimeClasspathConfigurationName] + integration.output
}

tasks.check {
	dependsOn(integrationTask)
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// logging
	implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
	runtimeOnly("com.h2database:h2")
	//	runtimeOnly("org.postgresql:postgresql")

	// Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")
	testImplementation("io.mockk:mockk:1.10.4")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	"integrationImplementation"(project)
}