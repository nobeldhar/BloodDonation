package com.nobeldhar.blooddonation.broadcasts

interface OTPReceiveListener {

    fun onOTPReceived(otp: String?)

    fun onOTPTimeOut()

    fun onOTPReceivedError(error: String?)
}