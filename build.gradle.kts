plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    application
}

group = "moe.kadosawa"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("moe.kadosawa.aoc.AppKt")
}
