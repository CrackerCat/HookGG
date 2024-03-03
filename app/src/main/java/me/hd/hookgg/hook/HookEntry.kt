package me.hd.hookgg.hook

import com.highcapable.yukihookapi.YukiHookAPI
import com.highcapable.yukihookapi.annotation.xposed.InjectYukiHookWithXposed
import com.highcapable.yukihookapi.hook.factory.configs
import com.highcapable.yukihookapi.hook.factory.encase
import com.highcapable.yukihookapi.hook.factory.prefs
import com.highcapable.yukihookapi.hook.xposed.proxy.IYukiHookXposedInit
import me.hd.hookgg.BuildConfig
import me.hd.hookgg.MyApp
import me.hd.hookgg.data.ConfigData
import me.hd.hookgg.hook.entry.hooker.GG1011Hooker
import me.hd.hookgg.hook.entry.hooker.GG960Hooker
import me.hd.hookgg.hook.entry.hooker.GG961Hooker
import me.hd.hookgg.hook.utils.ConfigUtil.getSingleChoiceItems

@InjectYukiHookWithXposed(entryClassName = "Entry")
object HookEntry : IYukiHookXposedInit {
    override fun onInit() = configs {
        debugLog {
            tag = BuildConfig.TAG
        }
        //isDebug = BuildConfig.DEBUG
        isDebug = false
    }

    override fun onHook() = encase {
        if (YukiHookAPI.Status.isModuleActive && packageName != BuildConfig.APPLICATION_ID) {
            if (prefs.get(ConfigData.SET_PACKAGE_NAME, "") == packageName) {
                loadApp(packageName) {
                    when (MyApp.context.prefs().get(ConfigData.SET_VERSION_NAME)) {
                        getSingleChoiceItems()[0] -> loadHooker(GG960Hooker)
                        getSingleChoiceItems()[1] -> loadHooker(GG961Hooker)
                        getSingleChoiceItems()[2] -> loadHooker(GG1011Hooker)
                    }
                }
            }
        }
    }
}