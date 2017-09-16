/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.managedprovisioning.preprovisioning;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Wrapper activity around {@link EncryptDeviceActivity} that ensures that the activity is running
 * and in the foreground.
 */
public class TestEncryptionActivity extends EncryptDeviceActivity {

    static EncryptionController sController;
    static Intent sLastLaunchedIntent;

    @Override
    protected EncryptionController getEncryptionController() {
        return sController;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show activity on top of keyguard
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        // Turn on screen to prevent activity being paused by system
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void startActivity(Intent intent) {
        sLastLaunchedIntent = intent;
    }
}
