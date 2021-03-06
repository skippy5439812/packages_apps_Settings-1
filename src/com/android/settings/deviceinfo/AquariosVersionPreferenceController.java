/*
 * Copyright (C) 2017 AquariOS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.text.TextUtils;

import com.android.settings.R;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

public class AquariosVersionPreferenceController extends AbstractPreferenceController implements
        PreferenceControllerMixin {

    private static final String PROPERTY_AQUARIOS_VERSION = "ro.aquarios.version";
    private static final String KEY_AQUARIOS_VERSION = "aquarios_version";

    public AquariosVersionPreferenceController(Context context) {
        super(context);
    }

    @Override
    public boolean isAvailable() {
        return !TextUtils.isEmpty(SystemProperties.get(PROPERTY_AQUARIOS_VERSION));
    }

    @Override
    public String getPreferenceKey() {
        return KEY_AQUARIOS_VERSION;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final Preference pref = screen.findPreference(KEY_AQUARIOS_VERSION);
        if (pref != null) {
            final String summary = SystemProperties.get(PROPERTY_AQUARIOS_VERSION,
                    mContext.getResources().getString(R.string.aquarios_version_default));
            pref.setSummary(summary);
        }
    }
}
