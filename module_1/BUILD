load("@rules_android//android:rules.bzl", "android_library")
load("@rules_kotlin//kotlin:android.bzl", "kt_android_library")
load("@rules_kotlin//kotlin:jvm.bzl", "kt_jvm_test", "kt_jvm_library")


kt_android_library(
    name = "greeter_activity",
    custom_package = "com.example.bazel",
    srcs = glob(["src/main/kotlin/**/*.kt"]),
    visibility = ["//visibility:public"],
    manifest = "src/main/AndroidManifest.xml",
    resource_files = ["src/main/res/layout/activity_main.xml", "src/main/res/values/colors.xml", "src/main/res/values/integer.xml", "src/main/res/values/strings.xml"],
    deps = [
            "@maven//:io_reactivex_rxjava2_rxjava",
            "@maven//:io_reactivex_rxjava2_rxkotlin",
            "@maven//:com_github_akarnokd_rxjava2_extensions",
            ]
)

kt_jvm_library(
    name = "greeter_library",
    srcs = glob(["src/main/kotlin/**/*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
            "@maven//:io_reactivex_rxjava2_rxjava",
            "@maven//:io_reactivex_rxjava2_rxkotlin",
            "@maven//:com_github_akarnokd_rxjava2_extensions",
            ]
)

kt_jvm_test(
    name = "greeter_activity_test",
    srcs = glob(["src/test/kotlin/**/*.kt"]),
    test_class = "com.example.bazel.ResultTest",
    deps = [
        ":greeter_library",
        "@maven//:androidx_test_ext_junit",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_robolectric_robolectric",
        "@maven//:org_robolectric_shadows_framework",
        "@robolectric//bazel:android-all",
        "@maven//:org_robolectric_annotations",
        "@maven//:androidx_test_core",
        "@maven//:junit_junit",
    ],
)