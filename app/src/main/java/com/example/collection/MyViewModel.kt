package com.example.collection

import androidx.lifecycle.ViewModel
import com.example.collection.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * 正常來說 沒有注入的情況下ViewModel如果要擁有Repository，
 * 那麼他必須使用ViewModelFactory，
 * 然後ViewModelFactory必須從MainActivity拿到Context之後，
 * 才可以告訴ViewModelFactory來定義如何通過構造函數參數來創建ViewModel
 * */

/**
 * 現在可以透過Hilt來解決這個問題 使用@Inject constructor() 來把所有構造參數注入到ViewModel中
 * 因為有@HiltViewModel 他就會去找@Module註釋下的檔案(AppModule)看是否能找到這些內容
 * */
@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

}