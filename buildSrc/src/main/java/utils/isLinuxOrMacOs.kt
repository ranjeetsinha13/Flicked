package utils

import java.util.Locale

fun isLinuxOrMacOs() = System.getProperty("os.name").toLowerCase(Locale.ROOT) in listOf("linux", "mac os", "macos")