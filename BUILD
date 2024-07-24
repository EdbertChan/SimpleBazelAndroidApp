exports_files(["bazel-proguard-project.pro"])

android_binary(
    name = "app",
    custom_package = "com.example.bazel",
    manifest = "AndroidManifest.xml",
    deps = ["//module_1:greeter_activity"],

    manifest_values = {
         "debuggable": "false",
         },
    proguard_specs = [
        "//proguard:bazel-proguard-project.pro",
    ],
)
