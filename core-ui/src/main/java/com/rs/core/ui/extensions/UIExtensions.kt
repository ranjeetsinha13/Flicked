package com.rs.core.ui.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.replace(resId: Int, fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().replace(resId, fragment).commit()
}
