package com.yujun.randomlottoapp.data

private const val EMPTY_STRING = "-"

data class LottoData(
    val gameNumber: String = EMPTY_STRING,  // 게임 번호를 저장
    val winNumbers: List<String> = emptyList(), // 당첨 번호를 저장하는 리스트
    val bonusNumber: String = EMPTY_STRING, // 보너스 번호를 저장
    val totalWinPrize: String = EMPTY_STRING,   // 총 당첨금을 저장
    val winPrize: String = EMPTY_STRING,    // 각 당첨자가 받는 금액
    val winnerCount: String = EMPTY_STRING, // 당첨자 수
    val data: String = EMPTY_STRING // 기타 데이터를 저장
)