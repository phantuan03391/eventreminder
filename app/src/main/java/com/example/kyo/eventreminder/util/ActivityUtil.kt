package com.example.kyo.eventreminder.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */

fun addFragmentToActivity(
    fragmentManager: FragmentManager,
    fragment: Fragment, frameId: Int
) {
    checkNotNull(fragmentManager)
    checkNotNull(fragment)
    val transaction = fragmentManager.beginTransaction()
    transaction.add(frameId, fragment)
    transaction.commit()
}

fun hideFragment(fragmentManager: FragmentManager, fragment: Fragment){
    val transaction = fragmentManager.beginTransaction()
    transaction.hide(fragment)
    transaction.commit()
}

fun showFragment(fragmentManager: FragmentManager, fragment: Fragment){
    val transaction = fragmentManager.beginTransaction()
    transaction.show(fragment)
    transaction.commit()
}

/**
 * The `fragment` is added to the container view with id `frameId`. The operation is
 * performed by the `fragmentManager`.
 */
fun AppCompatActivity.addFragmentToActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact { add(frameId, fragment) }
}

/**
 * Run the FragmentTransaction, then call commit()
 */
private fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply(action).commit()
}