load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

android_sdk_repository(
    name = "androidsdk",
    api_level = 33,
    build_tools_version = "33.0.0",
)

android_ndk_repository(
    name = "androidndk",
    api_level = 33,
)

http_archive(
    name = "rules_android",
    sha256 = "cd06d15dd8bb59926e4d65f9003bfc20f9da4b2519985c27e190cddc8b7a7806",
    strip_prefix = "rules_android-0.1.1",
    urls = ["https://github.com/bazelbuild/rules_android/archive/v0.1.1.zip"],
)

http_archive(
    name = "robolectric",
    sha256 = "7e007fcfdca7b7228cb4de72707e8b317026ea95000f963e91d5ae365be52d0d",
    strip_prefix = "robolectric-bazel-4.9.2",
    urls = ["https://github.com/robolectric/robolectric-bazel/archive/4.9.2.tar.gz"],
)

load("@robolectric//bazel:robolectric.bzl", "robolectric_repositories")

robolectric_repositories()

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-4.5",
    sha256 = "b17d7388feb9bfa7f2fa09031b32707df529f26c91ab9e5d909eb1676badd9a6",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.5.zip",
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "androidx.appcompat:appcompat:1.0.2",
        "androidx.annotation:annotation:1.1.0",
        "androidx.test.ext:junit:1.1.0",
        "org.robolectric:robolectric:4.9.2",
        "org.assertj:assertj-core:3.12.1",
        "io.reactivex.rxjava2:rxandroid:aar:2.1.1",
        "io.reactivex.rxjava2:rxjava:jar:2.2.12",
        "io.reactivex.rxjava2:rxkotlin:jar:2.2.0",
        "io.reactivex:rxandroid:aar:1.2.1",
        "io.reactivex:rxjava-async-util:jar:0.21.0",
        "io.reactivex:rxjava-file-utils:jar:0.1.4",
        "io.reactivex:rxjava:jar:1.3.8",
        "com.github.akarnokd:rxjava2-extensions:jar:0.20.10",
        "com.github.akarnokd:rxjava2-interop:jar:0.13.7",
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_kotlin_version = "1.9.0"
rules_kotlin_sha = "5766f1e599acf551aa56f49dab9ab9108269b03c557496c54acaf41f98e2b8d6"
http_archive(
    name = "rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin-v%s.tar.gz" % (rules_kotlin_version, rules_kotlin_version)],
    sha256 = rules_kotlin_sha,
)

load("@rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

load("@rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
kt_register_toolchains() # to use the default toolchain, otherwise see toolchains below