This branch demonstrates a bug where Bazel does not pick up some transitive toolchain dependencies when setting up rules

# Compile and run with Java 11 by default
Reproduction steps

1) Download bazel-7.3.1
2) Delete the existing bazelcache!
3) Run bazel build //... --experimental_repository_resolved_file=experimental_repository_resolved_file.json --build_event_json_file=bej.json
4) Observe that in neither experimental_repository_resolved_file.json nor bej.json contains many of the URL requests from https://github.com/bazelbuild/rules_android/blob/v0.5.0/prereqs.bzl

Including:
"https://github.com/protocolbuffers/protobuf/archive/v3.19.1.tar.gz"
"https://github.com/bazelbuild/java_tools/releases/download/java_v11.8/java_tools-v11.8.zip"
"https://github.com/abseil/abseil-py/archive/refs/tags/v1.4.0.tar.gz"

# I see "https://github.com/bazelbuild/bazel-skylib/releases/download/1.3.0/bazel-skylib-1.3.0.tar.gz". Is it just the android rules or usage of those rules?

Bazel-skylib is brought in by Bazel tools, not jvm_rules_external. In fact, if you search experimental_repository_resolved_file.json, you'll see that the only calls that are tracked are from "original_rule_class": "@@rules_jvm_external//:coursier.bzl%pinned_coursier_fetch" which is from maven_install. 

In fact, if you open the WORKSPACE of rules_jvm_external 4.5, there is this line:

http_archive(
name = "io_bazel_stardoc",
sha256 = "3fd8fec4ddec3c670bd810904e2e33170bedfe12f90adf943508184be458c8bb",
urls = [
"https://mirror.bazel.build/github.com/bazelbuild/stardoc/releases/download/0.5.3/stardoc-0.5.3.tar.gz",
"https://github.com/bazelbuild/stardoc/releases/download/0.5.3/stardoc-0.5.3.tar.gz",
],
)

Neither of the stardoc urls show up either in either bej.json or experimental_respoistory_resolved_file.json.

# Isn't Bazel just lazy? 

Yes it is. Let's explicitly a url that isn't being used with the "--experimental_downloader_config".

bazel build //:app --experimental_repository_resolved_file=experimental_repository_resolved_file_strict.json --build_event_json_file=bej_strict.json --experimental_downloader_config=strict_downloader.cfg

We can see that the build will succeed, even though robolectric is indeed used in our codebase. It just is not in our transitive graph.

bazel build //... --experimental_repository_resolved_file=experimental_repository_resolved_file_strict.json --build_event_json_file=bej_strict.json --experimental_downloader_config=strict_downloader.cfg

It will fail.