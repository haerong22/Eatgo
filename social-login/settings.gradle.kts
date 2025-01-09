plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "social-login"
include("app")
include("controller")
include("application")
include("domain")
include("gateway")
include("gateway:social")
include("gateway:db")