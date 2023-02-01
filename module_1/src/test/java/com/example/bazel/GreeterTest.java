package com.example.bazel;


import static org.assertj.core.api.Assertions.assertThat;

import android.app.Activity;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;

import androidx.test.core.app.ApplicationProvider;

import org.robolectric.annotation.Config;

/**
 * Junit Test using Robolectric with AssertJ matchers.
 */
@RunWith(AndroidJUnit4.class)
public class GreeterTest {

    @Config(packageName = "com.uber.demo.app.id")
    @Test
    public void testConfig() {
        assertThat(ApplicationProvider.getApplicationContext().getPackageName())
                .isEqualTo("com.uber.demo.app.id");
    }

}
