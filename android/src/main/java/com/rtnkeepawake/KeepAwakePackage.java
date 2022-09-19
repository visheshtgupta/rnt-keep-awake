// Adapted from
// https://github.com/gijoehosaphat/react-native-keep-screen-on

package com.keepawake;

import androidx.annotation.Nullable;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.module.model.ReactModuleInfo;

import java.util.*;

public class KeepAwakePackage extends TurboReactPackage {

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new KeepAwake(reactContext));
        return modules;
    }
    
    @Nullable
    @Override
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
       if (name.equals(KeepAwake.NAME)) {
          return new KeepAwake(reactContext);
      } else {
          return null;
      }
    }

    // Deprecated RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return new ArrayList<>();
    }

     @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return () -> {
            final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
            moduleInfos.put(
                KeepAwake.NAME, 
                new ReactModuleInfo(
                    KeepAwake.NAME,
                    KeepAwake.NAME,
                    false, // canOverrideExistingModule
                    false, // needsEagerInit
                    true, // hasConstants
                    false, // isCxxModule
                    true // isTurboModule
                )
            );
            return moduleInfos;
        };
    }

}