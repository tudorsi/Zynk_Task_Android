package com.zynksoftware.futureup.utils.network

import android.net.ConnectivityManager
import android.net.Network

open class NetworkCallback(private val listener: NetworkConnectivityListener): ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        listener.onConnected()
    }

    override fun onLost(network: Network) {
        listener.onDisconnected()
    }
}