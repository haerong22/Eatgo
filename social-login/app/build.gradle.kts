plugins {
    id("kotlin-conventions")
    id("springboot-conventions")
}

dependencies {
    implementation(project(":controller"))
}