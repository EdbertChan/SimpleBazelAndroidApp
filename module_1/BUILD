load("@rules_android//android:rules.bzl", "android_library")

android_library(
    name = "greeter_activity",
    custom_package = "com.example.bazel",
    srcs = glob(["src/main/java/**/*.java"]),
    visibility = ["//visibility:public"],
    manifest = "src/main/AndroidManifest.xml",
    resource_files = glob(["src/main/res/**/*"]),
)

android_local_test(
    name = "greeter_activity_test",
    srcs = glob(["src/test/java/**/*.java"]),
    custom_package = "com.example.bazel",
    manifest = "src/test/AndroidManifest.xml",
    test_class = "com.example.bazel.GreeterTest",
    deps = [
        ":greeter_activity",
        "@maven//:androidx_test_ext_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_robolectric_robolectric",
        "@maven//:org_robolectric_shadows_framework",
        "@robolectric//bazel:android-all",
        "@maven//:org_robolectric_annotations",
        "@maven//:androidx_test_core"
    ],
)