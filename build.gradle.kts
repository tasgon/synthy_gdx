import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "me.myself"
version = "1.0-SNAPSHOT"
var gdxVer = "1.9.12"
var ktxVer = "1.9.11-b2"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:$gdxVer")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVer")
    implementation("com.badlogicgames.gdx:gdx-platform:$gdxVer:natives-desktop")
    implementation("io.github.libktx:ktx-app:$ktxVer")
    implementation("io.github.libktx:ktx-scene2d:$ktxVer")
}