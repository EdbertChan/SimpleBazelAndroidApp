This is a branch that shows that Bazel cannot compile "com.google.android.material:material:1.7.0" 

How to reproduce:

1) Open repository
2) Run bazel build //:app
3) Observe following error message:

ERROR: /private/var/tmp/_bazel_edbert/be4858b858e53fdee59025cce739e91f/external/maven/BUILD:939:11: Merging compiled Android resources for @maven//:com_google_android_material_material failed: (Exit 1): ResourceProcessorBusyBox failed: error executing command (from target @maven//:com_google_android_material_material) bazel-out/darwin_arm64-opt-exec-2B5CBBC6/bin/external/bazel_tools/src/tools/android/java/com/google/devtools/build/android/ResourceProcessorBusyBox --tool MERGE_COMPILED -- --classJarOutput ... (remaining 15 arguments skipped)

Use --sandbox_debug to see verbose messages from the sandbox and retain the sandbox build root for debugging
Jan 26, 2023 12:41:06 PM com.google.devtools.build.android.AndroidCompiledResourceMergingAction main
SEVERE: Unexpected
java.lang.NullPointerException: Null type
	at com.google.devtools.build.android.AutoValue_ResourceName.<init>(AutoValue_ResourceName.java:24)
	at com.google.devtools.build.android.ResourceName.create(ResourceName.java:42)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.consumeResourceTable(AndroidCompiledDataDeserializer.java:291)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.read(AndroidCompiledDataDeserializer.java:672)
	at com.google.devtools.build.android.SerializedAndroidData.deserialize(SerializedAndroidData.java:108)
	at com.google.devtools.build.android.AndroidResourceMerger.mergeCompiledData(AndroidResourceMerger.java:202)
	at com.google.devtools.build.android.AndroidCompiledResourceMergingAction.main(AndroidCompiledResourceMergingAction.java:231)
	at com.google.devtools.build.android.ResourceProcessorBusyBox$Tool$3.call(ResourceProcessorBusyBox.java:85)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.processRequest(ResourceProcessorBusyBox.java:251)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.main(ResourceProcessorBusyBox.java:181)

Jan 26, 2023 12:41:06 PM com.google.devtools.build.android.ResourceProcessorBusyBox processRequest
SEVERE: Error during processing
java.lang.NullPointerException: Null type
	at com.google.devtools.build.android.AutoValue_ResourceName.<init>(AutoValue_ResourceName.java:24)
	at com.google.devtools.build.android.ResourceName.create(ResourceName.java:42)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.consumeResourceTable(AndroidCompiledDataDeserializer.java:291)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.read(AndroidCompiledDataDeserializer.java:672)
	at com.google.devtools.build.android.SerializedAndroidData.deserialize(SerializedAndroidData.java:108)
	at com.google.devtools.build.android.AndroidResourceMerger.mergeCompiledData(AndroidResourceMerger.java:202)
	at com.google.devtools.build.android.AndroidCompiledResourceMergingAction.main(AndroidCompiledResourceMergingAction.java:231)
	at com.google.devtools.build.android.ResourceProcessorBusyBox$Tool$3.call(ResourceProcessorBusyBox.java:85)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.processRequest(ResourceProcessorBusyBox.java:251)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.main(ResourceProcessorBusyBox.java:181)

Exception in thread "main" java.lang.NullPointerException: Null type
	at com.google.devtools.build.android.AutoValue_ResourceName.<init>(AutoValue_ResourceName.java:24)
	at com.google.devtools.build.android.ResourceName.create(ResourceName.java:42)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.consumeResourceTable(AndroidCompiledDataDeserializer.java:291)
	at com.google.devtools.build.android.AndroidCompiledDataDeserializer.read(AndroidCompiledDataDeserializer.java:672)
	at com.google.devtools.build.android.SerializedAndroidData.deserialize(SerializedAndroidData.java:108)
	at com.google.devtools.build.android.AndroidResourceMerger.mergeCompiledData(AndroidResourceMerger.java:202)
	at com.google.devtools.build.android.AndroidCompiledResourceMergingAction.main(AndroidCompiledResourceMergingAction.java:231)
	at com.google.devtools.build.android.ResourceProcessorBusyBox$Tool$3.call(ResourceProcessorBusyBox.java:85)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.processRequest(ResourceProcessorBusyBox.java:251)
	at com.google.devtools.build.android.ResourceProcessorBusyBox.main(ResourceProcessorBusyBox.java:181)
Target //:app failed to build
Use --verbose_failures to see the command lines of failed build steps.
INFO: Elapsed time: 29.496s, Critical Path: 3.61s
INFO: 219 processes: 8 internal, 211 darwin-sandbox.
FAILED: Build did NOT complete successfully
