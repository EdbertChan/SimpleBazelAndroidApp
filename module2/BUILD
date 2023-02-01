load("@rules_android//android:rules.bzl", "android_library")

android_library(
    name = "empty_library",
    custom_package = "com.example.bazel",
    srcs = glob(["src/main/java/**/*.java"]),
    visibility = ["//visibility:public"],
    manifest = "src/main/AndroidManifest.xml",
    resource_files = glob(["src/main/res/**/*"]),
)
