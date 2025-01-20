package com.yujun.randomlottoapp.api

import com.yujun.randomlottoapp.data.LottoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface LottoService {
    @GET("common.do")
    suspend fun getLottoNumber(
        @Query("drwNo") num: Int,
        @Query("method") method: String = "getLottoNumber"
    ): LottoModel
}