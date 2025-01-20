package com.yujun.randomlottoapp

import android.util.Log
import com.yujun.randomlottoapp.api.LottoService
import com.yujun.randomlottoapp.api.RetrofitInstance
import com.yujun.randomlottoapp.data.LottoData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "LottoController"

class LottoController(private val service: LottoService = RetrofitInstance.service) {
    fun getLottoNumber(num: Int, onSuccess: (LottoData) -> Unit, onError: (String) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {   // launch는 코루틴을 시작하는 함수(코루틴은 비동기 작업을 처리할 때 사용), Dispatcher.Main은 메인 스레드에서 실행(UI 업데이트는 메인 스레드에서만 가능)
            runCatching {   //(try)
                val result = withContext(Dispatchers.IO) { service.getLottoNumber(num = num) }  //withContext(Dispatchers.IO)이부분은  메인 스레드에서 네트워크 작업을 하면 안되기 때문에 IO스레드에서 처리
                onSuccess(result.toLottoData()) // lottoModel에 있는 data 예쁘게 만드는 함수
            }.onFailure {   //(cathc) 비슷한거
                Log.e(TAG, "getLottoNumber() failed! : ${it.message}")
                onError(it.message ?: "Unknown error")
            }
        }
    }
}