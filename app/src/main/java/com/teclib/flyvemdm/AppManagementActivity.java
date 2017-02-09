/*
 * Copyright (C) 2016 Teclib'
 *
 * This file is part of Flyve MDM Android.
 *
 * Flyve MDM Android is a subproject of Flyve MDM. Flyve MDM is a mobile
 * device management software.
 *
 * Flyve MDM Android is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * Flyve MDM Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * ------------------------------------------------------------------------------
 * @author    Dorian LARGET
 * @copyright Copyright (c) 2016 Flyve MDM
 * @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 * @link      https://github.com/flyvemdm/flyvemdm-android
 * @link      http://www.glpi-project.org/
 * ------------------------------------------------------------------------------
 */

package com.teclib.flyvemdm;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import com.teclib.api.FlyveLog;
import com.teclib.database.SharedPreferenceAction;

import java.util.Iterator;
import java.util.Set;

public class AppManagementActivity extends Activity{

    private Context mContext = null;
    private SharedPreferenceAction mSharedPreferenceAction;

    @SuppressLint("SdCardPath")
    public void onStart(){

        super.onStart();
        mContext = this;
        mSharedPreferenceAction = new SharedPreferenceAction();
        FlyveLog.d("AppManagementActivity");
        String Token = "";
        if(getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.MAIN")){

            FlyveLog.v("UPKDeploy Activity intent exists");
            Token  = "1";
            Set<String> apks = mSharedPreferenceAction.getUpks(mContext);

            for(Iterator<String> it = apks.iterator(); it.hasNext(); ) {
                String apk = it.next();
                AppManagementTask task = new AppManagementTask(this, this, apk,true,Token);
                task.start();
            }
            // TODO check if install failed
            mSharedPreferenceAction.removeUpks(mContext);

            finish();
        }
    }

    public void onCreate(){

    }


}
