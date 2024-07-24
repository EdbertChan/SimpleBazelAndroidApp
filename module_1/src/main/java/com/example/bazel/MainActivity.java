package com.example.bazel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.function.Function;

/**
 * Main class for the Bazel Android "Hello, World" app.
 */
public class MainActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Function<String, Integer> stringLength = s -> s.length();
    Log.v("Bazel_234", String.valueOf(stringLength.apply("HELLOSTRING")));


    setContentView(R.layout.activity_main);

    Button clickMeButton = findViewById(R.id.clickMeButton);
    TextView helloBazelTextView = findViewById(R.id.helloBazelTextView);

    Greeter greeter = new Greeter();

    // Bazel supports Java 8 language features like lambdas!
    clickMeButton.setOnClickListener(v -> helloBazelTextView.setText(greeter.sayHello()));
  }
}
