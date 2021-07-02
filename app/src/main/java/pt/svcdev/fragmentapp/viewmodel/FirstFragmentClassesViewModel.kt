package pt.svcdev.fragmentapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pt.svcdev.fragmentapp.model.ClassesModel
import pt.svcdev.fragmentapp.repository.Repository
import pt.svcdev.fragmentapp.view.ClassesState

class FirstFragmentClassesViewModel(private val repository: Repository<List<ClassesModel>>) :
    ViewModel() {

    private val _liveData = MutableLiveData<ClassesState>()
    private val liveData = _liveData

    private val coroutineScope: CoroutineScope = CoroutineScope(
        Dispatchers.Main +
                SupervisorJob() +
                CoroutineExceptionHandler { _, throwable -> handleError(throwable) }
    )

    fun subscribe() = liveData

    fun getData() {
        coroutineScope.launch {
            withContext(Dispatchers.IO) {
                val searchResponse = repository.getData()
                if (!searchResponse.isNullOrEmpty()) {
                    _liveData.postValue(ClassesState.Success(searchResponse))
                } else {
                    _liveData.postValue(
                        ClassesState.Error(
                            Throwable("Search results or total count are null")
                        )
                    )
                }
            }
        }
    }

    private fun handleError(error: Throwable) {
        _liveData.postValue(
            ClassesState.Error(Throwable(error.message ?: "Response is null or unsuccessful"))
        )
    }

    private fun cancelJob() {
        coroutineScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        cancelJob()
        super.onCleared()
    }

}
