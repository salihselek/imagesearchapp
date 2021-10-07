package com.example.imagesearchapp.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.imagesearchapp.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(private val repository: UnsplashRepository) :
    ViewModel() {
    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    val photos = currentQuery.switchMap { querySytring ->
        repository.getSearchResults(querySytring).cachedIn(viewModelScope)
    }

    fun searchPhoto(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT_QUERY = "cats"
    }
}