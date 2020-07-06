import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("org.jetbrains.kotlin.kapt") version "1.3.71"
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.71"
}

allprojects {
    repositories {
        jcenter()
    }
}

apply(plugin = "kotlin")
apply(plugin = "kotlin-kapt")
apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")

group = "news.app"
version = "1.0.0"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    /**
     * @see <a href="https://kotlinlang.org/docs/reference/kapt.html">Annotation Processing with Kotlin</a>
     */
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
        dependsOn(processResources)
    }


    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
}